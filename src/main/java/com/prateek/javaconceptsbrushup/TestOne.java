package com.prateek.javaconceptsbrushup;

public class TestOne {

	public static void main(String[] args) {
     String s1 = "ABC";
     String s2 = "DEF";
     String s3 = s1 + getResult();
     s3 = s3.intern();
     
     String s4 = "ABCDEF";
     
     String s5 = new String("DEF");
     String s6 = s1 + s5;
     String s7 = s1 + s2;
     String s8 = "ABC" + "DEF";
     /*
     String s9 = null;
     String s10 = null + "llala";
     System.out.println(s9);
     */
     
     checkForEquality(s3, s4);
     checkForEquality(s4, s6);
     checkForEquality(s4, s7);
     checkForEquality(s4, s8);
	}
	
	private static String getResult() {
		return "DEF";
	}
	
	private static void checkForEquality(final String s1, final String s2) {
		 if (s1 == s2) {
	    	 System.out.println("Both pointing to same memory location");
	     } else {
	    	 System.out.println("Both pointing to different memory location");
	     }
	}
}
