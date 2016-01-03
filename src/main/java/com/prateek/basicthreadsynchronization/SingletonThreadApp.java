package com.prateek.basicthreadsynchronization;

public class SingletonThreadApp {

	private static volatile SingletonThreadApp singletonThreadInstance;
	private int counter = 0;
	
	public static void main(String[] args) {
     Thread thread1 = new Thread(new Runnable() {
		
		public void run() {
			SingletonThreadApp instance = createInstance();
			instance.setCounter(instance.getCounter() + 1);
			
			System.out.println("Single Instance through thread 1" +" "+ instance + " Counter" +" "+ instance.getCounter());
		}
	});
     
     Thread thread2 = new Thread(new Runnable() {
		
		public void run() {
			SingletonThreadApp instance = createInstance();
			instance.setCounter(instance.getCounter() + 1);
			System.out.println("Single Instance through thread 2" +" "+ instance + " Counter" +" "+ instance.getCounter());
		}
	});
     
     Thread thread3 = new Thread(new Runnable() {
 		
 		public void run() {
 			SingletonThreadApp instance = createInstance();
			instance.setCounter(instance.getCounter() + 1);
 			System.out.println("Single Instance through thread 3" +" "+ instance + " Counter" +" "+ instance.getCounter());
 		}
 	});
     
     Thread thread4 = new Thread(new Runnable() {
  		
  		public void run() {
  			SingletonThreadApp instance = createInstance();
			instance.setCounter(instance.getCounter() + 1);
  			System.out.println("Single Instance through thread 4" +" "+ instance + " Counter" +" "+ instance.getCounter());
  		}
  	});
     
     thread1.start();
     thread2.start();
     thread3.start();
     thread4.start();
	}
	
	private static synchronized SingletonThreadApp createInstance() {
		if (singletonThreadInstance == null) {
			singletonThreadInstance = new SingletonThreadApp();
			return singletonThreadInstance;
		}
		return singletonThreadInstance;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public int getCounter() {
		return counter;
	}
}
