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

package com.liferay.vldap.server.directory.builder;

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.comparator.UserScreenNameComparator;
import com.liferay.vldap.server.directory.FilterConstraint;
import com.liferay.vldap.server.directory.SearchBase;
import com.liferay.vldap.server.directory.ldap.Directory;
import com.liferay.vldap.server.directory.ldap.UserDirectory;
import com.liferay.vldap.util.LdapUtil;
import com.liferay.vldap.util.PortletPropsValues;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.directory.shared.ldap.model.name.Dn;

/**
 * @author Jonathan Potter
 * @author Brian Wing Shun Chan
 */
public class UserBuilder extends DirectoryBuilder {

	@Override
	public boolean isValidAttribute(String attributeId, String value) {
		if (attributeId.equalsIgnoreCase("cn") ||
			attributeId.equalsIgnoreCase("gidNumber") ||
			attributeId.equalsIgnoreCase("givenName") ||
			attributeId.equalsIgnoreCase("mail") ||
			attributeId.equalsIgnoreCase("member") ||
			attributeId.equalsIgnoreCase("sambaSID") ||
			attributeId.equalsIgnoreCase("sn") ||
			attributeId.equalsIgnoreCase("uid") ||
			attributeId.equalsIgnoreCase("uidNumber") ||
			attributeId.equalsIgnoreCase("uuid")) {

			return true;
		}
		else if (attributeId.equalsIgnoreCase("createTimestamp") ||
				 attributeId.equalsIgnoreCase("displayName") ||
				 attributeId.equalsIgnoreCase("modifyTimestamp")) {

			if (value.equalsIgnoreCase("*")) {
				return true;
			}
		}
		else if (attributeId.equalsIgnoreCase("objectclass")) {
			if (value.equalsIgnoreCase("groupOfNames") ||
				value.equalsIgnoreCase("inetOrgPerson") ||
				value.equalsIgnoreCase("liferayPerson") ||
				value.equalsIgnoreCase("sambaSamAccount") ||
				value.equalsIgnoreCase("top") || value.equalsIgnoreCase("*")) {

				return true;
			}
		}

		return false;
	}

	@Override
	protected List<Directory> buildDirectories(
			SearchBase searchBase, List<FilterConstraint> filterConstraints)
		throws Exception {

		List<Directory> directories = new ArrayList<Directory>();

		for (Company company : searchBase.getCompanies()) {
			List<User> users = getUsers(company, searchBase, filterConstraints);

			for (User user : users) {
				Directory directory = new UserDirectory(
					searchBase.getTop(), company, user);

				directories.add(directory);
			}
		}

		return directories;
	}

