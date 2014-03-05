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

package com.liferay.saml.hook.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.saml.hook.upgrade.v1_0_0.UpgradeSamlIdpSpSession;
import com.liferay.saml.hook.upgrade.v1_0_0.UpgradeSamlSpAuthRequest;
import com.liferay.saml.hook.upgrade.v1_0_0.UpgradeSamlSpMessage;
import com.liferay.saml.hook.upgrade.v1_0_0.UpgradeSamlSpSession;

/**
 * @author Mika Koivisto
 */
public class UpgradeProcess_1_0_0 extends UpgradeProcess {

	@Override
	public int getThreshold() {
		return 100;
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgrade(UpgradeSamlIdpSpSession.class);
		upgrade(UpgradeSamlSpAuthRequest.class);
		upgrade(UpgradeSamlSpMessage.class);
		upgrade(UpgradeSamlSpSession.class);
	}

}