package com.prateek.enumconceptsbrushup;


public class EnumTest {

	public static void main(String[] args) {
	
		String url = "www.google.com";
		System.out.println("Printing url's for SearchEngines");
		printUrls();
		SearchEngines searchEngine = SearchEngines.getByUrl(url);
		System.out.println(searchEngine);
		System.out.println("URL FOR SEARCH ENGINE" +" "+ searchEngine.getUrl());
		
		url = "abcd.com";
		searchEngine = SearchEngines.getByUrl(url);
		System.out.println(searchEngine);
		System.out.println("URL FOR SEARCH ENGINE" +" "+ searchEngine.getUrl());
		System.out.println(getEnumForUrl("GOOGLE").getUrl());
	}

	private static SearchEngines getEnumForUrl(final String url) {
		return SearchEngines.valueOf(url);
	}

	private static void printUrls() {
		for (SearchEngines searchEngine : SearchEngines.values()) {
			System.out.println(searchEngine.getUrl());
		}
	}
}
