package com.prateek.javaconceptsbrushup;

public class InstanceOfUsage {

	public static void main(String[] args) {
			Bike b1 = new Bike();
			Bike b2 = new Pulsar();
			Pulsar b3 = new Pulsar();
			System.out.println(b1 instanceof Bike);
			System.out.println(b2 instanceof Pulsar);
			System.out.println(b3 instanceof Bike);
	}
}
