package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*Execution starts from here.
 * It reads input statements from file that are basically mapping of words to roman characters.
 * Made the assumption here that no invalid statement is provided here or rather the format of input statement provided is same as provided in the question. 
 * */

public class Processor {

	private Map<String, Character> map = new HashMap<String, Character>();
	private List<String> romanCharacters = prepareRomanCharacterList();
	private static final String space = " ";
	private String currentLine = null;
	private ElementsEvaluation elementsEvaluation;
	private ProcessQueries processQueries;
	private String processedRomanCharacter = null;
	private CurrentLineDecorator decorator;
	
	public void process() {
		injectDependencies();
			FileReader fileReader;
			try {
				fileReader = new FileReader(Files.INPUT.getFileName());
				BufferedReader br = new BufferedReader(fileReader);
				readAndPrepareMap(br);
				processQueriesAndCompute(br, elementsEvaluation.evaluateElements(br, currentLine, map, decorator));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

	private void injectDependencies() {
		elementsEvaluation = new ElementsEvaluation();
		processQueries = new ProcessQueries();
		decorator = new CurrentLineDecorator();
	}

	private void processQueriesAndCompute(final BufferedReader br, final Map<String, Pair<Integer, Integer>> elementToItsWorthMap) {
		processQueries.processQueriesAndCompute(br, decorator.getCurrentLine(), elementToItsWorthMap, map);
	}

	private List<String> prepareRomanCharacterList() {
		final List<String> l = new ArrayList<String>();
		for (RomanCharacters rc : RomanCharacters.values()) {
			l.add(rc.getNameOfCharacter());
		}
		return l;
	}

	/*
	 * Made the assumption here that the input for words to roman characters is valid i.e every such input line will contain any of the roman character. 
	 * */
	private void readAndPrepareMap(final BufferedReader br) {
		try {
			String line = br.readLine();
			while (null != line) {
				currentLine = line;
				if (checkForPresenceOfRomanCharacters(line)) {
					prepareMap(line);
					line = br.readLine();
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean checkForPresenceOfRomanCharacters(final String line) {
		String prefix = "is" + space;
		processedRomanCharacter = null;
		for (String romanCharacter : romanCharacters) {
			prefix = prefix + romanCharacter;
			if (line.contains(prefix)) {
				processedRomanCharacter = romanCharacter;
				return true;
			} else {
				prefix = "is" + space;
			}
		}
		return false;
	}

	private void prepareMap(final String line) {
		final String s[] = line.split(" ");
		final String word = s[0].replace(" ", "");
		map.put(word, processedRomanCharacter.toCharArray()[0]);
	}
}
