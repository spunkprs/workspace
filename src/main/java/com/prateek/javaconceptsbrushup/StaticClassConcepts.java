package com.prateek.javaconceptsbrushup;

public class StaticClassConcepts {
	private static ABC obj = new ABC();
	   
	public static void main(String[] args) {
      System.out.println("Executing main method");
      StaticClassConcepts obj = null;
      obj.methodOne();
	}
	
	public static void methodOne() {
		System.out.println("Inside method one");
	}

}

class ABC {
	
	protected ABC() {
		System.out.println("In ABC class constructor");
	}
}
