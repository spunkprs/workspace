package com.prateek.designpatterns;

public class DeviceOne extends Device {

	public DeviceOne(final int deviceId) {
		super(deviceId);
	}

	@Override
	boolean isDeviceInReach(final Router router) {
		//Logic to determine whether device is in range of Router
		return true;
	}

	@Override
	boolean isDeviceWillingToJoin(final Router router) {
		//Some logic to decide whether to join or not.
		return true;
	}

	@Override
	boolean isDeviceWillingToRegister(final Router router) {
		//Logic to determine whether to register with router or not.
		return true;
	}
}
