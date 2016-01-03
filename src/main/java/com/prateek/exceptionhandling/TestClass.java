package com.prateek.exceptionhandling;

public class TestClass {

	private static int a = 0;
	private static int b = 0;
	
	public static void main(String[] args) {

		//System.out.println(execute1());
		//execute();
		System.out.println(execute2());
	}

	private static void execute() {
		try{
			System.out.println("Prateek");
			throw new Exception();
		} catch(Exception e) {
			System.out.println("HELLO");
			return;
		}
		
		finally {
			System.out.println("CHUMME");
		}
	}
	
	private static int execute1() {
		try{
			System.out.println("Prateek");
			return a/b;
		} catch(Exception e) {
			System.out.println("HELLO");
			return 0;
		}
		
		finally {
			System.out.println("CHUMME");
			return 1;
		}
	}
	
	
	/*
	 * If exception is raised inside catch block and if finally block is there with throwing run time exception of any form then that exception would override the exception that is being 
	 * thrown inside the catch block.
	 * */
	private static int execute2() {
		try{
			System.out.println("Prateek");
			return a/b;
		} catch(Exception e) {
			System.out.println("HELLO");
			throw new Exception("Exception raised inside catch block");
			//return 0;
		}
		
		finally {
			System.out.println("CHUMME");
			throw new RuntimeException("Exception raised inside finally block");
			//return 1;
		}
	}
	
	
	/*
	 * If exception is raised inside catch block and if finally block is there with throwing no run time exception of any form then no exception would be thrown at the end.
	 * */
	private static int execute3() {
		try{
			System.out.println("Prateek");
			return a/b;
		} catch(Exception e) {
			System.out.println("HELLO");
			throw new Exception("Exception raised inside catch block");
			//return 0;
		}
		
		finally {
			System.out.println("CHUMME");
			return 1;
		}
	}

}
