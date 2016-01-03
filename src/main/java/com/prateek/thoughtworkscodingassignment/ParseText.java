package com.prateek.thoughtworkscodingassignment;

/*Wrapper over Parser throws exception if the asked roman text does not abide with the defined rules.*/

public class ParseText {

	private Parser parser;
	public void parse(final String text) {
		parser = new Parser();
		if (!parser.parseText(text)) {
			throw new RuntimeException("Not a valid text as per the rules");
		}
	}
}
