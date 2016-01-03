package com.prateek.exceptionhandling;

import java.io.IOException;

public class Parent {

	public void method() throws IOException {
		System.out.println("In Parent Class");
		throw new IOException("Exception from parent class");
	}
}
