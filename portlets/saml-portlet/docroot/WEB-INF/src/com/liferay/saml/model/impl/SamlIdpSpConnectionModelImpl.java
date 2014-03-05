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

package com.liferay.saml.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.saml.model.SamlIdpSpConnection;
import com.liferay.saml.model.SamlIdpSpConnectionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SamlIdpSpConnection service. Represents a row in the &quot;SamlIdpSpConnection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.saml.model.SamlIdpSpConnectionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SamlIdpSpConnectionImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlIdpSpConnectionImpl
 * @see com.liferay.saml.model.SamlIdpSpConnection
 * @see com.liferay.saml.model.SamlIdpSpConnectionModel
 * @generated
 */
public class SamlIdpSpConnectionModelImpl extends BaseModelImpl<SamlIdpSpConnection>
	implements SamlIdpSpConnectionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a saml idp sp connection model instance should use the {@link com.liferay.saml.model.SamlIdpSpConnection} interface instead.
	 */
	public static final String TABLE_NAME = "SamlIdpSpConnection";
	public static final Object[][] TABLE_COLUMNS = {
			{ "samlIdpSpConnectionId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "samlSpEntityId", Types.VARCHAR },
			{ "assertionLifetime", Types.INTEGER },
			{ "attributeNames", Types.VARCHAR },
			{ "attributesEnabled", Types.BOOLEAN },
			{ "attributesNamespaceEnabled", Types.BOOLEAN },
			{ "enabled", Types.BOOLEAN },
			{ "metadataUrl", Types.VARCHAR },
			{ "metadataXml", Types.CLOB },
			{ "metadataUpdatedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "nameIdAttribute", Types.VARCHAR },
			{ "nameIdFormat", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SamlIdpSpConnection (samlIdpSpConnectionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,samlSpEntityId VARCHAR(1024) null,assertionLifetime INTEGER,attributeNames STRING null,attributesEnabled BOOLEAN,attributesNamespaceEnabled BOOLEAN,enabled BOOLEAN,metadataUrl VARCHAR(1024) null,metadataXml TEXT null,metadataUpdatedDate DATE null,name VARCHAR(75) null,nameIdAttribute VARCHAR(1024) null,nameIdFormat VARCHAR(1024) null)";
	public static final String TABLE_SQL_DROP = "drop table SamlIdpSpConnection";
	public static final String ORDER_BY_JPQL = " ORDER BY samlIdpSpConnection.samlIdpSpConnectionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SamlIdpSpConnection.samlIdpSpConnectionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.saml.model.SamlIdpSpConnection"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.saml.model.SamlIdpSpConnection"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.saml.model.SamlIdpSpConnection"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long SAMLSPENTITYID_COLUMN_BITMASK = 2L;
	public static long SAMLIDPSPCONNECTIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.saml.model.SamlIdpSpConnection"));

	public SamlIdpSpConnectionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _samlIdpSpConnectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSamlIdpSpConnectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _samlIdpSpConnectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SamlIdpSpConnection.class;
	}

	@Override
	public String getModelClassName() {
		return SamlIdpSpConnection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("samlIdpSpConnectionId", getSamlIdpSpConnectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("samlSpEntityId", getSamlSpEntityId());
		attributes.put("assertionLifetime", getAssertionLifetime());
		attributes.put("attributeNames", getAttributeNames());
		attributes.put("attributesEnabled", getAttributesEnabled());
		attributes.put("attributesNamespaceEnabled",
			getAttributesNamespaceEnabled());
		attributes.put("enabled", getEnabled());
		attributes.put("metadataUrl", getMetadataUrl());
		attributes.put("metadataXml", getMetadataXml());
		attributes.put("metadataUpdatedDate", getMetadataUpdatedDate());
		attributes.put("name", getName());
		attributes.put("nameIdAttribute", getNameIdAttribute());
		attributes.put("nameIdFormat", getNameIdFormat());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long samlIdpSpConnectionId = (Long)attributes.get(
				"samlIdpSpConnectionId");

		if (samlIdpSpConnectionId != null) {
			setSamlIdpSpConnectionId(samlIdpSpConnectionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String samlSpEntityId = (String)attributes.get("samlSpEntityId");

		if (samlSpEntityId != null) {
			setSamlSpEntityId(samlSpEntityId);
		}

		Integer assertionLifetime = (Integer)attributes.get("assertionLifetime");

		if (assertionLifetime != null) {
			setAssertionLifetime(assertionLifetime);
		}

		String attributeNames = (String)attributes.get("attributeNames");

		if (attributeNames != null) {
			setAttributeNames(attributeNames);
		}

		Boolean attributesEnabled = (Boolean)attributes.get("attributesEnabled");

		if (attributesEnabled != null) {
			setAttributesEnabled(attributesEnabled);
		}

		Boolean attributesNamespaceEnabled = (Boolean)attributes.get(
				"attributesNamespaceEnabled");

		if (attributesNamespaceEnabled != null) {
			setAttributesNamespaceEnabled(attributesNamespaceEnabled);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}

		String metadataUrl = (String)attributes.get("metadataUrl");

		if (metadataUrl != null) {
			setMetadataUrl(metadataUrl);
		}

		String metadataXml = (String)attributes.get("metadataXml");

		if (metadataXml != null) {
			setMetadataXml(metadataXml);
		}

		Date metadataUpdatedDate = (Date)attributes.get("metadataUpdatedDate");

		if (metadataUpdatedDate != null) {
			setMetadataUpdatedDate(metadataUpdatedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String nameIdAttribute = (String)attributes.get("nameIdAttribute");

		if (nameIdAttribute != null) {
			setNameIdAttribute(nameIdAttribute);
		}

		String nameIdFormat = (String)attributes.get("nameIdFormat");

		if (nameIdFormat != null) {
			setNameIdFormat(nameIdFormat);
		}
	}

	@Override
	public long getSamlIdpSpConnectionId() {
		return _samlIdpSpConnectionId;
	}

	@Override
	public void setSamlIdpSpConnectionId(long samlIdpSpConnectionId) {
		_samlIdpSpConnectionId = samlIdpSpConnectionId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getSamlSpEntityId() {
		if (_samlSpEntityId == null) {
			return StringPool.BLANK;
		}
		else {
			return _samlSpEntityId;
		}
	}

	@Override
	public void setSamlSpEntityId(String samlSpEntityId) {
		_columnBitmask |= SAMLSPENTITYID_COLUMN_BITMASK;

		if (_originalSamlSpEntityId == null) {
			_originalSamlSpEntityId = _samlSpEntityId;
		}

		_samlSpEntityId = samlSpEntityId;
	}

	public String getOriginalSamlSpEntityId() {
		return GetterUtil.getString(_originalSamlSpEntityId);
	}

	@Override
	public int getAssertionLifetime() {
		return _assertionLifetime;
	}

	@Override
	public void setAssertionLifetime(int assertionLifetime) {
		_assertionLifetime = assertionLifetime;
	}

	@Override
	public String getAttributeNames() {
		if (_attributeNames == null) {
			return StringPool.BLANK;
		}
		else {
			return _attributeNames;
		}
	}

	@Override
	public void setAttributeNames(String attributeNames) {
		_attributeNames = attributeNames;
	}

	@Override
	public boolean getAttributesEnabled() {
		return _attributesEnabled;
	}

	@Override
	public boolean isAttributesEnabled() {
		return _attributesEnabled;
	}

	@Override
	public void setAttributesEnabled(boolean attributesEnabled) {
		_attributesEnabled = attributesEnabled;
	}

	@Override
	public boolean getAttributesNamespaceEnabled() {
		return _attributesNamespaceEnabled;
	}

	@Override
	public boolean isAttributesNamespaceEnabled() {
		return _attributesNamespaceEnabled;
	}

	@Override
	public void setAttributesNamespaceEnabled(
		boolean attributesNamespaceEnabled) {
		_attributesNamespaceEnabled = attributesNamespaceEnabled;
	}

	@Override
	public boolean getEnabled() {
		return _enabled;
	}

	@Override
	public boolean isEnabled() {
		return _enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		_enabled = enabled;
	}

	@Override
	public String getMetadataUrl() {
		if (_metadataUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _metadataUrl;
		}
	}

	@Override
	public void setMetadataUrl(String metadataUrl) {
		_metadataUrl = metadataUrl;
	}

	@Override
	public String getMetadataXml() {
		if (_metadataXml == null) {
			return StringPool.BLANK;
		}
		else {
			return _metadataXml;
		}
	}

	@Override
	public void setMetadataXml(String metadataXml) {
		_metadataXml = metadataXml;
	}

	@Override
	public Date getMetadataUpdatedDate() {
		return _metadataUpdatedDate;
	}

	@Override
	public void setMetadataUpdatedDate(Date metadataUpdatedDate) {
		_metadataUpdatedDate = metadataUpdatedDate;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getNameIdAttribute() {
		if (_nameIdAttribute == null) {
			return StringPool.BLANK;
		}
		else {
			return _nameIdAttribute;
		}
	}

	@Override
	public void setNameIdAttribute(String nameIdAttribute) {
		_nameIdAttribute = nameIdAttribute;
	}

	@Override
	public String getNameIdFormat() {
		if (_nameIdFormat == null) {
			return StringPool.BLANK;
		}
		else {
			return _nameIdFormat;
		}
	}

	@Override
	public void setNameIdFormat(String nameIdFormat) {
		_nameIdFormat = nameIdFormat;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SamlIdpSpConnection.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SamlIdpSpConnection toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SamlIdpSpConnection)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SamlIdpSpConnectionImpl samlIdpSpConnectionImpl = new SamlIdpSpConnectionImpl();

		samlIdpSpConnectionImpl.setSamlIdpSpConnectionId(getSamlIdpSpConnectionId());
		samlIdpSpConnectionImpl.setCompanyId(getCompanyId());
		samlIdpSpConnectionImpl.setUserId(getUserId());
		samlIdpSpConnectionImpl.setUserName(getUserName());
		samlIdpSpConnectionImpl.setCreateDate(getCreateDate());
		samlIdpSpConnectionImpl.setModifiedDate(getModifiedDate());
		samlIdpSpConnectionImpl.setSamlSpEntityId(getSamlSpEntityId());
		samlIdpSpConnectionImpl.setAssertionLifetime(getAssertionLifetime());
		samlIdpSpConnectionImpl.setAttributeNames(getAttributeNames());
		samlIdpSpConnectionImpl.setAttributesEnabled(getAttributesEnabled());
		samlIdpSpConnectionImpl.setAttributesNamespaceEnabled(getAttributesNamespaceEnabled());
		samlIdpSpConnectionImpl.setEnabled(getEnabled());
		samlIdpSpConnectionImpl.setMetadataUrl(getMetadataUrl());
		samlIdpSpConnectionImpl.setMetadataXml(getMetadataXml());
		samlIdpSpConnectionImpl.setMetadataUpdatedDate(getMetadataUpdatedDate());
		samlIdpSpConnectionImpl.setName(getName());
		samlIdpSpConnectionImpl.setNameIdAttribute(getNameIdAttribute());
		samlIdpSpConnectionImpl.setNameIdFormat(getNameIdFormat());

		samlIdpSpConnectionImpl.resetOriginalValues();

		return samlIdpSpConnectionImpl;
	}

	@Override
	public int compareTo(SamlIdpSpConnection samlIdpSpConnection) {
		long primaryKey = samlIdpSpConnection.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SamlIdpSpConnection)) {
			return false;
		}

		SamlIdpSpConnection samlIdpSpConnection = (SamlIdpSpConnection)obj;

		long primaryKey = samlIdpSpConnection.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SamlIdpSpConnectionModelImpl samlIdpSpConnectionModelImpl = this;

		samlIdpSpConnectionModelImpl._originalCompanyId = samlIdpSpConnectionModelImpl._companyId;

		samlIdpSpConnectionModelImpl._setOriginalCompanyId = false;

		samlIdpSpConnectionModelImpl._originalSamlSpEntityId = samlIdpSpConnectionModelImpl._samlSpEntityId;

		samlIdpSpConnectionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SamlIdpSpConnection> toCacheModel() {
		SamlIdpSpConnectionCacheModel samlIdpSpConnectionCacheModel = new SamlIdpSpConnectionCacheModel();

		samlIdpSpConnectionCacheModel.samlIdpSpConnectionId = getSamlIdpSpConnectionId();

		samlIdpSpConnectionCacheModel.companyId = getCompanyId();

		samlIdpSpConnectionCacheModel.userId = getUserId();

		samlIdpSpConnectionCacheModel.userName = getUserName();

		String userName = samlIdpSpConnectionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			samlIdpSpConnectionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			samlIdpSpConnectionCacheModel.createDate = createDate.getTime();
		}
		else {
			samlIdpSpConnectionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			samlIdpSpConnectionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			samlIdpSpConnectionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		samlIdpSpConnectionCacheModel.samlSpEntityId = getSamlSpEntityId();

		String samlSpEntityId = samlIdpSpConnectionCacheModel.samlSpEntityId;

		if ((samlSpEntityId != null) && (samlSpEntityId.length() == 0)) {
			samlIdpSpConnectionCacheModel.samlSpEntityId = null;
		}

		samlIdpSpConnectionCacheModel.assertionLifetime = getAssertionLifetime();

		samlIdpSpConnectionCacheModel.attributeNames = getAttributeNames();

		String attributeNames = samlIdpSpConnectionCacheModel.attributeNames;

		if ((attributeNames != null) && (attributeNames.length() == 0)) {
			samlIdpSpConnectionCacheModel.attributeNames = null;
		}

		samlIdpSpConnectionCacheModel.attributesEnabled = getAttributesEnabled();

		samlIdpSpConnectionCacheModel.attributesNamespaceEnabled = getAttributesNamespaceEnabled();

		samlIdpSpConnectionCacheModel.enabled = getEnabled();

		samlIdpSpConnectionCacheModel.metadataUrl = getMetadataUrl();

		String metadataUrl = samlIdpSpConnectionCacheModel.metadataUrl;

		if ((metadataUrl != null) && (metadataUrl.length() == 0)) {
			samlIdpSpConnectionCacheModel.metadataUrl = null;
		}

		samlIdpSpConnectionCacheModel.metadataXml = getMetadataXml();

		String metadataXml = samlIdpSpConnectionCacheModel.metadataXml;

		if ((metadataXml != null) && (metadataXml.length() == 0)) {
			samlIdpSpConnectionCacheModel.metadataXml = null;
		}

		Date metadataUpdatedDate = getMetadataUpdatedDate();

		if (metadataUpdatedDate != null) {
			samlIdpSpConnectionCacheModel.metadataUpdatedDate = metadataUpdatedDate.getTime();
		}
		else {
			samlIdpSpConnectionCacheModel.metadataUpdatedDate = Long.MIN_VALUE;
		}

		samlIdpSpConnectionCacheModel.name = getName();

		String name = samlIdpSpConnectionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			samlIdpSpConnectionCacheModel.name = null;
		}

		samlIdpSpConnectionCacheModel.nameIdAttribute = getNameIdAttribute();

		String nameIdAttribute = samlIdpSpConnectionCacheModel.nameIdAttribute;

		if ((nameIdAttribute != null) && (nameIdAttribute.length() == 0)) {
			samlIdpSpConnectionCacheModel.nameIdAttribute = null;
		}

		samlIdpSpConnectionCacheModel.nameIdFormat = getNameIdFormat();

		String nameIdFormat = samlIdpSpConnectionCacheModel.nameIdFormat;

		if ((nameIdFormat != null) && (nameIdFormat.length() == 0)) {
			samlIdpSpConnectionCacheModel.nameIdFormat = null;
		}

		return samlIdpSpConnectionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{samlIdpSpConnectionId=");
		sb.append(getSamlIdpSpConnectionId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", samlSpEntityId=");
		sb.append(getSamlSpEntityId());
		sb.append(", assertionLifetime=");
		sb.append(getAssertionLifetime());
		sb.append(", attributeNames=");
		sb.append(getAttributeNames());
		sb.append(", attributesEnabled=");
		sb.append(getAttributesEnabled());
		sb.append(", attributesNamespaceEnabled=");
		sb.append(getAttributesNamespaceEnabled());
		sb.append(", enabled=");
		sb.append(getEnabled());
		sb.append(", metadataUrl=");
		sb.append(getMetadataUrl());
		sb.append(", metadataXml=");
		sb.append(getMetadataXml());
		sb.append(", metadataUpdatedDate=");
		sb.append(getMetadataUpdatedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", nameIdAttribute=");
		sb.append(getNameIdAttribute());
		sb.append(", nameIdFormat=");
		sb.append(getNameIdFormat());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.liferay.saml.model.SamlIdpSpConnection");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>samlIdpSpConnectionId</column-name><column-value><![CDATA[");
		sb.append(getSamlIdpSpConnectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>samlSpEntityId</column-name><column-value><![CDATA[");
		sb.append(getSamlSpEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assertionLifetime</column-name><column-value><![CDATA[");
		sb.append(getAssertionLifetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributeNames</column-name><column-value><![CDATA[");
		sb.append(getAttributeNames());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributesEnabled</column-name><column-value><![CDATA[");
		sb.append(getAttributesEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attributesNamespaceEnabled</column-name><column-value><![CDATA[");
		sb.append(getAttributesNamespaceEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enabled</column-name><column-value><![CDATA[");
		sb.append(getEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataUrl</column-name><column-value><![CDATA[");
		sb.append(getMetadataUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataXml</column-name><column-value><![CDATA[");
		sb.append(getMetadataXml());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadataUpdatedDate</column-name><column-value><![CDATA[");
		sb.append(getMetadataUpdatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameIdAttribute</column-name><column-value><![CDATA[");
		sb.append(getNameIdAttribute());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameIdFormat</column-name><column-value><![CDATA[");
		sb.append(getNameIdFormat());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SamlIdpSpConnection.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SamlIdpSpConnection.class
		};
	private long _samlIdpSpConnectionId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _samlSpEntityId;
	private String _originalSamlSpEntityId;
	private int _assertionLifetime;
	private String _attributeNames;
	private boolean _attributesEnabled;
	private boolean _attributesNamespaceEnabled;
	private boolean _enabled;
	private String _metadataUrl;
	private String _metadataXml;
	private Date _metadataUpdatedDate;
	private String _name;
	private String _nameIdAttribute;
	private String _nameIdFormat;
	private long _columnBitmask;
	private SamlIdpSpConnection _escapedModel;
}