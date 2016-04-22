package com.prateek.designpatterns;

public class BuilderPatternImplementation {

	public static void main(String[] args) {
		final ComputerBuilder computerBuilder = new ComputerBuilder("HDD", "RAM");
		final Computer computer = computerBuilder.setBluetoothEnabled(true).build();
		System.out.println(computer);
	}
}
