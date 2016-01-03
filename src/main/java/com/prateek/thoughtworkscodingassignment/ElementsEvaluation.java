package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * This section evaluates the cost of each element by reading it from input file.
 * Made the assumption here that the order of words that finally maps to Roman character abide with the rules provided.
 * */

public class ElementsEvaluation {
	
	private static final String HOW = "how";
	private static final String CREDITS = "Credits";
	private Computor computor;
	private String elementName;
	private Map<String, Pair<Integer, Integer>> map = new HashMap<String, Pair<Integer, Integer>>();

	public Map<String, Pair<Integer, Integer>> evaluateElements(final BufferedReader br, String line, final Map<String, Character> wordToRomanCharacterMap, final CurrentLineDecorator decorator) {
		try {
			computor = new Computor();
			while (null != line) {
				if (doesContainAnyOfElements(line)) {
					if ((!line.contains(HOW) && line.contains(CREDITS))) {
						prepareMapOfElementToItsCostAsPerUnits(line, getQuantity(line, wordToRomanCharacterMap));
						line = br.readLine();
					} else {
						decorator.decorate(line);
						break;
					}
				} else {
					decorator.decorate(line);
					break;
				}
			}
		} catch(IOException e) {
			
		}
		return map;
	}
	
	private int getQuantity(final String line, final Map<String, Character> wordToRomanCharacterMap) {
		String romanWord = new String();
		String str[] = line.split(elementName);
		final String quantity = str[0];
		final String arr[] = quantity.split(" ");
		for (String st : arr) {
			Character ct = wordToRomanCharacterMap.get(st);
			if (null != ct) {
				romanWord += ct.toString();
			} else {
				throw new RuntimeException("Word not mapped to any of roman character");
			}
		}
		return computor.computeUnits(romanWord.toCharArray());
	}

	private void prepareMapOfElementToItsCostAsPerUnits(final String line, final int quantity) {
		map.put(elementName, new Pair<Integer, Integer>(quantity, fetchCostOfUnitsOfElement(line)));
	}

	private int fetchCostOfUnitsOfElement(final String line) {
		String str[] = line.split(elementName);
		final String costStatement = str[1];
		return Integer.parseInt(costStatement.replace("is", "").replace(CREDITS, "").replace(" ", ""));
	}

	/*Have made the assumption here that the elements that are mapped to its credit shall be present in enum Element or can say no invalid element would be present in this section.
	 * */
	
	private boolean doesContainAnyOfElements(final String line) {
		for (Element element : Element.values()) {
			if (line.contains(element.getNameOfElement())) {
				elementName = element.getNameOfElement();
				return true;
			}
		}
		return false;
	}
}
