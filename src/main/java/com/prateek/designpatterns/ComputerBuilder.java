package com.prateek.designpatterns;

public class ComputerBuilder {

	private String HDD;
	private String RAM;
	private boolean isBluetoothEnabled;
	private boolean isWiFiEnabled;
	private Boolean isGraphicCardEnabled;
	
	public ComputerBuilder setIsGraphicCardEnabled(final Boolean isGraphicCardEnabled) {
		this.isGraphicCardEnabled = isGraphicCardEnabled;
		return this;
	}

	public ComputerBuilder(final String HDD, final String RAM) {
		this.HDD = HDD;
		this.RAM = RAM;
	}

	public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
		this.isBluetoothEnabled = isBluetoothEnabled;
		return this;
	}

	public ComputerBuilder setWiFiEnabled(boolean isWiFiEnabled) {
		this.isWiFiEnabled = isWiFiEnabled;
		return this;
	}
	
	public Computer build() {
		return new Computer(this);
	}

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	public boolean isWiFiEnabled() {
		return isWiFiEnabled;
	}

	public Boolean isGraphicCardEnabled() {
		return isGraphicCardEnabled;
	}
	
}
