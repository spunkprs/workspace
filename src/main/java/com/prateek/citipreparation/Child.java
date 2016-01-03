package com.prateek.citipreparation;

public class Child extends Parent {
	
	final private Integer a;
	
	public void print() {
		System.out.println("This is child class");
	}
	
	void add(int one, int two) {
		System.out.println("In child class");
	}

	public static void main(String[] args) {
       Child child = new Child(10);
       Parent parent = (Parent)child;
       parent.print();
       child.add(10, 20);
       parent.add(20, 30);
	}
	
	public Child(final int a) {
		super();
		this.a = a;
	}
}
