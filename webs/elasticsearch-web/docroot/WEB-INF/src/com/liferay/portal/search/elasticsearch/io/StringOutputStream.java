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

package com.liferay.portal.search.elasticsearch.io;

import com.liferay.portal.kernel.util.StringBundler;

import java.io.OutputStream;

/**
 * @author Michael C. Han
 */
public class StringOutputStream extends OutputStream {

	@Override
	public String toString() {
		return _sb.toString();
	}

	@Override
	public void write(int b) {
		_sb.append(b);
	}

	private StringBundler _sb = new StringBundler();

}