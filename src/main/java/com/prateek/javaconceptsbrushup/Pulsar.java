package com.prateek.javaconceptsbrushup;

public class Pulsar extends Bike {

	public int speed = 110;
	
	Pulsar() {
		super();
		System.out.println(this);
	}
	
	public static void main(String[] args) {
      Bike b = new Pulsar();
      System.out.println(b.speed);
	}
	
	public void init() {
		System.out.println("Pulsar initialized");
	}
}
