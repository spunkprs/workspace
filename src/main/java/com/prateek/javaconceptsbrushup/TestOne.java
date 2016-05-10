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
     String s11 = "ABC" + s2;
     
     Integer s9 = null;
     String s10 = s9 + "llala";
     System.out.println(s9);
     System.out.println(s10);
     
     String s12 = "XYZ";
     String s13 = "India";
     String s14 = s12 + s13;
     String s15 = "XYZIndia";
     
     StringBuffer sb = new StringBuffer("a");
     sb.append("12345678912345678");
     System.out.println(sb.length());
     System.out.println(sb.capacity());
     
    
     
     checkForEquality(s3, s4);
     checkForEquality(s4, s6);
     checkForEquality(s4, s7);
     checkForEquality(s4, s8);
     checkForEquality(s4, s11);
     checkForEquality(s14, s15);
     System.out.println(s14 == s15);
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
