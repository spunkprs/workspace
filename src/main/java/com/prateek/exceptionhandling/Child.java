package com.prateek.exceptionhandling;

import java.io.IOException;

public class Child extends Parent {

public void method() throws IOException {
	//super.method();
	System.out.println("In Child Class");
}

public void xyz() throws Exception {
	super.method();
}

}
