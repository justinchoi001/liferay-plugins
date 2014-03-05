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

package com.liferay.portal.security.samba;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.security.MessageDigest;

import jcifs.util.DES;
import jcifs.util.MD4;

/**
 * @author Minhchau Dang
 */
public class PortalSambaUtil {

	public static void checkAttributes() {
		_checkAttribute("sambaLMPassword");
		_checkAttribute("sambaNTPassword");
	}

	public static String getSambaLMPassword(User user) throws Exception {
		ExpandoBridge expandoBridge = user.getExpandoBridge();

		return (String)expandoBridge.getAttribute("sambaLMPassword", false);
	}

	public static String getSambaNTPassword(User user) throws Exception {
		ExpandoBridge expandoBridge = user.getExpandoBridge();

		return (String)expandoBridge.getAttribute("sambaNTPassword", false);
	}

	public static void setSambaLMPassword(User user, String password)
		throws Exception {

		ExpandoBridge expandoBridge = user.getExpandoBridge();

		String sambaLMPassword = _getSambaLMPassword(password);

		expandoBridge.setAttribute("sambaLMPassword", sambaLMPassword, false);
	}

	public static void setSambaNTPassword(User user, String password)
		throws Exception {

		ExpandoBridge expandoBridge = user.getExpandoBridge();

		String sambaNTPassword = _getSambaNTPassword(password);

		expandoBridge.setAttribute("sambaNTPassword", sambaNTPassword, false);
	}

	private static void _checkAttribute(String attributeName) {
		long[] companyIds = PortalUtil.getCompanyIds();

		for (long companyId : companyIds) {
			ExpandoBridge expandoBridge =
				ExpandoBridgeFactoryUtil.getExpandoBridge(
					companyId, User.class.getName());

			if (!expandoBridge.hasAttribute(attributeName)) {
				try {
					expandoBridge.addAttribute(attributeName, false);
				}
				catch (Exception e) {
					if (_log.isWarnEnabled()) {
						_log.warn(e, e);
					}
				}
			}

			UnicodeProperties properties = expandoBridge.getAttributeProperties(
				attributeName);

			properties.put(
				ExpandoColumnConstants.PROPERTY_HIDDEN, StringPool.TRUE);

			expandoBridge.setAttributeProperties(
				attributeName, properties, false);
		}
	}

	private static String _getSambaLMPassword(String password)
		throws Exception {

		password = password.toUpperCase();

		byte[] passwordBytes = password.getBytes("US-ASCII");

		byte[][] encryptionKeys = new byte[2][7];

		System.arraycopy(
			passwordBytes, 0, encryptionKeys[0], 0,
			Math.min(7, passwordBytes.length));

		if (passwordBytes.length > 7) {
			System.arraycopy(
				passwordBytes, 7, encryptionKeys[1], 0,
				Math.min(7, passwordBytes.length - 7));
		}

		byte[][] encryptedValues = new byte[2][8];

		DES des1 = new DES(encryptionKeys[0]);

		des1.encrypt(_SAMBA_LM_CONSTANT, encryptedValues[0]);

		DES des2 = new DES(encryptionKeys[1]);

		des2.encrypt(_SAMBA_LM_CONSTANT, encryptedValues[1]);

		byte[] sambaLMPasswordBytes = new byte[16];

		System.arraycopy(encryptedValues[0], 0, sambaLMPasswordBytes, 0, 8);
		System.arraycopy(encryptedValues[1], 0, sambaLMPasswordBytes, 8, 8);

		String sambaLMPassword = StringUtil.bytesToHexString(
			sambaLMPasswordBytes);

		sambaLMPassword = sambaLMPassword.toUpperCase();

		return sambaLMPassword;
	}

	private static String _getSambaNTPassword(String password)
		throws Exception {

		byte[] passwordBytes = password.getBytes("UTF-16LE");

		MessageDigest messageDigest = new MD4();

		byte[] sambaNTPasswordBytes = messageDigest.digest(passwordBytes);

		String sambaNTPassword = StringUtil.bytesToHexString(
			sambaNTPasswordBytes);

		sambaNTPassword = sambaNTPassword.toUpperCase();

		return sambaNTPassword;
	}

	// KGS!@#$%

	private static final byte[] _SAMBA_LM_CONSTANT = {
		(byte)0x4b, (byte)0x47, (byte)0x53, (byte)0x21, (byte)0x40, (byte)0x23,
		(byte)0x24, (byte)0x25
	};

	private static Log _log = LogFactoryUtil.getLog(PortalSambaUtil.class);

}