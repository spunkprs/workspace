package com.prateek.exceptionhandling;

public class RaiseException {
	
	private Exception exception;
	private boolean isExceptionThrownInsideConstructor;
	
	public RaiseException() {
		try {
			System.out.println(Temporary.class);
			getFields(Temporary.class);
			throw new Exception("Throwing Exception");
		} catch(Exception exception) {
			this.exception = exception;
			isExceptionThrownInsideConstructor = true;
		}
	}
	
	private void getFields(Class<Temporary> c) {
		for (java.lang.reflect.Field f : c.getDeclaredFields()) {
			f.setAccessible(true);
			System.out.println(f.getType());
		}
	}

	public Exception getCaughtException() {
		return exception;
	}
	
	public boolean isExceptionThrownInsideConstructor() {
		return isExceptionThrownInsideConstructor;
	}
	
	private static class Temporary {
		private int a;
		private String b;
		private ABC c;
		
	}
	
	private static class ABC {
		private String d;
	}
	
}
