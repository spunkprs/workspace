package com.prateek.diffbetweenstaticclassandsingleton;

/*
 * ENUM is the perfect example of singleton design pattern that follows lazy/eager(not sure) loading.
 * By default creation of Enum instance is thread safe but any other method on Enum is programmers responsibility.

Read more: http://javarevisited.blogspot.com/2012/07/why-enum-singleton-are-better-in-java.html#ixzz3zIrMccRY
 * */

public enum ParserENUM {
INSTANCE;
	
	private ParserENUM() {
		System.out.println("Singleton Instance through ENUM");
	}

public void parseInput(final String input) {
	System.out.println("Parsing input"+" "+ input);
}
}
