package com.prateek.thoughtworkscodingassignment;

import java.util.HashMap;
import java.util.Map;


/*
 * Contains word to roman character map &&
 * element to its worth map
 * */
public abstract class FileProcessor {

	private static Map<String, String> wordToRomanCharacterMap = new HashMap<String, String>();
	private static Map<String, Pair<Integer, Integer>> elementToEvaluationMap = new HashMap<String, Pair<Integer,Integer>>();
	
	protected abstract void parseAndProcess(final String line);
	
	protected Map<String, String> getWordToRomanCharacterMap() {
		return wordToRomanCharacterMap;
	}

	protected Map<String, Pair<Integer, Integer>> getElementToEvaluationMap() {
		return elementToEvaluationMap;
	}
}
