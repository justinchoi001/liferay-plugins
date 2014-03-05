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

package com.liferay.sharepoint.connector;

import com.liferay.portal.kernel.util.StringPool;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Iván Zaera
 */
public class SharepointConnectionInfoTest {

	@Test
	public void testConstructorFailsWithInvalidSitePaths() {
		try {
			_buildSharepointConnectionInfoWithSitePath(StringPool.SLASH);

			Assert.fail("IllegalArgumentException not thrown for site path /");
		}
		catch (IllegalArgumentException iae) {
		}

		try {
			_buildSharepointConnectionInfoWithSitePath(
				"sitePathWithoutLeadingSlash");

			Assert.fail(
				"IllegalArgumentException not thrown for site path without a " +
					"leading /");
		}
		catch (IllegalArgumentException iae) {
		}

		try {
			_buildSharepointConnectionInfoWithSitePath(
				"/sitePathWithTrailingSlash/");

			Assert.fail(
				"IllegalArgumentException not thrown for site path with a " +
					"trailing /");
		}
		catch (IllegalArgumentException iae) {
		}
	}

	private void _buildSharepointConnectionInfoWithSitePath(String sitePath) {
		new SharepointConnectionInfo(
			_SERVER_PROTOCOL, _SERVER_ADDRESS, _SERVER_PORT, sitePath,
			_LIBRARY_NAME, _USERNAME, _PASSWORD);
	}

	private static final String _LIBRARY_NAME = "Documents";

	private static final String _PASSWORD = "password";

	private static final String _SERVER_ADDRESS = "liferay-20jf4ic";

	private static final int _SERVER_PORT = 80;

	private static final String _SERVER_PROTOCOL = "http";

	private static final String _USERNAME = "Administrator";

}