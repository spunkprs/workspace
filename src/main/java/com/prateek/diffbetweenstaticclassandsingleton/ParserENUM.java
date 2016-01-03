package com.prateek.diffbetweenstaticclassandsingleton;

/*
 * ENUM is the perfect example of singleton design pattern that follows early loading.
 * */

public enum ParserENUM {
INSTANCE;

public void parseInput(final String input) {
	System.out.println("Parsing input"+" "+ input);
}
}
