package com.prateek.saplabs;

public class Test {

	public static void main(String[] args) {
	Thread tt1 = new Thread();
	System.out.println(tt1.getName());
	
	String str1 = new String("Ea");
	String str2 = new String("FB");
	System.out.println(str1.hashCode());
	System.out.println(str2.hashCode());
	}
}
