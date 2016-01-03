package com.prateek.stringimmutability;

public class Stringimmutability {
	
	public static void main(String[] args) {

		String str = new String("ABC").intern();
		String s = "ABC";
		String st = "ABCD";
		String st1 = s + "D";
		String st2 = "AB" + "CD";
		String st3 = "A" + "B" + "C" + "D";
		
		checkMappingToSameAddress(str, s);
		checkMappingToSameAddress(st, st1);
		checkMappingToSameAddress(st, st2);
		checkMappingToSameAddress(st, st3);
	}

	private static void checkMappingToSameAddress(final String s1, final String s2) {
		if(s1 == s2) {
			System.out.println("Mapped to same address");
		} else {
			System.out.println("Not mapped to same address"); 
		}
	}
}
