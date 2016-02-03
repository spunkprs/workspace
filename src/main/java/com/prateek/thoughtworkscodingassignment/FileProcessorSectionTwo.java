package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

/*Creates mapping of element to its worth.
 * */
public class FileProcessorSectionTwo extends FileProcessor {

	private static final String CREDITS = "Credits";
	private static final String HOW = "how";
	
	protected FileProcessorSectionTwo() {
		super();
	}
	
	protected void parseAndProcess(final String line) {
		if (!line.contains(HOW) && line.contains(CREDITS)) {
			final String elementName = fetchElement(line);
			final Map<String, String> wordToRomanCharacterMap = this.getWordToRomanCharacterMap();
			final Map<String, Pair<Integer, Integer>> elementToEvaluationMap = this.getElementToEvaluationMap();
			
			final int quantity = getQuantity(line, wordToRomanCharacterMap, elementName);
			prepareMapOfElementToItsCostAsPerUnits(line, quantity, elementName, elementToEvaluationMap);
		}
	}
	
	private void prepareMapOfElementToItsCostAsPerUnits(final String line, final int quantity, final String elementName, final Map<String, Pair<Integer, Integer>> elementToEvaluationMap) {
		elementToEvaluationMap.put(elementName, new Pair<Integer, Integer>(quantity, fetchCostOfUnitsOfElement(line, elementName)));
	}
	
	private static int fetchCostOfUnitsOfElement(final String line, final String elementName) {
		String str[] = line.split(elementName);
		final String costStatement = str[1];
		return Integer.parseInt(costStatement.replace("is", "").replace(CREDITS, "").replace(" ", ""));
	}

	private String fetchElement(final String line) {
		String words[] = line.split(CREDITS);
		words = words[0].split(" ");
		return words[words.length - 3]; 
	}
	
	private int getQuantity(final String line, final Map<String, String> wordToRomanCharacterMap, final String elementName) {
		String romanWord = new String();
		String str[] = line.split(elementName);
		final String quantity = str[0];
		final String arr[] = quantity.split(" ");
		for (String st : arr) {
			String ct = wordToRomanCharacterMap.get(st);
			if (null != ct) {
				romanWord += ct;
			} else {
				throw new RuntimeException("Word not mapped to any of roman character");
			}
		}
		return Computor.computeUnits(romanWord.toCharArray());
	}
}
