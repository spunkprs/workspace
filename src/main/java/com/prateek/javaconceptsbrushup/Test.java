package com.prateek.javaconceptsbrushup;

public class Test {
	
	static {
		System.out.println("Inside static block");
		Object obj = new String("Prateek");
		String str = (String)obj;
		obj = (Object)str;
		str = (String)obj;
		System.out.println(str);
		Test t = new Test();
		Test.TestClass tc = t.new TestClass();
		System.out.println(tc.display());
	}

	public static void main(String[] args) throws Exception {
		/*
		try {
			System.out.println("Before exception is thrown");
			throw new Exception("Exception One");
		}catch(Exception e) {
				throw new Exception("Exception Two");
			}
			
		finally {
			//System.exit(0);
			System.out.println(1+2+3+"2");
			throw new Exception("Exception Three");
		}
		*/
		
		Test test = new Test();
		Test.TestClass tc = test.new TestClass();
		System.out.println(tc.display());
	}
	
	class TestClass {
		
		public String display() {
			try {
				System.out.println("Inside method display");
				throw new RuntimeException("try exception thrown");
			} catch(Exception e) {
				int array[] = new int [10];
				int b = array[110];
				return "Prateek";
			}
			
			finally {
				/*
				 * If no exception is thrown in finally block but the exception was thrown in the catch block then finally block will override it and if there is no exception is 
				 * thrown in finally block then code will end with no exceptions but if there are exceptions thrown in finally block as well then as written above the code will end 
				 * with throwing the exception that was thrown inside the finally block.
				 * */
				//int b = 20 / 0;
				return "Spunk";
			}
		}
	}

}
