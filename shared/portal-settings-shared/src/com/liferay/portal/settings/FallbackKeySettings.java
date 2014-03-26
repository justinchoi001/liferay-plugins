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

package com.liferay.portal.settings;

import java.io.IOException;

import java.util.Map;

import javax.portlet.ValidatorException;

/**
 * @author Iván Zaera
 */
public class FallbackKeySettings implements Settings {

	public FallbackKeySettings(
		Settings settings, Map<String, String> fallbackKeys) {

		_settings = settings;
		_fallbackKeys = fallbackKeys;
	}

	@Override
	public String getValue(String key, String defaultValue) {
		if (key == null) {
			throw new IllegalArgumentException("Key is null");
		}

		while (key != null) {
			String value = _settings.getValue(key, null);

			if (value != null) {
				return value;
			}

			key = getFallbackKey(key);
		}

		return defaultValue;
	}

	@Override
	public String[] getValues(String key, String[] defaultValue) {
		if (key == null) {
			throw new IllegalArgumentException("Key is null");
		}

		while (key != null) {
			String[] values = _settings.getValues(key, null);

			if (values != null) {
				return values;
			}

			key = getFallbackKey(key);
		}

		return defaultValue;
	}

	@Override
	public void reset(String key) {
		_settings.reset(key);
	}

	@Override
	public Settings setValue(String key, String value) {
		return _settings.setValue(key, value);
	}

	@Override
	public Settings setValues(String key, String[] values) {
		return _settings.setValues(key, values);
	}

	@Override
	public void store() throws IOException, ValidatorException {
		_settings.store();
	}

	protected String getFallbackKey(String key) {
		return _fallbackKeys.get(key);
	}

	private Map<String, String> _fallbackKeys;
	private Settings _settings;

}