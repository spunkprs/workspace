package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

/*Responsible for finding the answers for every asked query.If the asked Roman text does not abide the rules or the query is regarding any unmapped element it will be throwing exception, 
 * if any unmapped word comes into picture exception will be thrown along with writing message to file, if everything goes fine 
 * calculated output would be written to file.
 * */

public class FileProcessorSectionThree extends FileProcessor {
	
	private static final String SPACE = " ";
	private static final String HOW_MUCH = "how" + SPACE +"much";
	private static final String HOW_MANY = "how" + SPACE +"many";
	private static final String CREDITS = "Credits";
	private static final String IS = "is";
	private static final String UNMAPPED_WORD_MESSAGE = "I have no idea what you are talking about";
	
	protected static String output = "";
	
	private Writer writer;
	
	protected FileProcessorSectionThree() {
		super();
		writer = OutputWriter.getInstance();
	}

	@Override
	protected void parseAndProcess(final String line) {
		output = "";
		final Map<String, String> wordToRomanCharacterMap = this.getWordToRomanCharacterMap();
		final Map<String, Pair<Integer, Integer>> elementToEvaluationMap = this.getElementToEvaluationMap();
		
		if (line.contains(HOW_MUCH)) {
			final String replacableString = HOW_MUCH + SPACE + IS + SPACE;
			final String result = parseAndCompute(fetchWordsAndProcessThemForCompution(line, wordToRomanCharacterMap, replacableString));
			output += SPACE + IS + SPACE + result;
			writer.write(output);
		} else if (line.contains(HOW_MANY)) {
			final String elementName = fetchElement(line, elementToEvaluationMap);
			final String query = line.replace(elementName, "");
			final String replacableString = HOW_MANY + SPACE + CREDITS + SPACE + IS + SPACE;
			final String result = parseAndCompute(fetchWordsAndProcessThemForCompution(query, wordToRomanCharacterMap, replacableString));
			final double calculatedCredits = creditsCalculation(elementName, Integer.parseInt(result), elementToEvaluationMap);
			output += SPACE + elementName + SPACE + IS + SPACE + Double.valueOf(calculatedCredits) + SPACE + CREDITS;
			writer.write(output);
		}
	}
	
	private double creditsCalculation(final String elementName, final int askedQuantity, final Map<String, Pair<Integer, Integer>> elementToEvaluationMap) {
		final Pair<Integer, Integer> quantityToWorth = elementToEvaluationMap.get(elementName);
		return (quantityToWorth.getRight().doubleValue() / quantityToWorth.getLeft().doubleValue()) * askedQuantity;
	}

	private String fetchElement(final String line, final Map<String, Pair<Integer, Integer>> elementToEvaluationMap) {
		for (String elementName : elementToEvaluationMap.keySet()) {
			if (line.contains(elementName)) {
				return elementName;
			}
		}
		throw new RuntimeException("Credits can not be computed for Unmapped element");
	}

	private String parseAndCompute(final String text) {
		try {
			ParseText.parse(text);
			return String.valueOf(Computor.computeUnits(text.toCharArray()));
		} catch(RuntimeException e) {
			throw e;
		}
	}
	
	private String fetchWordsAndProcessThemForCompution(final String line, final Map<String, String> wordToRomanCharacterMap, final String replacableString) {
		String queryWord = new String();
		String query = line.replace("?", "");
		
		query = query.replace(replacableString, "");
		output = query.trim();
		
		String words[] = query.split(SPACE);
		
		for (String word : words) {
			if (word.length() >=1 ) {
				word = word.replace(" ", "");
				String ch = wordToRomanCharacterMap.get(word);
				if (null != ch) {
					queryWord += ch;
				} else {
					writer.write(UNMAPPED_WORD_MESSAGE);
					throw new RuntimeException("Not a valid query.Word is not present in map");
				}
			}
		}
		return queryWord;
	}
	
}
