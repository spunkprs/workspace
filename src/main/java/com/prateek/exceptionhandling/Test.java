package com.prateek.exceptionhandling;


public class Test {

	public static void main(String[] args) {
	//http://www.javatpoint.com/exception-handling-with-method-overriding
      Parent parent = new Child();
      System.out.println("Object created");
      try {
		parent.method();
	} catch (Exception e) {
		e.printStackTrace();
	} 
      
	}
}
