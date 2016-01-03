package com.prateek.citipreparation;

public class Parent {

	protected Parent() {
		System.out.println("Parent Initialized");
	}
	
	/*
	 * Across package default won't be considered as overridden. 
	void print() {
		System.out.println("This is parent class");
	}
	*/
	
	protected void print() {
		System.out.println("This is parent class");
	}
	
	protected void add(long operandOne, long operandTwo) {
		System.out.println("In parent class");
	}
}
