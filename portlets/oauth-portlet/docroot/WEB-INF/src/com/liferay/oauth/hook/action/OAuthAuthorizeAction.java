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

package com.liferay.oauth.hook.action;

import com.liferay.compat.portal.kernel.util.HttpUtil;
import com.liferay.oauth.util.PortletKeys;
import com.liferay.portal.kernel.portlet.WindowStateFactory;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;

import java.io.IOException;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ivica Cardic
 */
public class OAuthAuthorizeAction extends BaseStrutsAction {

	@Override
	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		if (!isSignedIn()) {
			return redirectToLogin(request, response);
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			request, PortletKeys.AUTHORIZE, themeDisplay.getPlid(),
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("saveLastPath", "0");

		String oauthCallback = request.getParameter(
			net.oauth.OAuth.OAUTH_CALLBACK);

		if (Validator.isNotNull(oauthCallback)) {
			portletURL.setParameter(
				net.oauth.OAuth.OAUTH_CALLBACK, oauthCallback);
		}

		portletURL.setParameter(
			net.oauth.OAuth.OAUTH_TOKEN,
			request.getParameter(net.oauth.OAuth.OAUTH_TOKEN));
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(getWindowState(request));

		String redirect = portletURL.toString();

		response.sendRedirect(redirect);

		return null;
	}

	protected WindowState getWindowState(HttpServletRequest request) {
		String windowStateString = ParamUtil.getString(request, "windowState");

		if (Validator.isNotNull(windowStateString)) {
			return WindowStateFactory.getWindowState(windowStateString);
		}

		return WindowState.MAXIMIZED;
	}

	protected boolean isSignedIn() {
		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		if ((permissionChecker == null) || !permissionChecker.isSignedIn()) {
			return false;
		}

		return true;
	}

	protected String redirectToLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		StringBundler sb = new StringBundler(4);

		sb.append(themeDisplay.getPathMain());
		sb.append("/portal/login?redirect=");
		sb.append(HttpUtil.encodeURL(request.getRequestURI()));

		String queryString = request.getQueryString();

		if (Validator.isNotNull(queryString)) {
			sb.append(
				HttpUtil.encodeURL(StringPool.QUESTION.concat(queryString)));
		}

		response.sendRedirect(sb.toString());

		return null;
	}

}