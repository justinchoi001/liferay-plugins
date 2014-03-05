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

package com.liferay.portal.resiliency.spi.monitor;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.resiliency.spi.model.SPIDefinition;
import com.liferay.portal.resiliency.spi.util.SPIAdminConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Michael C. Han
 */
public class SPIDefinitionMonitorImpl implements SPIDefinitionMonitor {

	public void afterPropertiesSet() {
		_monitorThread = new Thread(new _SPIMonitor(), "SPIMonitorThread");

		_monitorThread.setDaemon(true);

		_monitorThread.start();
	}

	public void destroy() {
		_stopped = true;

		_monitorThread.interrupt();
	}

	public void performHealthCheck() {
		Lock readLock = _readWriteLock.readLock();

		readLock.lock();

		try {
			for (SPIDefinition spiDefinition : _spiDefinitions.values()) {
				if (spiDefinition.isAlive()) {
					continue;
				}

				spiDefinition.deleteBaseDir();

				Message message = new Message();

				message.put(
					"spiDefinitionId", spiDefinition.getSpiDefinitionId());
				message.put("status", SPIAdminConstants.STATUS_STOPPED);

				MessageBusUtil.sendMessage(
					_SPI_STATUS_DESTINATION_NAME, message);
			}
		}
		finally {
			readLock.unlock();
		}
	}

	@Override
	public void register(SPIDefinition spiDefinition) {
		Lock writeLock = _readWriteLock.writeLock();

		writeLock.lock();

		try {
			if (_spiDefinitions.containsKey(
					spiDefinition.getSpiDefinitionId())) {

				return;
			}

			_spiDefinitions.put(
				spiDefinition.getSpiDefinitionId(), spiDefinition);
		}
		finally {
			writeLock.unlock();
		}
	}

	public void setInterval(long interval) {
		_interval = interval;
	}

	@Override
	public void unregister() {
		Lock writeLock = _readWriteLock.writeLock();

		writeLock.lock();

		try {
			_spiDefinitions.clear();
		}
		finally {
			writeLock.unlock();
		}
	}

	@Override
	public void unregister(long spiDefinitionId) {
		Lock writeLock = _readWriteLock.writeLock();

		writeLock.lock();

		try {
			_spiDefinitions.remove(spiDefinitionId);
		}
		finally {
			writeLock.unlock();
		}
	}

	private static final String _SPI_STATUS_DESTINATION_NAME =
		"liferay/spi_status";

	private long _interval = 60000;
	private Thread _monitorThread;
	private ReadWriteLock _readWriteLock = new ReentrantReadWriteLock();
	private Map<Long, SPIDefinition> _spiDefinitions =
		new HashMap<Long, SPIDefinition>();
	private boolean _stopped;

	private class _SPIMonitor implements Runnable {

		@Override
		public void run() {
			do {
				try {
					Thread.sleep(_interval);
				}
				catch (InterruptedException e) {
				}

				performHealthCheck();
			}
			while (!_stopped);
		}
	}

}