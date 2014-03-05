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

package com.liferay.oauth.service.persistence;

import com.liferay.oauth.model.OAuthApplication;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the o auth application service. This utility wraps {@link OAuthApplicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ivica Cardic
 * @see OAuthApplicationPersistence
 * @see OAuthApplicationPersistenceImpl
 * @generated
 */
public class OAuthApplicationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(OAuthApplication oAuthApplication) {
		getPersistence().clearCache(oAuthApplication);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OAuthApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OAuthApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OAuthApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OAuthApplication update(OAuthApplication oAuthApplication)
		throws SystemException {
		return getPersistence().update(oAuthApplication);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OAuthApplication update(OAuthApplication oAuthApplication,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(oAuthApplication, serviceContext);
	}

	/**
	* Returns all the o auth applications where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the o auth applications where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set where companyId = &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] findByCompanyId_PrevAndNext(
		long oAuthApplicationId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(oAuthApplicationId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the o auth applications that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId);
	}

	/**
	* Returns a range of all the o auth applications that the user has permission to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications that the user has permissions to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId(companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set of o auth applications that the user has permission to view where companyId = &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] filterFindByCompanyId_PrevAndNext(
		long oAuthApplicationId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId_PrevAndNext(oAuthApplicationId,
			companyId, orderByComparator);
	}

	/**
	* Removes all the o auth applications where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of o auth applications where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of o auth applications that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCompanyId(companyId);
	}

	/**
	* Returns all the o auth applications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the o auth applications where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set where userId = &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] findByUserId_PrevAndNext(
		long oAuthApplicationId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(oAuthApplicationId, userId,
			orderByComparator);
	}

	/**
	* Returns all the o auth applications that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserId(userId);
	}

	/**
	* Returns a range of all the o auth applications that the user has permission to view where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications that the user has permissions to view where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set of o auth applications that the user has permission to view where userId = &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] filterFindByUserId_PrevAndNext(
		long oAuthApplicationId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByUserId_PrevAndNext(oAuthApplicationId, userId,
			orderByComparator);
	}

	/**
	* Removes all the o auth applications where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of o auth applications where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of o auth applications that the user has permission to view where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByUserId(userId);
	}

	/**
	* Returns the o auth application where consumerKey = &#63; or throws a {@link com.liferay.oauth.NoSuchApplicationException} if it could not be found.
	*
	* @param consumerKey the consumer key
	* @return the matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByConsumerKey(
		java.lang.String consumerKey)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConsumerKey(consumerKey);
	}

	/**
	* Returns the o auth application where consumerKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param consumerKey the consumer key
	* @return the matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByConsumerKey(
		java.lang.String consumerKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByConsumerKey(consumerKey);
	}

	/**
	* Returns the o auth application where consumerKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param consumerKey the consumer key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByConsumerKey(
		java.lang.String consumerKey, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConsumerKey(consumerKey, retrieveFromCache);
	}

	/**
	* Removes the o auth application where consumerKey = &#63; from the database.
	*
	* @param consumerKey the consumer key
	* @return the o auth application that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication removeByConsumerKey(
		java.lang.String consumerKey)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByConsumerKey(consumerKey);
	}

	/**
	* Returns the number of o auth applications where consumerKey = &#63;.
	*
	* @param consumerKey the consumer key
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConsumerKey(java.lang.String consumerKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByConsumerKey(consumerKey);
	}

	/**
	* Returns all the o auth applications where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByC_N(
		long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_N(companyId, name);
	}

	/**
	* Returns a range of all the o auth applications where companyId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByC_N(
		long companyId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_N(companyId, name, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications where companyId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByC_N(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N(companyId, name, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByC_N_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_First(companyId, name, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByC_N_First(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_N_First(companyId, name, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByC_N_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_Last(companyId, name, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByC_N_Last(
		long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByC_N_Last(companyId, name, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set where companyId = &#63; and name LIKE &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] findByC_N_PrevAndNext(
		long oAuthApplicationId, long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_N_PrevAndNext(oAuthApplicationId, companyId, name,
			orderByComparator);
	}

	/**
	* Returns all the o auth applications that the user has permission to view where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByC_N(
		long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_N(companyId, name);
	}

	/**
	* Returns a range of all the o auth applications that the user has permission to view where companyId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByC_N(
		long companyId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByC_N(companyId, name, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications that the user has permissions to view where companyId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByC_N(
		long companyId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_N(companyId, name, start, end,
			orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set of o auth applications that the user has permission to view where companyId = &#63; and name LIKE &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param companyId the company ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] filterFindByC_N_PrevAndNext(
		long oAuthApplicationId, long companyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByC_N_PrevAndNext(oAuthApplicationId, companyId,
			name, orderByComparator);
	}

	/**
	* Removes all the o auth applications where companyId = &#63; and name LIKE &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_N(companyId, name);
	}

	/**
	* Returns the number of o auth applications where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_N(companyId, name);
	}

	/**
	* Returns the number of o auth applications that the user has permission to view where companyId = &#63; and name LIKE &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByC_N(companyId, name);
	}

	/**
	* Returns all the o auth applications where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @return the matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByU_N(
		long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_N(userId, name);
	}

	/**
	* Returns a range of all the o auth applications where userId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByU_N(
		long userId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_N(userId, name, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications where userId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findByU_N(
		long userId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_N(userId, name, start, end, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByU_N_First(
		long userId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_N_First(userId, name, orderByComparator);
	}

	/**
	* Returns the first o auth application in the ordered set where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByU_N_First(
		long userId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_N_First(userId, name, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByU_N_Last(
		long userId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByU_N_Last(userId, name, orderByComparator);
	}

	/**
	* Returns the last o auth application in the ordered set where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o auth application, or <code>null</code> if a matching o auth application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByU_N_Last(
		long userId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByU_N_Last(userId, name, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set where userId = &#63; and name LIKE &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param userId the user ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] findByU_N_PrevAndNext(
		long oAuthApplicationId, long userId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByU_N_PrevAndNext(oAuthApplicationId, userId, name,
			orderByComparator);
	}

	/**
	* Returns all the o auth applications that the user has permission to view where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @return the matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByU_N(
		long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByU_N(userId, name);
	}

	/**
	* Returns a range of all the o auth applications that the user has permission to view where userId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByU_N(
		long userId, java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByU_N(userId, name, start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications that the user has permissions to view where userId = &#63; and name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param name the name
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> filterFindByU_N(
		long userId, java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByU_N(userId, name, start, end, orderByComparator);
	}

	/**
	* Returns the o auth applications before and after the current o auth application in the ordered set of o auth applications that the user has permission to view where userId = &#63; and name LIKE &#63;.
	*
	* @param oAuthApplicationId the primary key of the current o auth application
	* @param userId the user ID
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication[] filterFindByU_N_PrevAndNext(
		long oAuthApplicationId, long userId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByU_N_PrevAndNext(oAuthApplicationId, userId,
			name, orderByComparator);
	}

	/**
	* Removes all the o auth applications where userId = &#63; and name LIKE &#63; from the database.
	*
	* @param userId the user ID
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByU_N(long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByU_N(userId, name);
	}

	/**
	* Returns the number of o auth applications where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @return the number of matching o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByU_N(long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByU_N(userId, name);
	}

	/**
	* Returns the number of o auth applications that the user has permission to view where userId = &#63; and name LIKE &#63;.
	*
	* @param userId the user ID
	* @param name the name
	* @return the number of matching o auth applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByU_N(long userId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByU_N(userId, name);
	}

	/**
	* Caches the o auth application in the entity cache if it is enabled.
	*
	* @param oAuthApplication the o auth application
	*/
	public static void cacheResult(
		com.liferay.oauth.model.OAuthApplication oAuthApplication) {
		getPersistence().cacheResult(oAuthApplication);
	}

	/**
	* Caches the o auth applications in the entity cache if it is enabled.
	*
	* @param oAuthApplications the o auth applications
	*/
	public static void cacheResult(
		java.util.List<com.liferay.oauth.model.OAuthApplication> oAuthApplications) {
		getPersistence().cacheResult(oAuthApplications);
	}

	/**
	* Creates a new o auth application with the primary key. Does not add the o auth application to the database.
	*
	* @param oAuthApplicationId the primary key for the new o auth application
	* @return the new o auth application
	*/
	public static com.liferay.oauth.model.OAuthApplication create(
		long oAuthApplicationId) {
		return getPersistence().create(oAuthApplicationId);
	}

	/**
	* Removes the o auth application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param oAuthApplicationId the primary key of the o auth application
	* @return the o auth application that was removed
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication remove(
		long oAuthApplicationId)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(oAuthApplicationId);
	}

	public static com.liferay.oauth.model.OAuthApplication updateImpl(
		com.liferay.oauth.model.OAuthApplication oAuthApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(oAuthApplication);
	}

	/**
	* Returns the o auth application with the primary key or throws a {@link com.liferay.oauth.NoSuchApplicationException} if it could not be found.
	*
	* @param oAuthApplicationId the primary key of the o auth application
	* @return the o auth application
	* @throws com.liferay.oauth.NoSuchApplicationException if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication findByPrimaryKey(
		long oAuthApplicationId)
		throws com.liferay.oauth.NoSuchApplicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(oAuthApplicationId);
	}

	/**
	* Returns the o auth application with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param oAuthApplicationId the primary key of the o auth application
	* @return the o auth application, or <code>null</code> if a o auth application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.oauth.model.OAuthApplication fetchByPrimaryKey(
		long oAuthApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(oAuthApplicationId);
	}

	/**
	* Returns all the o auth applications.
	*
	* @return the o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the o auth applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @return the range of o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the o auth applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.oauth.model.impl.OAuthApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of o auth applications
	* @param end the upper bound of the range of o auth applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.oauth.model.OAuthApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the o auth applications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of o auth applications.
	*
	* @return the number of o auth applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OAuthApplicationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OAuthApplicationPersistence)PortletBeanLocatorUtil.locate(com.liferay.oauth.service.ClpSerializer.getServletContextName(),
					OAuthApplicationPersistence.class.getName());

			ReferenceRegistry.registerReference(OAuthApplicationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OAuthApplicationPersistence persistence) {
	}

	private static OAuthApplicationPersistence _persistence;
}