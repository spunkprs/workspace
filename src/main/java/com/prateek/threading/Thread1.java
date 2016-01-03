package com.prateek.threading;

public class Thread1 extends Thread {
	
	private String info;
	
	public Thread1(final String info) {
		this.info = info;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello" +" " + i + info);
		}
	}
}
