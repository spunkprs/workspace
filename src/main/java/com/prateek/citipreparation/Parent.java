package com.prateek.citipreparation;

public class Parent extends GrandParent {

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
	
	/*
	public static void main(final String ar[]) {
		Child c = new Child(10);
		Parent p = (Parent)c;
		//Considering print() method in Parent class as private 
		//then calling it would only leads to calling method present in parent class 
		//but not in child class run time polymorphism didn't work 
		//as print() method in parent is private.
		p.print();
	}
	*/
}
