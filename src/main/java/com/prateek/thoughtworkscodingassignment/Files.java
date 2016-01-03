package com.prateek.thoughtworkscodingassignment;

/*Enum of the files used for reading and writing.*/

public enum Files {

	INPUT("InputFile.txt"),
	OUTPUT("GeneratedOutput.txt"), 
	EMPTY("EmptyFile.txt");
	
	private String fileName;
	
	private Files(final String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
}
