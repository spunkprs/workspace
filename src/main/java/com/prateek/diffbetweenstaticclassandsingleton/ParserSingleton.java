package com.prateek.diffbetweenstaticclassandsingleton;

public class ParserSingleton {

	private static ParserSingleton parserSingleton;
	private String name;
	
	public static synchronized ParserSingleton getInstance(final String name) {
		if (parserSingleton == null) {
			parserSingleton = new ParserSingleton(name);
			return parserSingleton;
		} 
		return parserSingleton;
	}
	
	public ParserSingleton getParserSingleton() {
		return parserSingleton;
	}

	public String getName() {
		return name;
	}
	
	private ParserSingleton(final String name) {
		this.name = name;
	}
}
