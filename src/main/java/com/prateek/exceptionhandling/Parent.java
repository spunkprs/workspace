package com.prateek.exceptionhandling;

import java.io.IOException;

public class Parent {
	public void method() throws IOException {
		System.out.println("In Parent Class");
	}
	
	/*
	public void method() throws IllegalMonitorStateException {
		System.out.println("In Parent Class");
	}
	*/
}
