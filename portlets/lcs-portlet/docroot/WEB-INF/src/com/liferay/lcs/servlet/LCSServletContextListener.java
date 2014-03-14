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

package com.liferay.lcs.servlet;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.HotDeployMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Ivica Cardic
 */
public class LCSServletContextListener
	extends BasePortalLifecycle implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		portalDestroy();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		registerPortalLifecycle();
	}

	protected void changeMonitoringConfiguration(boolean deployed)
		throws Exception {

		Method findLoadedClassMethod = ClassLoader.class.getDeclaredMethod(
			"findLoadedClass", String.class);

		findLoadedClassMethod.setAccessible(true);

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		String propsValuesClassName = "com.liferay.portal.util.PropsValues";

		Class propsValuesClass = (Class)findLoadedClassMethod.invoke(
			portalClassLoader, propsValuesClassName);

		String propsUtilClassName = "com.liferay.portal.util.PropsUtil";

		Class propsUtilClass = (Class)findLoadedClassMethod.invoke(
			portalClassLoader, propsUtilClassName);

		Method getConfigurationMethod = propsUtilClass.getDeclaredMethod(
			"_getConfiguration");

		getConfigurationMethod.setAccessible(true);

		Field instanceField = propsUtilClass.getDeclaredField("_instance");

		instanceField.setAccessible(true);

		Object instance = instanceField.get(propsUtilClass);

		Configuration configuration =
			(Configuration)getConfigurationMethod.invoke(instance);

		Field modifiersField = Field.class.getDeclaredField("modifiers");

		modifiersField.setAccessible(true);

		String monitoringFilterClassName =
			"com.liferay.portal.servlet.filters.monitoring.MonitoringFilter";

		Class monitoringFilterClass = (Class)findLoadedClassMethod.invoke(
			portalClassLoader, monitoringFilterClassName);

		String monitoringPortletClassName =
			"com.liferay.portlet.MonitoringPortlet";

		Class monitoringPortletClass = (Class)findLoadedClassMethod.invoke(
			portalClassLoader, monitoringPortletClassName);

		//changeHibernateGenerateStatisticsProperty(
		//	configuration, deployed, modifiersField, propsValuesClass);
		//changeMonitoringDataSampleThreadLocalProperty(
		//	configuration, deployed, modifiersField, propsValuesClass);
		//changeMonitoringPortalRequestProperty(
		//	configuration, deployed, monitoringFilterClass, propsValuesClass);
		//changeMonitoringPortletActionRequestProperty(
		//	configuration, deployed, monitoringPortletClass, propsValuesClass);
		//changeMonitoringPortletEventRequestProperty(
		//	configuration, deployed, monitoringPortletClass, propsValuesClass);
		//changeMonitoringPortletRenderRequestProperty(
		//	configuration, deployed, monitoringPortletClass, propsValuesClass);
		//changeMonitoringPortletResourceRequestProperty(
		//	configuration, deployed, monitoringPortletClass, propsValuesClass);
	}
	@Override
	protected void doPortalDestroy() throws Exception {
		MessageBusUtil.unregisterMessageListener(
			DestinationNames.HOT_DEPLOY, _messageListener);
	}

	@Override
	protected void doPortalInit() {
		_messageListener = new HotDeployMessageListener(
			"lcs-portlet") {

			@Override
			protected void onDeploy(Message message) throws Exception {
				changeMonitoringConfiguration(true);

				loadClusterLinkHelperClass();
			}

			@Override
			protected void onUndeploy(Message message) throws Exception {
				changeMonitoringConfiguration(false);
			}

		};

		MessageBusUtil.registerMessageListener(
			DestinationNames.HOT_DEPLOY, _messageListener);
	}

	protected void loadClusterLinkHelperClass() throws Exception {
		Method findLoadedClassMethod = ClassLoader.class.getDeclaredMethod(
			"findLoadedClass", String.class);

		findLoadedClassMethod.setAccessible(true);

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		String className = "com.liferay.lcs.util.ClusterLinkHelper";

		if (findLoadedClassMethod.invoke(portalClassLoader, className)
				!= null) {

			return;
		}

		InputStream inputStream = null;

		try {
			Method defineClassMethod = ClassLoader.class.getDeclaredMethod(
				"defineClass", String.class, byte[].class, int.class,
				int.class);

			defineClassMethod.setAccessible(true);

			Class<?> clazz = getClass();

			ClassLoader classLoader = clazz.getClassLoader();

			String classResource = StringUtil.replace(
				className, StringPool.PERIOD, StringPool.SLASH);

			classResource += ".class";

			inputStream = classLoader.getResourceAsStream(classResource);

			byte[] bytes = FileUtil.getBytes(inputStream);

			defineClassMethod.invoke(
				portalClassLoader, className, bytes, 0, bytes.length);
		}
		catch (IOException ioe) {
			throw new ClassNotFoundException(
				"Unable to load " + className, ioe);
		}
		finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	private MessageListener _messageListener;

}