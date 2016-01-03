package com.prateek.basicthreadsynchronization;

import java.util.Scanner;

public class App {

	private static Boolean running = true;
	
	public static void main(String[] args) {
		
		Processor p1 = new Processor(running, "Processor One");
		p1.start();
		
		Processor p2 = new Processor(running, "Processor Two");
		p2.start();
		
		
		System.out.println("Press enter to stop processes");
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		p1.shutdown();
		//p2.shutdown();
	}

}
