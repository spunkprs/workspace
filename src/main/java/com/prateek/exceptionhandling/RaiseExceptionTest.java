package com.prateek.exceptionhandling;

public class RaiseExceptionTest {

	public static void main(String[] args) {
		
     RaiseException re = new RaiseException();
     System.out.println(re.getCaughtException());
     System.out.println(re.isExceptionThrownInsideConstructor());
	}

}
