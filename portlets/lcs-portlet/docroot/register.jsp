<%--
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
--%>

<%@ include file="/init.jsp" %>

<h3><liferay-ui:message arguments="2" key="registration-step-x-2" /></h3>

<span class="alert alert-info lcs-alert">
	<liferay-ui:message key="please-add-information-about-your-server" />
</span>

<portlet:renderURL var="viewLCSClusterNodeURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="addLCSClusterNode" var="addLCSClusterNodeURL">
	<portlet:param name="redirect" value="<%= viewLCSClusterNodeURL %>" />
</portlet:actionURL>

<aui:form action="<%= addLCSClusterNodeURL %>" name="registrationFm">
	<aui:model-context model="<%= LCSClusterNode.class %>" />

	<%
	List<CorpEntryIdentifier> corpEntryIdentifiers = CorpEntryServiceUtil.getCorpEntryIdentifiers();
	%>

	<aui:select name="corpEntryId">

		<%
		long corpEntryId = ParamUtil.getLong(request, "corpEntryId");

		for (CorpEntryIdentifier corpEntryIdentifier : corpEntryIdentifiers) {
		%>

			<aui:option label="<%= corpEntryIdentifier.getName() %>" selected="<%= corpEntryId == corpEntryIdentifier.getCorpEntryId() %>" value="<%= corpEntryIdentifier.getCorpEntryId() %>" />

		<%
		}
		%>

	</aui:select>

	<%
	long corpEntryId = ParamUtil.getLong(request, "corpEntryId");

	if (corpEntryId == 0) {
		CorpEntryIdentifier corpEntryIdentifier = corpEntryIdentifiers.get(0);

		corpEntryId = corpEntryIdentifier.getCorpEntryId();
	}

	List<LCSClusterEntry> lcsClusterEntries = LCSClusterEntryServiceUtil.getCorpEntryLCSClusterEntries(corpEntryId);
	%>

	<aui:field-wrapper helpMessage="environment-help" label="environment-required">
		<span id="<portlet:namespace />lcsClusterEntryInputWrapper">
			<c:choose>
				<c:when test="<%= lcsClusterEntries.isEmpty() %>">
					<liferay-ui:message key="there-are-no-environments-created-yet" />
				</c:when>
				<c:when test="<%= lcsClusterEntries.size() == 1 %>">

					<%
					LCSClusterEntry lcsClusterEntry = lcsClusterEntries.get(0);
					%>

					<aui:input id="lcsClusterEntryId" name="lcsClusterEntryId" type="hidden" value="<%= lcsClusterEntry.getLcsClusterEntryId() %>" />

					<aui:input label="" name="lcsClusterEntryName" type="text" value="<%= lcsClusterEntry.getName() %>" />
				</c:when>
				<c:when test="<%= lcsClusterEntries.size() > 1 %>">
					<aui:select id="lcsClusterEntryId" label="" name="lcsClusterEntryId">

						<%
						long lcsClusterEntryId = ParamUtil.getLong(request, "lcsClusterEntryId");

						for (LCSClusterEntry lcsClusterEntry : lcsClusterEntries) {
						%>

							<aui:option label="<%= lcsClusterEntry.getName() %>" selected="<%= lcsClusterEntryId == lcsClusterEntry.getLcsClusterEntryId() %>" value="<%= lcsClusterEntry.getLcsClusterEntryId() %>" />

						<%
						}
						%>

					</aui:select>
				</c:when>
			</c:choose>
		</span>

		<aui:button-row>
			<aui:button name="addEnvironmentButton" value="add-new-environment" />
		</aui:button-row>
	</aui:field-wrapper>

	<aui:input name="name" />

	<aui:field-wrapper label="portal-key">
		<%= KeyGeneratorUtil.getKey() %>
	</aui:field-wrapper>

	<aui:input name="location" />

	<aui:input name="description" />

	<aui:input checked="<%= true %>" disabled="<%= !ClusterExecutorUtil.isEnabled() %>" id="registerAllClusterNodes" label="register-all-nodes-of-this-cluster" name="registerAllClusterNodes" type="checkbox" />

	<aui:button-row>
		<portlet:actionURL name="resetCredentials" var="resetCredentialsURL">
			<portlet:param name="redirect" value="<%= currentURL %>" />
		</portlet:actionURL>

		<aui:button href="<%= resetCredentialsURL.toString() %>" name="back" value="back" />

		<aui:button cssClass="btn-success" disabled="<%= true %>" name="register" type="submit" value="register" />
	</aui:button-row>
</aui:form>

<aui:script use="liferay-cloud-services">
	var lcsPortlet = new Liferay.Portlet.LCS(
		{
			namespace: '<portlet:namespace />'
		}
	);

	<portlet:renderURL var="addLCSClusterEntryURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="mvcPath" value="/add_lcs_cluster_entry.jsp" />
	</portlet:renderURL>

	lcsPortlet.initializeRegisterPage(
		{
			addLCSClusterEntryURL: '<%= addLCSClusterEntryURL %>',
			errorDuplicateEnvironment: '<%= UnicodeLanguageUtil.get(pageContext, "please-enter-an-unique-environment-name") %>',
			errorGenericEnvironment: '<%= UnicodeLanguageUtil.get(pageContext, "your-request-failed-to-complete") %>',
			errorRequiredEnvironmentName: '<%= UnicodeLanguageUtil.get(pageContext, "environment-name-is-required") %>',
			labelNewEnvironment: '<%= UnicodeLanguageUtil.get(pageContext, "new-environment") %>',
			serveCorpEntryURL: '<portlet:resourceURL id="serveCorpEntry" />',
			serveLCSClusterEntryURL: '<portlet:resourceURL id="serveLCSClusterEntry" />'
		}
	);
</aui:script>