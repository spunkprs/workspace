package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/*Responsible for finding the answers for every asked query by reading input from file.If the asked Roman text does not abide the rules or the query is regarding any element that is not 
 * already mapped  it will be writing 'Invalid Query' in those cases to the Output file, unmapped element could also be present in this section it will be writing 'Invalid query' in that case as well, 
 * will be writing the calculated output otherwise.
 * */

public class ProcessQueries {
	
	private static final String HOW_MUCH = "how" + " " +"much";
	private static final String HOW_MANY = "how" + " " +"many";
	private static final String CREDITS = "Credits";
	private String element = null;
	private Writer writer;
	
	public void processQueriesAndCompute(final BufferedReader br, final String currentLine, final Map<String, Pair<Integer, Integer>> elementToItsWorthMap, final Map<String, Character> wordToRomanCharacterMap) {
		String line = currentLine;
		injectDependencies();
		while (null != line) {
			try {
				if (line.contains(HOW_MUCH) && !line.contains(CREDITS)) {
					writer.write(parseAndCompute(fetchWordsAndProcessThemForCompution(line, wordToRomanCharacterMap)));
					line = br.readLine();
				} else if (line.contains(HOW_MANY + " " + CREDITS)) {
					checkForValidityOfElementPresent(line);
					final String quantity = parseAndCompute(fetchWordsAndProcessThemForCompution(line, wordToRomanCharacterMap));
					writer.write(calculateCostOfQuantityOfAnElement(quantity, elementToItsWorthMap.get(element)));
					line = br.readLine();
				}
			} catch(RuntimeException e) {
				try {
					final RuntimeException exception = new RuntimeException("Invalid Query", e);
					writer.write(exception.getMessage());
					line = br.readLine();
				} catch(IOException exception) {
					
				}
			}
			catch(IOException e) {
			}
		}
		writer.closeStream();
	}

	private void injectDependencies() {
		writer = new Writer();
	}

	private String calculateCostOfQuantityOfAnElement(final String quantity, final Pair<Integer, Integer> pair) {
		final Double presentQuantity = new Double(pair.getLeft());
		final Double costOfPresentQuantityOfElement = new Double(pair.getRight());
		final Double costOfAskedQuantity = (costOfPresentQuantityOfElement / presentQuantity) * Integer.parseInt(quantity);
		return String.valueOf(costOfAskedQuantity);
	}

	private String parseAndCompute(final String text) {
		try {
			ParseText.parse(text);
			return String.valueOf(Computor.computeUnits(text.toCharArray()));
		} catch(RuntimeException e) {
			throw e;
		}
	}

	private void checkForValidityOfElementPresent(final String query) {
		for (Element e : Element.values()) {
			if (query.contains(e.getNameOfElement())) {
				element = e.getNameOfElement();
				break;
			}
		}
		
		if (null == element) {
			throw new RuntimeException("Not a valid element");
		}
	}

	private String fetchWordsAndProcessThemForCompution(final String line, final Map<String, Character> wordToRomanCharacterMap) {
		String queryWord = new String();
		String query = line.replace("?", "");
		if (line.contains(HOW_MUCH + " " + "is")) {
			query = query.replace(HOW_MUCH + " " + "is", "");
		} else if (line.contains(HOW_MUCH + " ")) {
			query = query.replace(HOW_MUCH + " ", "");
		} else if (line.contains(HOW_MANY + " " + CREDITS + " " + "is")) {
			query = query.replace(HOW_MANY + " " + CREDITS + " " + "is" + " ", "");
			query = query.replace(element, "");
		}
		
		String words[] = query.split(" ");
		
		for (String word : words) {
			if (word.length() >=1 ) {
				word = word.replace(" ", "");
				Character ch = wordToRomanCharacterMap.get(word);
				if (null != ch) {
					queryWord += ch.toString();
				} else {
					throw new RuntimeException("Not a valid query.Word is not present in map");
				}
			}
		}
		return queryWord;
	}
}
