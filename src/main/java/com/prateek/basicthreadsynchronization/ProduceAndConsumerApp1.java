package com.prateek.basicthreadsynchronization;

import org.apache.commons.lang.math.RandomUtils;

public class ProduceAndConsumerApp1 {
	private static Object lock = new Object();
	
	public static void main(String[] args) {
		
		final ProducerAndConsumerOne producerAndConsumer = new ProducerAndConsumerOne();
		
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				produce(producerAndConsumer);
			}
		});
		
       Thread thread2 = new Thread(new Runnable() {
			
			public void run() {
				consume(producerAndConsumer);
			}
		});
       
       thread1.start();
       thread2.start();
       
       try {
		thread1.join();
		thread2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	private static void produce(ProducerAndConsumerOne producerAndConsumer) {
		while(true) {
			synchronized (lock) {
				if(producerAndConsumer.getList().size() <= 10){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int number = RandomUtils.nextInt(10);
					producerAndConsumer.produce(number);
					System.out.println("Produced Number" +" "+ number);
					lock.notify();
				}else{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private static void consume(ProducerAndConsumerOne producerAndConsumer) {
		while(true) {
			synchronized (lock) {
				if(!producerAndConsumer.getList().isEmpty()){
					producerAndConsumer.consume();
					lock.notify();
				}else{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