	protected List<User> getUsers(
			Company company, SearchBase searchBase,
			List<FilterConstraint> filterConstraints)
		throws Exception {

		if (filterConstraints == null) {
			return UserLocalServiceUtil.getCompanyUsers(
				company.getCompanyId(), 0, (int)searchBase.getSizeLimit());
		}

		List<User> users = new ArrayList<User>();

		LinkedHashMap<String, Object> params =
			new LinkedHashMap<String, Object>();

		Group community = searchBase.getCommunity();

		if (community != null) {
			params.put("usersGroups", community.getGroupId());
		}

		Organization organization = searchBase.getOrganization();

		if (organization != null) {
			params.put("usersOrgs", organization.getOrganizationId());
		}

		Role role = searchBase.getRole();

		if (role != null) {
			params.put("usersRoles", role.getRoleId());
		}

		UserGroup userGroup = searchBase.getUserGroup();

		if (userGroup != null) {
			params.put("usersUserGroups", userGroup.getUserGroupId());
		}

		for (FilterConstraint filterConstraint : filterConstraints) {
			if (!isValidFilterConstraint(filterConstraint)) {
				continue;
			}

			String member = filterConstraint.getValue("member");

			if (!putParams(params, member)) {
				continue;
			}

			String gidNumber = filterConstraint.getValue("gidNumber");

			if ((gidNumber != null) &&
				!gidNumber.equals(StringPool.STAR) &&
				!gidNumber.equals(PortletPropsValues.POSIX_GROUP_ID)) {

				continue;
			}

			String uuid = filterConstraint.getValue("uuid");

			if (uuid != null) {
				users.add(UserLocalServiceUtil.getUserByUuid(uuid));

				continue;
			}

			String firstName = filterConstraint.getValue("givenName");
			String lastName = filterConstraint.getValue("sn");

			String screenName = filterConstraint.getValue("cn");

			if (screenName == null) {
				screenName = filterConstraint.getValue("uid");
			}

			if ((screenName != null) && screenName.equals(StringPool.STAR)) {
				screenName = null;
			}

			String emailAddress = filterConstraint.getValue("mail");

			String uidNumber = filterConstraint.getValue("uidNumber");
			String sambaSID = filterConstraint.getValue("sambaSID");

			List<User> searchUsers = null;

			if (uidNumber != null) {
				searchUsers = new ArrayList<User>();

				long userId = GetterUtil.getLong(uidNumber);

				User user = UserLocalServiceUtil.fetchUser(userId);

				if (user == null) {
					continue;
				}

				searchUsers.add(user);
			}
			else if (sambaSID != null) {
				searchUsers = new ArrayList<User>();

				int x = sambaSID.lastIndexOf(CharPool.DASH);

				if (x == -1) {
					continue;
				}

				int y = sambaSID.lastIndexOf(CharPool.DASH, x - 1);

				if (y == -1) {
					continue;
				}

				long userId = GetterUtil.getLong(sambaSID.substring(x + 1));

				User user = UserLocalServiceUtil.fetchUser(userId);

				if (user == null) {
					continue;
				}

				long companyId = GetterUtil.getLong(
					sambaSID.substring(y + 1, x));

				if (companyId != user.getCompanyId()) {
					continue;
				}

				searchUsers.add(user);
			}
			else {
				searchUsers = UserLocalServiceUtil.search(
					company.getCompanyId(), firstName, null, lastName,
					screenName, emailAddress, WorkflowConstants.STATUS_APPROVED,
					params, true, 0, PortletPropsValues.SEARCH_MAX_SIZE,
					new UserScreenNameComparator());
			}

			for (User user : searchUsers) {
				if ((screenName != null) &&
					!screenName.equals(user.getScreenName())) {

					continue;
				}

				if ((emailAddress != null) &&
					!emailAddress.equals(user.getEmailAddress())) {

					continue;
				}

				users.add(user);
			}

			if (users.size() > searchBase.getSizeLimit()) {
				users = ListUtil.subList(
					users, 0, (int)searchBase.getSizeLimit());
			}
		}

		return users;
	}

	protected boolean putParams(Map<String, Object> params, String member)
		throws Exception {

		if (member == null) {
			return true;
		}

		Dn dn = new Dn(member);

		String companyWebId = LdapUtil.getRdnValue(dn, 1);
		String type = LdapUtil.getRdnValue(dn, 2);
		String typeValue = LdapUtil.getRdnValue(dn, 3);

		Company company = CompanyLocalServiceUtil.getCompanyByWebId(
			companyWebId);

		if (type.equalsIgnoreCase("Communities")) {
			Group group = GroupLocalServiceUtil.getGroup(
				company.getCompanyId(), typeValue);

			params.put("usersGroups", group.getGroupId());
		}
		else if (type.equalsIgnoreCase("Organizations")) {
			Organization organization =
				OrganizationLocalServiceUtil.getOrganization(
					company.getCompanyId(), typeValue);

			params.put("usersOrgs", organization.getOrganizationId());
		}
		else if (type.equalsIgnoreCase("Roles")) {
			Role role = RoleLocalServiceUtil.getRole(
				company.getCompanyId(), typeValue);

			params.put("usersRoles", role.getRoleId());
		}
		else if (type.equalsIgnoreCase("User Groups")) {
			UserGroup userGroup = UserGroupLocalServiceUtil.getUserGroup(
				company.getCompanyId(), typeValue);

			params.put("usersUserGroups", userGroup.getUserGroupId());
		}
		else {
			return false;
		}

		return true;
	}

}