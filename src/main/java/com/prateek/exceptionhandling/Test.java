package com.prateek.exceptionhandling;


public class Test {

	public static void main(String[] args) {
      Parent parent = new Child();
      System.out.println("Object created");
      try {
		parent.method();
	} catch (Exception e) {
		e.printStackTrace();
	} 
      
	}
}
