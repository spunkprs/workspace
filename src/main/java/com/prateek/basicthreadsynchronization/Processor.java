package com.prateek.basicthreadsynchronization;

public class Processor extends Thread {

	private volatile Boolean running;
	private String info;
	
	public Processor(boolean running, String info) {
		this.running = running;
		this.info = info;
	}
	
	public void run() {
		while(running) {
			System.out.println(info);
		}
	}
	
	public void shutdown() {
		this.running = false;
	}
}
