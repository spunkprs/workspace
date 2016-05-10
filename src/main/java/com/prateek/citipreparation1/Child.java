package com.prateek.citipreparation1;

import com.prateek.citipreparation.Parent;

public class Child extends com.prateek.citipreparation.Parent {
	
	protected void print() {
		System.out.println("This is child class in different package");
	}
	
	protected void add(long operandOne, long operandTwo) {
		System.out.println("Adding variables in child class of different package");
	}

	public static void main(final String ar[]) {
		Parent p = new Child();
	}
}
