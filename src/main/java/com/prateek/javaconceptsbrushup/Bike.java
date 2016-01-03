package com.prateek.javaconceptsbrushup;

public class Bike {
	public int speed = 60;
	
	Bike() {
		System.out.println(this);
		init();
		this.method();
	}
	
	public void init() {
		System.out.println("Bike initialized");
	}
	
	private void method() {
		System.out.println("In bike");
	}
}
