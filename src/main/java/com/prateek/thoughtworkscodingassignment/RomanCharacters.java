package com.prateek.thoughtworkscodingassignment;

import java.util.HashMap;
import java.util.Map;

/*Enum of Roman Characters with their ranks and values.*/

public enum RomanCharacters {
	I("I", 1, 1),
	V("V", 2, 5),
	X("X", 3, 10),
	L("L", 4, 50), 
	C("C", 5, 100), 
	D("D", 6, 500),
	M("M", 7, 1000),
	INVALID("", -1, -1);
	
	private String nameOfCharacter;
	private int rankOfRomanCharacter;
	private int valueOfRomanCharacter;
	private static Map<String, Integer> characterToRankMap = prepareCharacterToRankMap();
	private static Map<String, Integer> characterToValueMap = prepareCharacterToValueMap(); 
	
	private RomanCharacters(final String nameOfCharacter, final int rankOfRomanCharacter, final int valueOfRomanCharacter) {
		this.nameOfCharacter = nameOfCharacter;
		this.rankOfRomanCharacter = rankOfRomanCharacter;
		this.valueOfRomanCharacter = valueOfRomanCharacter;
	}

	private static Map<String, Integer> prepareCharacterToValueMap() {
		final Map<String, Integer> m = new HashMap<String, Integer>();
		for (RomanCharacters r : values()) {
			m.put(r.getNameOfCharacter(), r.getValueOfRomanCharacter());
		}
		return m;
	}

	private static Map<String, Integer> prepareCharacterToRankMap() {
		final Map<String, Integer> m = new HashMap<String, Integer>();
		for (RomanCharacters r : values()) {
			m.put(r.getNameOfCharacter(), r.getRankOfRomanCharacter());
		}
		return m;
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
	
	public static Map<String, Integer> getCharacterToRankMap() {
		return characterToRankMap;
	}

	public static Map<String, Integer> getCharacterToValueMap() {
		return characterToValueMap;
	}
	
}
