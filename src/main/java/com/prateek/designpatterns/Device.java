package com.prateek.designpatterns;

import java.util.HashSet;
import java.util.Set;

public abstract class Device {
	
	private int deviceId;
	private Set<Router> registeredRouters;
	private Router currentlyConnectedTo;
	
	public Device(final int deviceId) {
		this.deviceId = deviceId;
	}
	
	abstract boolean isDeviceInReach(final Router router);
	abstract boolean isDeviceWillingToJoin(final Router router);
	abstract boolean isDeviceWillingToRegister(final Router router);
	
	public void unRegisterRouter(final Router router) {
		
	}

	public Set<Router> getRegisteredRouters() {
		return registeredRouters;
	}

	public void setRegisteredRouters(Set<Router> registeredRouters) {
		this.registeredRouters = registeredRouters;
	}

	public Router getCurrentlyConnectedTo() {
		return currentlyConnectedTo;
	}

	public void setCurrentlyConnectedTo(Router currentlyConnectedTo) {
		this.currentlyConnectedTo = currentlyConnectedTo;
	}
	
	public void addRouterToRegisteredRouters(final Router router) {
		if (registeredRouters != null) {
			addRouter(router);
		} else {
			registeredRouters = new HashSet<Router>();
			addRouter(router);
		}
	}
	
	private void addRouter(final Router router) {
		if (!registeredRouters.contains(router)) {
			registeredRouters.add(router);
		}
	}
	
	public void removeRouter(final Router router) {
		if (registeredRouters.contains(router)) {
			registeredRouters.remove(router);
		}
	}
}
