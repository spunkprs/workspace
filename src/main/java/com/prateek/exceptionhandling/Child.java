package com.prateek.exceptionhandling;

public class Child extends Parent {

public void method() throws RuntimeException {
	//super.method();
	System.out.println("In Child Class");
}

public void xyz() throws Exception {
	super.method();
}

}
