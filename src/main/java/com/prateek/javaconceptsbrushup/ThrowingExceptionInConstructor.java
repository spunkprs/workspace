package com.prateek.javaconceptsbrushup;

public class ThrowingExceptionInConstructor {

	public static void main(String[] args) {
     
		ThrowingExceptionInConstructor obj = null;
		
		try {
			obj = new ThrowingExceptionInConstructor();
		} catch(Exception e) {
			System.out.println("Exception Caught" +" "+e);
			obj.method();
		}
	}
	
	private ThrowingExceptionInConstructor() throws Exception {
		throw new Exception("Exception Thrown Inside Constructor");
	}
	
	private void method() {
		System.out.println("Method Called");
	}
}
