package com.prateek.diffbetweenstaticclassandsingleton;

public class TestClass {

	public static void main(String[] args) {

		ParserSingleton.getInstance("XXX");
		//System.out.println(ps1.getName());
		ParserSingleton ps2 = ParserSingleton.getInstance("YYY");
		System.out.println(ps2.getName());
		
		ParserSingleton ps3 = ParserSingleton.getInstance("ZZZ");
		System.out.println(ps3.getName());
		
		
		ParserSingletonEarlyLoading psel1 = ParserSingletonEarlyLoading.getInstance();
		ParserSingletonEarlyLoading psel2 = ParserSingletonEarlyLoading.getInstance();
		
		if (psel1 == psel2) {
			System.out.println("Both are same instances");
		}
		
		ParserENUM pe1 = ParserENUM.INSTANCE;
		ParserENUM pe2 = ParserENUM.INSTANCE;
		
		if (pe1 == pe2) {
			System.out.println("Both are same instances");
			pe1.parseInput("xxx");
			pe2.parseInput("yyy");
		}
		
	}

}
