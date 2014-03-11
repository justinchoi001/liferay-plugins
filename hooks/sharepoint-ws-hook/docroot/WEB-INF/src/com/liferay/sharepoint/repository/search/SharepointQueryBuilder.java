/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.sharepoint.repository.search;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.RepositoryException;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.QueryTerm;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.WildcardQuery;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.repository.external.ExtRepositoryObjectType;
import com.liferay.repository.external.search.ExtRepositoryQueryMapper;
import com.liferay.sharepoint.connector.SharepointConnection;
import com.liferay.sharepoint.connector.SharepointConnectionInfo;
import com.liferay.sharepoint.connector.SharepointObject;
import com.liferay.sharepoint.connector.schema.query.QueryClause;
import com.liferay.sharepoint.connector.schema.query.QueryField;
import com.liferay.sharepoint.connector.schema.query.QueryOptionsList;
import com.liferay.sharepoint.connector.schema.query.QueryValue;
import com.liferay.sharepoint.connector.schema.query.join.AndJoin;
import com.liferay.sharepoint.connector.schema.query.operator.BeginsWithOperator;
import com.liferay.sharepoint.connector.schema.query.operator.ContainsOperator;
import com.liferay.sharepoint.connector.schema.query.operator.EqOperator;
import com.liferay.sharepoint.connector.schema.query.operator.GeqOperator;
import com.liferay.sharepoint.connector.schema.query.operator.GtOperator;
import com.liferay.sharepoint.connector.schema.query.operator.LeqOperator;
import com.liferay.sharepoint.connector.schema.query.operator.LtOperator;
import com.liferay.sharepoint.connector.schema.query.operator.NeqOperator;
import com.liferay.sharepoint.connector.schema.query.option.FolderQueryOption;
import com.liferay.sharepoint.repository.SharepointWSRepository;
import com.liferay.sharepoint.repository.model.SharepointWSFolder;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Iván Zaera
 */
public class SharepointQueryBuilder {

	public SharepointQueryBuilder(
			SharepointWSRepository sharepointWSRepository,
			ExtRepositoryQueryMapper extRepositoryQueryMapper,
			SearchContext searchContext, Query query)
		throws RepositoryException, SearchException {

		_sharepointWSRepository = sharepointWSRepository;
		_extRepositoryQueryMapper = extRepositoryQueryMapper;

		_query = new com.liferay.sharepoint.connector.schema.query.Query(
			traverseQuery(query));

		QueryConfig queryConfig = searchContext.getQueryConfig();

		if (queryConfig.isSearchSubfolders()) {
			_queryOptionsList = new QueryOptionsList(
				new FolderQueryOption(StringPool.BLANK));
		}
		else {
			_queryOptionsList = new QueryOptionsList();
		}

		log(_query, _queryOptionsList);
	}

	public com.liferay.sharepoint.connector.schema.query.Query getQuery() {
		return _query;
	}

	public QueryOptionsList getQueryOptionsList() {
		return _queryOptionsList;
	}

	protected QueryClause buildFieldExpression(
			String field, String value,
			SharepointQueryOperator sharepointQueryOperator)
		throws SearchException {

		QueryField queryField = new QueryField(getSharepointField(field));

		QueryValue queryValue = new QueryValue(
			formatParameterValue(field, value));

		switch (sharepointQueryOperator) {
			case EQ:
				return new EqOperator(queryField, queryValue);

			case NEQ:
				return new NeqOperator(queryField, queryValue);

			case GEQ:
				return new GeqOperator(queryField, queryValue);

			case GT:
				return new GtOperator(queryField, queryValue);

			case LT:
				return new LtOperator(queryField, queryValue);

			case LEQ:
				return new LeqOperator(queryField, queryValue);

			case LIKE:
				return buildLikeExpression(queryField, value);

			default:
				throw new SearchException(
					"Unsupported Sharepoint query operator " +
						sharepointQueryOperator);
		}
	}

