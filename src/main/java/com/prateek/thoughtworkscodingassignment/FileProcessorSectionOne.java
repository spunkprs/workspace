package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

/*Creates mapping for word to Roman character.
 * */

public class FileProcessorSectionOne extends FileProcessor {

	private static final String IS = "is";
	private static final String SPACE = " ";
	
	protected FileProcessorSectionOne() {
		super();
	}
	
	protected void parseAndProcess(final String line) {
		prepareMap(line);
	}

	private void prepareMap(final String line) {
		final Map<String, String> wordToRomanCharacterMap = this.getWordToRomanCharacterMap();
		final String s[] = line.split(SPACE + IS + SPACE);
		final String word = s[0].trim();
		final String romanCharacter = s[1].trim();
		wordToRomanCharacterMap.put(word, romanCharacter);
	}
}
