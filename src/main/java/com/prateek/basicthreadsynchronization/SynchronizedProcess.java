package com.prateek.basicthreadsynchronization;

public class SynchronizedProcess {
	
	private volatile int counter;
	
	public static void main(String[] args) {
		
     SynchronizedProcess process = new SynchronizedProcess();
     process.startProcess();
     process.printCounter();
	}
	
	private synchronized void increment() {
		counter++;
	}
	
	private void startProcess() {
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}
			}
		});
		
       Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}
			}

		});
       
       t1.start();
       t2.start();
       
       try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private void printCounter() {
		System.out.println("Value of counter"+" "+ counter);
	}
}
