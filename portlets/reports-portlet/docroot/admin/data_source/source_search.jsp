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

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

DisplayTerms displayTerms = searchContainer.getDisplayTerms();

String name = ParamUtil.getString(request, "name");
String driverUrl = ParamUtil.getString(request, "driverUrl");
%>

<liferay-ui:search-toggle
	buttonLabel="search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_reports_source_search"
>
	<aui:fieldset>
		<aui:input label="source-name" name="name" size="20" value="<%= name %>" />

		<aui:input label="jdbc-url" name="driverUrl" size="20" value="<%= driverUrl %>" />
	</aui:fieldset>
</liferay-ui:search-toggle>