	protected QueryClause buildLikeExpression(
			QueryField queryField, String value)
		throws SearchException {

		QueryValue queryValue = new QueryValue(
			StringUtil.replace(value, StringPool.STAR, StringPool.BLANK));

		if (value.startsWith(StringPool.STAR) &&
			value.endsWith(StringPool.STAR)) {

			return new ContainsOperator(queryField, queryValue);
		}
		else if (value.endsWith(StringPool.STAR)) {
			return new BeginsWithOperator(queryField, queryValue);
		}
		else if (value.startsWith(StringPool.STAR)) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Converting and ENDS-WITH query to a CONTAINS query due " +
						"to repository limitations");
			}

			return new ContainsOperator(queryField, queryValue);
		}
		else if (value.contains(StringPool.STAR)) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Converting an INTERMEDIATE WILDCARD query to MULTIPLE " +
						"CONTAINS queries due to repository limitations");
			}

			String[] parts = StringUtil.split(value, _STAR_PATTERN);

			List<QueryClause> queryClauses = new ArrayList<QueryClause>();

			for (String part : parts) {
				queryClauses.add(
					new ContainsOperator(queryField, new QueryValue(part)));
			}

			return joinWithAnd(queryClauses);
		}

		throw new SearchException("Unsupported LIKE value " + value);
	}

	protected String formatParameterValue(String field, String value)
		throws SearchException {

		if (field.equals(Field.FOLDER_ID)) {
			String folderId = _extRepositoryQueryMapper.formatParameterValue(
				field, value);

			try {
				SharepointWSFolder sharepointWSFolder =
					(SharepointWSFolder)
						_sharepointWSRepository.getExtRepositoryObject(
							ExtRepositoryObjectType.FOLDER, folderId);

				SharepointConnection sharepointConnection =
					_sharepointWSRepository.getSharepointConnection();

				SharepointConnectionInfo sharepointConnectionInfo =
					sharepointConnection.getSharepointConnectionInfo();

				String libraryName = sharepointConnectionInfo.getLibraryName();

				SharepointObject folderSharepointObject =
					sharepointWSFolder.getSharepointObject();

				String folderPath = folderSharepointObject.getPath();

				if (folderPath.equals(StringPool.SLASH)) {
					return libraryName;
				}
				else {
					return libraryName+folderPath;
				}
			}
			catch (PortalException pe) {
				throw new SearchException(
					"Cannot get folder {folderId = " + folderId + "}", pe);
			}
			catch (SystemException se) {
				throw new SearchException(
					"Cannot get folder {folderId = " + folderId + "}", se);
			}

		} else if (field.equals(Field.CREATE_DATE) ||
			field.equals(Field.MODIFIED_DATE)) {

			Date date = _extRepositoryQueryMapper.formatDateParameterValue(
				field, value);

			DateFormat dateFormat =
				DateFormatFactoryUtil.getSimpleDateFormat(
					_SHAREPOINT_DATE_FORMAT_PATTERN);

			return dateFormat.format(date);
		}
		else {
			return _extRepositoryQueryMapper.formatParameterValue(field, value);
		}
	}

	protected String getSharepointField(String field) {
		return _sharepointFields.get(field);
	}

	protected boolean isSupportedField(String field) {
		return _supportedFields.contains(field);
	}

	protected QueryClause joinWithAnd(List<QueryClause> queryClauses) {
		if (queryClauses.isEmpty()) {
			return null;
		}
		else if (queryClauses.size() == 1) {
			return queryClauses.get(0);
		}
		else {
			QueryClause firstQueryClause = queryClauses.get(0);

			List<QueryClause> restOfQueryClauses = queryClauses.subList(
				1, queryClauses.size());

			return new AndJoin(
				firstQueryClause, joinWithAnd(restOfQueryClauses));
		}
	}

	protected void log(
		com.liferay.sharepoint.connector.schema.query.Query query,
		QueryOptionsList queryOptionsList) {
	}

	protected QueryClause traverseBooleanQuery(BooleanQuery booleanQuery) {
		return null;
	}

	protected QueryClause traverseQuery(Query query) throws SearchException {
		if (query instanceof BooleanQuery) {
			return traverseBooleanQuery((BooleanQuery)query);
		}
		else if (query instanceof TermQuery) {
			return traverseTermQuery((TermQuery)query);
		}
		else if (query instanceof TermRangeQuery) {
			return traverseTermRangeQuery((TermRangeQuery)query);
		}
		else if (query instanceof WildcardQuery) {
			return traverseWildcardQuery((WildcardQuery)query);
		}

		throw new SearchException(
			"Unsupported query type " + query.getClass().getName());
	}

	protected QueryClause traverseTermQuery(TermQuery termQuery)
		throws SearchException {

		QueryTerm queryTerm = termQuery.getQueryTerm();

		if (!isSupportedField(queryTerm.getField())) {
			return null;
		}

		return buildFieldExpression(
			queryTerm.getField(), queryTerm.getValue(),
			SharepointQueryOperator.EQ);
	}

	protected QueryClause traverseTermRangeQuery(TermRangeQuery termRangeQuery)
		throws SearchException {

		return null;
	}

	protected QueryClause traverseWildcardQuery(WildcardQuery wildcardQuery) {
		return null;
	}

	private static final String _SHAREPOINT_DATE_FORMAT_PATTERN =
		"yyyy-MM-dd' 'HH:mm:ss";

	private static Log _log = LogFactoryUtil.getLog(
		SharepointQueryBuilder.class);

	private static String _STAR_PATTERN = Pattern.quote(StringPool.STAR);

	private static Map<String, String> _sharepointFields;
	private static Set<String> _supportedFields;

	static {
		_sharepointFields = new HashMap<String, String>();
		_sharepointFields.put(Field.CREATE_DATE, SharepointField.CREATE_DATE);
		_sharepointFields.put(Field.FOLDER_ID, SharepointField.FOLDER_PATH);
		_sharepointFields.put(
			Field.MODIFIED_DATE, SharepointField.MODIFIED_DATE);
		_sharepointFields.put(Field.NAME, SharepointField.NAME);
		_sharepointFields.put(Field.TITLE, SharepointField.NAME);
		_sharepointFields.put(Field.USER_ID, SharepointField.MODIFIED_BY);
		_sharepointFields.put(Field.USER_NAME, SharepointField.MODIFIED_BY);

		_supportedFields = new HashSet<String>();
		_supportedFields.add(Field.CREATE_DATE);
		_supportedFields.add(Field.FOLDER_ID);
		_supportedFields.add(Field.MODIFIED_DATE);
		_supportedFields.add(Field.NAME);
		_supportedFields.add(Field.TITLE);
		_supportedFields.add(Field.USER_ID);
		_supportedFields.add(Field.USER_NAME);
	}

	private ExtRepositoryQueryMapper _extRepositoryQueryMapper;
	private com.liferay.sharepoint.connector.schema.query.Query _query;
	private QueryOptionsList _queryOptionsList;
	private SharepointWSRepository _sharepointWSRepository;

}