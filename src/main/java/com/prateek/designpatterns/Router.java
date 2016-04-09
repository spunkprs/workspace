package com.prateek.designpatterns;

import java.util.HashMap;
import java.util.Map;

public abstract class Router {
	
private Map<Device, Boolean> registeredDevices;

protected void makeConnectionWithAlreadyRegisteredDevices() {
	for (Device device : registeredDevices.keySet()) {
		if (device.isDeviceInReach(this) && !device.getCurrentlyConnectedTo().equals(this)) {
			if (device.isDeviceWillingToJoin(this)) {
				registeredDevices.put(device, true);
				device.setCurrentlyConnectedTo(this);
			}
		}
	}
}

protected void registerDevice(final Device device) {
	if (registeredDevices != null) {
		register(device);
	} else {
		registeredDevices = new HashMap<Device, Boolean>();
		register(device);
	}
}

protected void unregisterDevice(final Device device) {
	if (registeredDevices.containsKey(device)) {
		registeredDevices.remove(device);
		final Router router = device.getCurrentlyConnectedTo();
		unregisterRouter(device);
	}
}

private void unregisterRouter(final Device device) {
	final Router router = device.getCurrentlyConnectedTo();
	if (router != null) {
		if (this.equals(router)) {
			device.setCurrentlyConnectedTo(null);
			removeRouter(router, device);
		} else {
			removeRouter(router, device);
		}
	} else {
		removeRouter(this, device);
	}
}

private void removeRouter(final Router router, final Device device) {
	device.removeRouter(router);
}

private void register(final Device device) {
	if (!registeredDevices.containsKey(device) && device.isDeviceInReach(this) && device.isDeviceWillingToRegister(this)) {
		registeredDevices.put(device, false);
		device.addRouterToRegisteredRouters(this);
	}
}

}
