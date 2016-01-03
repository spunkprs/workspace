package com.prateek.thoughtworkscodingassignment;

/*Enum of Roman Characters with their ranks and values.*/

public enum RomanCharacters {
	I("I", 1, 1),
	V("V", 2, 5),
	X("X", 3, 10),
	L("L", 4, 50), 
	C("C", 5, 100), 
	D("D", 6, 500),
	M("M", 7, 1000);
	
	private String nameOfCharacter;
	private int rankOfRomanCharacter;
	private int valueOfRomanCharacter;
	
	private RomanCharacters(final String nameOfCharacter, final int rankOfRomanCharacter, final int valueOfRomanCharacter) {
		this.nameOfCharacter = nameOfCharacter;
		this.rankOfRomanCharacter = rankOfRomanCharacter;
		this.valueOfRomanCharacter = valueOfRomanCharacter;
	}

	public String getNameOfCharacter() {
		return nameOfCharacter;
	}

	public int getRankOfRomanCharacter() {
		return rankOfRomanCharacter;
	}

	public int getValueOfRomanCharacter() {
		return valueOfRomanCharacter;
	}
	
}
