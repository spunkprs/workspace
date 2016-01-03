package com.prateek.diffbetweenstaticclassandsingleton;

public class ParserSingletonEarlyLoading {
	
	private static ParserSingletonEarlyLoading parserSingletonEarlyLoading = new ParserSingletonEarlyLoading();
	
	public static ParserSingletonEarlyLoading getInstance() {
		return parserSingletonEarlyLoading;
	}
}
