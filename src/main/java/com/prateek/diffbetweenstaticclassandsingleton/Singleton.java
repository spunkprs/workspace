package com.prateek.diffbetweenstaticclassandsingleton;

public class Singleton {

	private static Singleton object;
	
	public static Singleton getInstance() {
			if (null != object) {
				return object;
			}
			object = new Singleton();
		
		return object;
	}
	
	private Singleton() {
		throw new RuntimeException();
	}
}
