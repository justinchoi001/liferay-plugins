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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.saml.model.SamlSpIdpConnection;
import com.liferay.saml.model.SamlSpIdpConnectionModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SamlSpIdpConnection service. Represents a row in the &quot;SamlSpIdpConnection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.saml.model.SamlSpIdpConnectionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SamlSpIdpConnectionImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlSpIdpConnectionImpl
 * @see com.liferay.saml.model.SamlSpIdpConnection
 * @see com.liferay.saml.model.SamlSpIdpConnectionModel
 * @generated
 */
public class SamlSpIdpConnectionModelImpl extends BaseModelImpl<SamlSpIdpConnection>
	implements SamlSpIdpConnectionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a saml sp idp connection model instance should use the {@link com.liferay.saml.model.SamlSpIdpConnection} interface instead.
	 */
	public static final String TABLE_NAME = "SamlSpIdpConnection";
	public static final Object[][] TABLE_COLUMNS = {
			{ "samlSpIdpConnectionId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "samlIdpEntityId", Types.VARCHAR },
			{ "assertionSignatureRequired", Types.BOOLEAN },
			{ "clockSkew", Types.BIGINT },
			{ "enabled", Types.BOOLEAN },
			{ "ldapImportEnabled", Types.BOOLEAN },
			{ "metadataUrl", Types.VARCHAR },
			{ "metadataXml", Types.CLOB },
			{ "metadataUpdatedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "nameIdFormat", Types.VARCHAR },
			{ "signAuthnRequest", Types.BOOLEAN },
			{ "userAttributeMappings", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SamlSpIdpConnection (samlSpIdpConnectionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,samlIdpEntityId VARCHAR(1024) null,assertionSignatureRequired BOOLEAN,clockSkew LONG,enabled BOOLEAN,ldapImportEnabled BOOLEAN,metadataUrl VARCHAR(1024) null,metadataXml TEXT null,metadataUpdatedDate DATE null,name VARCHAR(75) null,nameIdFormat VARCHAR(1024) null,signAuthnRequest BOOLEAN,userAttributeMappings STRING null)";
	public static final String TABLE_SQL_DROP = "drop table SamlSpIdpConnection";
	public static final String ORDER_BY_JPQL = " ORDER BY samlSpIdpConnection.samlSpIdpConnectionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SamlSpIdpConnection.samlSpIdpConnectionId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.saml.model.SamlSpIdpConnection"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.saml.model.SamlSpIdpConnection"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.saml.model.SamlSpIdpConnection"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long SAMLIDPENTITYID_COLUMN_BITMASK = 2L;
	public static long SAMLSPIDPCONNECTIONID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.saml.model.SamlSpIdpConnection"));

	public SamlSpIdpConnectionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _samlSpIdpConnectionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSamlSpIdpConnectionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _samlSpIdpConnectionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SamlSpIdpConnection.class;
	}

	@Override
	public String getModelClassName() {
		return SamlSpIdpConnection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("samlSpIdpConnectionId", getSamlSpIdpConnectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("samlIdpEntityId", getSamlIdpEntityId());
		attributes.put("assertionSignatureRequired",
			getAssertionSignatureRequired());
		attributes.put("clockSkew", getClockSkew());
		attributes.put("enabled", getEnabled());
		attributes.put("ldapImportEnabled", getLdapImportEnabled());
		attributes.put("metadataUrl", getMetadataUrl());
		attributes.put("metadataXml", getMetadataXml());
		attributes.put("metadataUpdatedDate", getMetadataUpdatedDate());
		attributes.put("name", getName());
		attributes.put("nameIdFormat", getNameIdFormat());
		attributes.put("signAuthnRequest", getSignAuthnRequest());
		attributes.put("userAttributeMappings", getUserAttributeMappings());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long samlSpIdpConnectionId = (Long)attributes.get(
				"samlSpIdpConnectionId");

		if (samlSpIdpConnectionId != null) {
			setSamlSpIdpConnectionId(samlSpIdpConnectionId);
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

		String samlIdpEntityId = (String)attributes.get("samlIdpEntityId");

		if (samlIdpEntityId != null) {
			setSamlIdpEntityId(samlIdpEntityId);
		}

		Boolean assertionSignatureRequired = (Boolean)attributes.get(
				"assertionSignatureRequired");

		if (assertionSignatureRequired != null) {
			setAssertionSignatureRequired(assertionSignatureRequired);
		}

		Long clockSkew = (Long)attributes.get("clockSkew");

		if (clockSkew != null) {
			setClockSkew(clockSkew);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}

		Boolean ldapImportEnabled = (Boolean)attributes.get("ldapImportEnabled");

		if (ldapImportEnabled != null) {
			setLdapImportEnabled(ldapImportEnabled);
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

		String nameIdFormat = (String)attributes.get("nameIdFormat");

		if (nameIdFormat != null) {
			setNameIdFormat(nameIdFormat);
		}

		Boolean signAuthnRequest = (Boolean)attributes.get("signAuthnRequest");

		if (signAuthnRequest != null) {
			setSignAuthnRequest(signAuthnRequest);
		}

		String userAttributeMappings = (String)attributes.get(
				"userAttributeMappings");

		if (userAttributeMappings != null) {
			setUserAttributeMappings(userAttributeMappings);
		}
	}

	@Override
	public long getSamlSpIdpConnectionId() {
		return _samlSpIdpConnectionId;
	}

	@Override
	public void setSamlSpIdpConnectionId(long samlSpIdpConnectionId) {
		_samlSpIdpConnectionId = samlSpIdpConnectionId;
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
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
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
	public String getSamlIdpEntityId() {
		if (_samlIdpEntityId == null) {
			return StringPool.BLANK;
		}
		else {
			return _samlIdpEntityId;
		}
	}

	@Override
	public void setSamlIdpEntityId(String samlIdpEntityId) {
		_columnBitmask |= SAMLIDPENTITYID_COLUMN_BITMASK;

		if (_originalSamlIdpEntityId == null) {
			_originalSamlIdpEntityId = _samlIdpEntityId;
		}

		_samlIdpEntityId = samlIdpEntityId;
	}

	public String getOriginalSamlIdpEntityId() {
		return GetterUtil.getString(_originalSamlIdpEntityId);
	}

	@Override
	public boolean getAssertionSignatureRequired() {
		return _assertionSignatureRequired;
	}

	@Override
	public boolean isAssertionSignatureRequired() {
		return _assertionSignatureRequired;
	}

	@Override
	public void setAssertionSignatureRequired(
		boolean assertionSignatureRequired) {
		_assertionSignatureRequired = assertionSignatureRequired;
	}

	@Override
	public long getClockSkew() {
		return _clockSkew;
	}

	@Override
	public void setClockSkew(long clockSkew) {
		_clockSkew = clockSkew;
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
	public boolean getLdapImportEnabled() {
		return _ldapImportEnabled;
	}

	@Override
	public boolean isLdapImportEnabled() {
		return _ldapImportEnabled;
	}

	@Override
	public void setLdapImportEnabled(boolean ldapImportEnabled) {
		_ldapImportEnabled = ldapImportEnabled;
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

	@Override
	public boolean getSignAuthnRequest() {
		return _signAuthnRequest;
	}

	@Override
	public boolean isSignAuthnRequest() {
		return _signAuthnRequest;
	}

	@Override
	public void setSignAuthnRequest(boolean signAuthnRequest) {
		_signAuthnRequest = signAuthnRequest;
	}

	@Override
	public String getUserAttributeMappings() {
		if (_userAttributeMappings == null) {
			return StringPool.BLANK;
		}
		else {
			return _userAttributeMappings;
		}
	}

	@Override
	public void setUserAttributeMappings(String userAttributeMappings) {
		_userAttributeMappings = userAttributeMappings;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SamlSpIdpConnection.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SamlSpIdpConnection toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SamlSpIdpConnection)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SamlSpIdpConnectionImpl samlSpIdpConnectionImpl = new SamlSpIdpConnectionImpl();

		samlSpIdpConnectionImpl.setSamlSpIdpConnectionId(getSamlSpIdpConnectionId());
		samlSpIdpConnectionImpl.setCompanyId(getCompanyId());
		samlSpIdpConnectionImpl.setUserId(getUserId());
		samlSpIdpConnectionImpl.setUserName(getUserName());
		samlSpIdpConnectionImpl.setCreateDate(getCreateDate());
		samlSpIdpConnectionImpl.setModifiedDate(getModifiedDate());
		samlSpIdpConnectionImpl.setSamlIdpEntityId(getSamlIdpEntityId());
		samlSpIdpConnectionImpl.setAssertionSignatureRequired(getAssertionSignatureRequired());
		samlSpIdpConnectionImpl.setClockSkew(getClockSkew());
		samlSpIdpConnectionImpl.setEnabled(getEnabled());
		samlSpIdpConnectionImpl.setLdapImportEnabled(getLdapImportEnabled());
		samlSpIdpConnectionImpl.setMetadataUrl(getMetadataUrl());
		samlSpIdpConnectionImpl.setMetadataXml(getMetadataXml());
		samlSpIdpConnectionImpl.setMetadataUpdatedDate(getMetadataUpdatedDate());
		samlSpIdpConnectionImpl.setName(getName());
		samlSpIdpConnectionImpl.setNameIdFormat(getNameIdFormat());
		samlSpIdpConnectionImpl.setSignAuthnRequest(getSignAuthnRequest());
		samlSpIdpConnectionImpl.setUserAttributeMappings(getUserAttributeMappings());

		samlSpIdpConnectionImpl.resetOriginalValues();

		return samlSpIdpConnectionImpl;
	}

	@Override
	public int compareTo(SamlSpIdpConnection samlSpIdpConnection) {
		long primaryKey = samlSpIdpConnection.getPrimaryKey();

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

		if (!(obj instanceof SamlSpIdpConnection)) {
			return false;
		}

		SamlSpIdpConnection samlSpIdpConnection = (SamlSpIdpConnection)obj;

		long primaryKey = samlSpIdpConnection.getPrimaryKey();

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
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		SamlSpIdpConnectionModelImpl samlSpIdpConnectionModelImpl = this;

		samlSpIdpConnectionModelImpl._originalCompanyId = samlSpIdpConnectionModelImpl._companyId;

		samlSpIdpConnectionModelImpl._setOriginalCompanyId = false;

		samlSpIdpConnectionModelImpl._originalSamlIdpEntityId = samlSpIdpConnectionModelImpl._samlIdpEntityId;

		samlSpIdpConnectionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SamlSpIdpConnection> toCacheModel() {
		SamlSpIdpConnectionCacheModel samlSpIdpConnectionCacheModel = new SamlSpIdpConnectionCacheModel();

		samlSpIdpConnectionCacheModel.samlSpIdpConnectionId = getSamlSpIdpConnectionId();

		samlSpIdpConnectionCacheModel.companyId = getCompanyId();

		samlSpIdpConnectionCacheModel.userId = getUserId();

		samlSpIdpConnectionCacheModel.userName = getUserName();

		String userName = samlSpIdpConnectionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			samlSpIdpConnectionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			samlSpIdpConnectionCacheModel.createDate = createDate.getTime();
		}
		else {
			samlSpIdpConnectionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			samlSpIdpConnectionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			samlSpIdpConnectionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		samlSpIdpConnectionCacheModel.samlIdpEntityId = getSamlIdpEntityId();

		String samlIdpEntityId = samlSpIdpConnectionCacheModel.samlIdpEntityId;

		if ((samlIdpEntityId != null) && (samlIdpEntityId.length() == 0)) {
			samlSpIdpConnectionCacheModel.samlIdpEntityId = null;
		}

		samlSpIdpConnectionCacheModel.assertionSignatureRequired = getAssertionSignatureRequired();

		samlSpIdpConnectionCacheModel.clockSkew = getClockSkew();

		samlSpIdpConnectionCacheModel.enabled = getEnabled();

		samlSpIdpConnectionCacheModel.ldapImportEnabled = getLdapImportEnabled();

		samlSpIdpConnectionCacheModel.metadataUrl = getMetadataUrl();

		String metadataUrl = samlSpIdpConnectionCacheModel.metadataUrl;

		if ((metadataUrl != null) && (metadataUrl.length() == 0)) {
			samlSpIdpConnectionCacheModel.metadataUrl = null;
		}

		samlSpIdpConnectionCacheModel.metadataXml = getMetadataXml();

		String metadataXml = samlSpIdpConnectionCacheModel.metadataXml;

		if ((metadataXml != null) && (metadataXml.length() == 0)) {
			samlSpIdpConnectionCacheModel.metadataXml = null;
		}

		Date metadataUpdatedDate = getMetadataUpdatedDate();

		if (metadataUpdatedDate != null) {
			samlSpIdpConnectionCacheModel.metadataUpdatedDate = metadataUpdatedDate.getTime();
		}
		else {
			samlSpIdpConnectionCacheModel.metadataUpdatedDate = Long.MIN_VALUE;
		}

		samlSpIdpConnectionCacheModel.name = getName();

		String name = samlSpIdpConnectionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			samlSpIdpConnectionCacheModel.name = null;
		}

		samlSpIdpConnectionCacheModel.nameIdFormat = getNameIdFormat();

		String nameIdFormat = samlSpIdpConnectionCacheModel.nameIdFormat;

		if ((nameIdFormat != null) && (nameIdFormat.length() == 0)) {
			samlSpIdpConnectionCacheModel.nameIdFormat = null;
		}

		samlSpIdpConnectionCacheModel.signAuthnRequest = getSignAuthnRequest();

		samlSpIdpConnectionCacheModel.userAttributeMappings = getUserAttributeMappings();

		String userAttributeMappings = samlSpIdpConnectionCacheModel.userAttributeMappings;

		if ((userAttributeMappings != null) &&
				(userAttributeMappings.length() == 0)) {
			samlSpIdpConnectionCacheModel.userAttributeMappings = null;
		}

		return samlSpIdpConnectionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{samlSpIdpConnectionId=");
		sb.append(getSamlSpIdpConnectionId());
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
		sb.append(", samlIdpEntityId=");
		sb.append(getSamlIdpEntityId());
		sb.append(", assertionSignatureRequired=");
		sb.append(getAssertionSignatureRequired());
		sb.append(", clockSkew=");
		sb.append(getClockSkew());
		sb.append(", enabled=");
		sb.append(getEnabled());
		sb.append(", ldapImportEnabled=");
		sb.append(getLdapImportEnabled());
		sb.append(", metadataUrl=");
		sb.append(getMetadataUrl());
		sb.append(", metadataXml=");
		sb.append(getMetadataXml());
		sb.append(", metadataUpdatedDate=");
		sb.append(getMetadataUpdatedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", nameIdFormat=");
		sb.append(getNameIdFormat());
		sb.append(", signAuthnRequest=");
		sb.append(getSignAuthnRequest());
		sb.append(", userAttributeMappings=");
		sb.append(getUserAttributeMappings());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.liferay.saml.model.SamlSpIdpConnection");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>samlSpIdpConnectionId</column-name><column-value><![CDATA[");
		sb.append(getSamlSpIdpConnectionId());
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
			"<column><column-name>samlIdpEntityId</column-name><column-value><![CDATA[");
		sb.append(getSamlIdpEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assertionSignatureRequired</column-name><column-value><![CDATA[");
		sb.append(getAssertionSignatureRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clockSkew</column-name><column-value><![CDATA[");
		sb.append(getClockSkew());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enabled</column-name><column-value><![CDATA[");
		sb.append(getEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldapImportEnabled</column-name><column-value><![CDATA[");
		sb.append(getLdapImportEnabled());
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
			"<column><column-name>nameIdFormat</column-name><column-value><![CDATA[");
		sb.append(getNameIdFormat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signAuthnRequest</column-name><column-value><![CDATA[");
		sb.append(getSignAuthnRequest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAttributeMappings</column-name><column-value><![CDATA[");
		sb.append(getUserAttributeMappings());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SamlSpIdpConnection.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SamlSpIdpConnection.class
		};
	private long _samlSpIdpConnectionId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _samlIdpEntityId;
	private String _originalSamlIdpEntityId;
	private boolean _assertionSignatureRequired;
	private long _clockSkew;
	private boolean _enabled;
	private boolean _ldapImportEnabled;
	private String _metadataUrl;
	private String _metadataXml;
	private Date _metadataUpdatedDate;
	private String _name;
	private String _nameIdFormat;
	private boolean _signAuthnRequest;
	private String _userAttributeMappings;
	private long _columnBitmask;
	private SamlSpIdpConnection _escapedModel;
}