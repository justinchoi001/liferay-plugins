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

package com.liferay.portal.audit.service.impl;

import com.liferay.portal.audit.model.AuditEvent;
import com.liferay.portal.audit.service.base.AuditEventLocalServiceBaseImpl;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AuditEventLocalServiceImpl extends AuditEventLocalServiceBaseImpl {

	@Override
	public AuditEvent addAuditEvent(AuditMessage auditMessage)
		throws SystemException {

		long auditEventId = counterLocalService.increment();

		AuditEvent auditEvent = auditEventPersistence.create(auditEventId);

		auditEvent.setCompanyId(auditMessage.getCompanyId());
		auditEvent.setUserId(auditMessage.getUserId());
		auditEvent.setUserName(auditMessage.getUserName());
		auditEvent.setCreateDate(auditMessage.getTimestamp());
		auditEvent.setEventType(auditMessage.getEventType());
		auditEvent.setClassName(auditMessage.getClassName());
		auditEvent.setClassPK(auditMessage.getClassPK());
		auditEvent.setMessage(auditMessage.getMessage());
		auditEvent.setClientHost(auditMessage.getClientHost());
		auditEvent.setClientIP(auditMessage.getClientIP());
		auditEvent.setServerName(auditMessage.getServerName());
		auditEvent.setServerPort(auditMessage.getServerPort());
		auditEvent.setSessionID(auditMessage.getSessionID());
		auditEvent.setServerPort(auditMessage.getServerPort());
		auditEvent.setAdditionalInfo(
			String.valueOf(auditMessage.getAdditionalInfo()));

		auditEventPersistence.update(auditEvent);

		return auditEvent;
	}

	@Override
	public AuditEvent fetchAuditEvent(long auditEventId)
		throws SystemException {

		return auditEventPersistence.fetchByPrimaryKey(auditEventId);
	}

	@Override
	public List<AuditEvent> getAuditEvents(
			long companyId, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		return auditEventPersistence.findByCompanyId(
			companyId, start, end, orderByComparator);
	}

	@Override
	public List<AuditEvent> getAuditEvents(
			long companyId, long userId, String userName, Date createDateGT,
			Date createDateLT, String eventType, String className,
			String classPK, String clientHost, String clientIP,
			String serverName, int serverPort, String sessionID,
			boolean andSearch, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		DynamicQuery dynamicQuery = buildDynamicQuery(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch);

		return dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	@Override
	public int getAuditEventsCount(long companyId) throws SystemException {
		return auditEventPersistence.countByCompanyId(companyId);
	}

	@Override
	public int getAuditEventsCount(
			long companyId, long userId, String userName, Date createDateGT,
			Date createDateLT, String eventType, String className,
			String classPK, String clientHost, String clientIP,
			String serverName, int serverPort, String sessionID,
			boolean andSearch)
		throws SystemException {

		DynamicQuery dynamicQuery = buildDynamicQuery(
			companyId, userId, userName, createDateGT, createDateLT, eventType,
			className, classPK, clientHost, clientIP, serverName, serverPort,
			sessionID, andSearch);

		return (int)dynamicQueryCount(dynamicQuery);
	}

	protected DynamicQuery buildDynamicQuery(
		long companyId, long userId, String userName, Date createDateGT,
		Date createDateLT, String eventType, String className, String classPK,
		String clientHost, String clientIP, String serverName, int serverPort,
		String sessionID, boolean andSearch) {

		Junction junction = null;

		if (andSearch) {
			junction = RestrictionsFactoryUtil.conjunction();
		}
		else {
			junction = RestrictionsFactoryUtil.disjunction();
		}

		if (userId > 0) {
			Property property = PropertyFactoryUtil.forName("userId");

			junction.add(property.eq(userId));
		}

		if (Validator.isNotNull(userName)) {
			Property property = PropertyFactoryUtil.forName("userName");

			String value = StringPool.PERCENT + userName + StringPool.PERCENT;

			junction.add(property.like(value));
		}

		if (Validator.isNotNull(eventType)) {
			Property property = PropertyFactoryUtil.forName("eventType");

			String value =
				StringPool.PERCENT + StringUtil.toUpperCase(eventType) +
					StringPool.PERCENT;

			junction.add(property.like(value));
		}

		if (Validator.isNotNull(className)) {
			Property property = PropertyFactoryUtil.forName("className");

			String value = StringPool.PERCENT + className + StringPool.PERCENT;

			junction.add(property.like(value));
		}

		if (Validator.isNotNull(classPK)) {
			Property property = PropertyFactoryUtil.forName("classPK");

			junction.add(property.eq(classPK));
		}

		if (Validator.isNotNull(clientHost)) {
			Property property = PropertyFactoryUtil.forName("clientHost");

			String value = StringPool.PERCENT + clientHost + StringPool.PERCENT;

			junction.add(property.like(value));
		}

		if (Validator.isNotNull(clientIP)) {
			Property property = PropertyFactoryUtil.forName("clientIP");

			String value = StringPool.PERCENT + clientIP + StringPool.PERCENT;

			junction.add(property.like(value));
		}

		if (Validator.isNotNull(serverName)) {
			Property property = PropertyFactoryUtil.forName("serverName");

			String value = StringPool.PERCENT + serverName + StringPool.PERCENT;

			junction.add(property.like(value));
		}

		if (serverPort > 0) {
			Property property = PropertyFactoryUtil.forName("serverPort");

			junction.add(property.eq(serverPort));
		}

		if (Validator.isNotNull(sessionID)) {
			Property property = PropertyFactoryUtil.forName("sessionID");

			String value = StringPool.PERCENT + sessionID + StringPool.PERCENT;

			junction.add(property.like(value));
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AuditEvent.class, getClassLoader());

		if (companyId > 0) {
			Property property = PropertyFactoryUtil.forName("companyId");

			dynamicQuery.add(property.eq(companyId));
		}

		if (createDateGT != null) {
			Property property = PropertyFactoryUtil.forName("createDate");

			dynamicQuery.add(property.gt(createDateGT));
		}

		if (createDateLT != null) {
			Property property = PropertyFactoryUtil.forName("createDate");

			dynamicQuery.add(property.lt(createDateLT));
		}

		return dynamicQuery.add(junction);
	}

}