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

package com.liferay.saml.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SamlIdpSsoSession}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlIdpSsoSession
 * @generated
 */
public class SamlIdpSsoSessionWrapper implements SamlIdpSsoSession,
	ModelWrapper<SamlIdpSsoSession> {
	public SamlIdpSsoSessionWrapper(SamlIdpSsoSession samlIdpSsoSession) {
		_samlIdpSsoSession = samlIdpSsoSession;
	}

	@Override
	public Class<?> getModelClass() {
		return SamlIdpSsoSession.class;
	}

	@Override
	public String getModelClassName() {
		return SamlIdpSsoSession.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("samlIdpSsoSessionId", getSamlIdpSsoSessionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("samlIdpSsoSessionKey", getSamlIdpSsoSessionKey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long samlIdpSsoSessionId = (Long)attributes.get("samlIdpSsoSessionId");

		if (samlIdpSsoSessionId != null) {
			setSamlIdpSsoSessionId(samlIdpSsoSessionId);
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

		String samlIdpSsoSessionKey = (String)attributes.get(
				"samlIdpSsoSessionKey");

		if (samlIdpSsoSessionKey != null) {
			setSamlIdpSsoSessionKey(samlIdpSsoSessionKey);
		}
	}

	/**
	* Returns the primary key of this saml idp sso session.
	*
	* @return the primary key of this saml idp sso session
	*/
	@Override
	public long getPrimaryKey() {
		return _samlIdpSsoSession.getPrimaryKey();
	}

	/**
	* Sets the primary key of this saml idp sso session.
	*
	* @param primaryKey the primary key of this saml idp sso session
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_samlIdpSsoSession.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the saml idp sso session ID of this saml idp sso session.
	*
	* @return the saml idp sso session ID of this saml idp sso session
	*/
	@Override
	public long getSamlIdpSsoSessionId() {
		return _samlIdpSsoSession.getSamlIdpSsoSessionId();
	}

	/**
	* Sets the saml idp sso session ID of this saml idp sso session.
	*
	* @param samlIdpSsoSessionId the saml idp sso session ID of this saml idp sso session
	*/
	@Override
	public void setSamlIdpSsoSessionId(long samlIdpSsoSessionId) {
		_samlIdpSsoSession.setSamlIdpSsoSessionId(samlIdpSsoSessionId);
	}

	/**
	* Returns the company ID of this saml idp sso session.
	*
	* @return the company ID of this saml idp sso session
	*/
	@Override
	public long getCompanyId() {
		return _samlIdpSsoSession.getCompanyId();
	}

	/**
	* Sets the company ID of this saml idp sso session.
	*
	* @param companyId the company ID of this saml idp sso session
	*/
	@Override
	public void setCompanyId(long companyId) {
		_samlIdpSsoSession.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this saml idp sso session.
	*
	* @return the user ID of this saml idp sso session
	*/
	@Override
	public long getUserId() {
		return _samlIdpSsoSession.getUserId();
	}

	/**
	* Sets the user ID of this saml idp sso session.
	*
	* @param userId the user ID of this saml idp sso session
	*/
	@Override
	public void setUserId(long userId) {
		_samlIdpSsoSession.setUserId(userId);
	}

	/**
	* Returns the user uuid of this saml idp sso session.
	*
	* @return the user uuid of this saml idp sso session
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _samlIdpSsoSession.getUserUuid();
	}

	/**
	* Sets the user uuid of this saml idp sso session.
	*
	* @param userUuid the user uuid of this saml idp sso session
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_samlIdpSsoSession.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this saml idp sso session.
	*
	* @return the user name of this saml idp sso session
	*/
	@Override
	public java.lang.String getUserName() {
		return _samlIdpSsoSession.getUserName();
	}

	/**
	* Sets the user name of this saml idp sso session.
	*
	* @param userName the user name of this saml idp sso session
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_samlIdpSsoSession.setUserName(userName);
	}

	/**
	* Returns the create date of this saml idp sso session.
	*
	* @return the create date of this saml idp sso session
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _samlIdpSsoSession.getCreateDate();
	}

	/**
	* Sets the create date of this saml idp sso session.
	*
	* @param createDate the create date of this saml idp sso session
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_samlIdpSsoSession.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this saml idp sso session.
	*
	* @return the modified date of this saml idp sso session
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _samlIdpSsoSession.getModifiedDate();
	}

	/**
	* Sets the modified date of this saml idp sso session.
	*
	* @param modifiedDate the modified date of this saml idp sso session
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_samlIdpSsoSession.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the saml idp sso session key of this saml idp sso session.
	*
	* @return the saml idp sso session key of this saml idp sso session
	*/
	@Override
	public java.lang.String getSamlIdpSsoSessionKey() {
		return _samlIdpSsoSession.getSamlIdpSsoSessionKey();
	}

	/**
	* Sets the saml idp sso session key of this saml idp sso session.
	*
	* @param samlIdpSsoSessionKey the saml idp sso session key of this saml idp sso session
	*/
	@Override
	public void setSamlIdpSsoSessionKey(java.lang.String samlIdpSsoSessionKey) {
		_samlIdpSsoSession.setSamlIdpSsoSessionKey(samlIdpSsoSessionKey);
	}

	@Override
	public boolean isNew() {
		return _samlIdpSsoSession.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_samlIdpSsoSession.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _samlIdpSsoSession.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_samlIdpSsoSession.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _samlIdpSsoSession.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _samlIdpSsoSession.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_samlIdpSsoSession.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _samlIdpSsoSession.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_samlIdpSsoSession.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_samlIdpSsoSession.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_samlIdpSsoSession.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SamlIdpSsoSessionWrapper((SamlIdpSsoSession)_samlIdpSsoSession.clone());
	}

	@Override
	public int compareTo(
		com.liferay.saml.model.SamlIdpSsoSession samlIdpSsoSession) {
		return _samlIdpSsoSession.compareTo(samlIdpSsoSession);
	}

	@Override
	public int hashCode() {
		return _samlIdpSsoSession.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.saml.model.SamlIdpSsoSession> toCacheModel() {
		return _samlIdpSsoSession.toCacheModel();
	}

	@Override
	public com.liferay.saml.model.SamlIdpSsoSession toEscapedModel() {
		return new SamlIdpSsoSessionWrapper(_samlIdpSsoSession.toEscapedModel());
	}

	@Override
	public com.liferay.saml.model.SamlIdpSsoSession toUnescapedModel() {
		return new SamlIdpSsoSessionWrapper(_samlIdpSsoSession.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _samlIdpSsoSession.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _samlIdpSsoSession.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_samlIdpSsoSession.persist();
	}

	@Override
	public boolean isExpired() {
		return _samlIdpSsoSession.isExpired();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SamlIdpSsoSessionWrapper)) {
			return false;
		}

		SamlIdpSsoSessionWrapper samlIdpSsoSessionWrapper = (SamlIdpSsoSessionWrapper)obj;

		if (Validator.equals(_samlIdpSsoSession,
					samlIdpSsoSessionWrapper._samlIdpSsoSession)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public SamlIdpSsoSession getWrappedSamlIdpSsoSession() {
		return _samlIdpSsoSession;
	}

	@Override
	public SamlIdpSsoSession getWrappedModel() {
		return _samlIdpSsoSession;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _samlIdpSsoSession.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _samlIdpSsoSession.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_samlIdpSsoSession.resetOriginalValues();
	}

	private SamlIdpSsoSession _samlIdpSsoSession;
}