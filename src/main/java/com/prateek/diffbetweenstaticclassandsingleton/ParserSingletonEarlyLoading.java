package com.prateek.diffbetweenstaticclassandsingleton;

public class ParserSingletonEarlyLoading {
	
	private static final ParserSingletonEarlyLoading parserSingletonEarlyLoading = new ParserSingletonEarlyLoading();
	
	private ParserSingletonEarlyLoading() {
		System.out.println("Early Loading");
	}
	
	public static ParserSingletonEarlyLoading getInstance() {
		return parserSingletonEarlyLoading;
	}
}
