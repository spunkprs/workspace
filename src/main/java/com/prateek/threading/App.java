package com.prateek.threading;

public class App {

	public static void main(String[] args) {
		
		Thread1 thread1 = new Thread1("Thread 1");
		//thread1.start();(Multithreaded)
		//thread1.run();(Single Threaded)
		thread1.start();
		
		Thread1 thread2 = new Thread1("Thread 2");
		//thread2.start();(Multithreaded)
		//thread2.run();(Single Threaded)
		thread2.start();
		
		Thread thread = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("Via Runnable");			}
		});
		
		thread.start();
	}
}
