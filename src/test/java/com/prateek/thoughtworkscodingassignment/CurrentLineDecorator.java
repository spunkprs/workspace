package com.prateek.thoughtworkscodingassignment;

public class CurrentLineDecorator {
	
	private String currentLine;
	
	public void decorate(final String line) {
		this.currentLine = line;
	}
	
	public String getCurrentLine() {
		return currentLine;
	}
}
