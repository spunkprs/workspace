package com.prateek.designpatterns;

public class Computer {

	private String HDD;
	private String RAM;
	private boolean isBluetoothEnabled;
	private boolean isWiFiEnabled;
	private Boolean isGraphicCardEnabled;
	
	public Computer(final String HDD, final String RAM) {
		this.HDD = HDD;
		this.RAM = RAM;
	}

	Computer(final ComputerBuilder computerBuilder) {
		this.HDD = computerBuilder.getHDD();
		this.RAM = computerBuilder.getRAM();
		this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled();
		this.isWiFiEnabled = computerBuilder.isWiFiEnabled();
		this.isGraphicCardEnabled = computerBuilder.isGraphicCardEnabled();
	}
	
	public String toString() {
		return this.HDD + this.RAM + this.isBluetoothEnabled + this.isWiFiEnabled + this.isGraphicCardEnabled;
	}
}
