package com.prateek.pubmaticchallenge;

public class Counter {

	private static Counter counter = null;
	private int num;
	public synchronized static Counter getCounter() {
		if (counter == null) {
			counter = new Counter();
			return counter;
		} else {
			return counter;
		}
	}
	
	private Counter() {
	this.num = 0;
	}
}
