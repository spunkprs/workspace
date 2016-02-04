package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

public class FileProcessorSectionThreeTest {

	private FileProcessor fileProcessor;
	private Map<String, String> wordToRomanCharacterMap;
	private Map<String, Pair<Integer, Integer>> elementToEvaluationMap;
	
	@Before
	public void setUp() {
		fileProcessor = new FileProcessorSectionThree(OutputWriter.getInstance());
		prepareWordToCharacterMap();
		prepareElementToEvaluationMap();
	}
	
	@After
	public void after() {
		clearCache();
	}
	
	private void clearCache() {
		wordToRomanCharacterMap.clear();
		elementToEvaluationMap.clear();
	}

	private void prepareElementToEvaluationMap() {
		elementToEvaluationMap = fileProcessor.getElementToEvaluationMap();
		elementToEvaluationMap.put("Silver", new Pair<Integer, Integer>(2, 34));
		elementToEvaluationMap.put("Gold", new Pair<Integer, Integer>(4, 57800));
		elementToEvaluationMap.put("Platinum", new Pair<Integer, Integer>(20, 3910));
		elementToEvaluationMap.put("Iron", new Pair<Integer, Integer>(20, 3910));
	}

	private void prepareWordToCharacterMap() {
		wordToRomanCharacterMap = fileProcessor.getWordToRomanCharacterMap();
		wordToRomanCharacterMap.put("glob", "I");
		wordToRomanCharacterMap.put("prok", "V");
		wordToRomanCharacterMap.put("pish", "X");
		wordToRomanCharacterMap.put("tegj", "L");
	}
	
	@Test
	public void shouldParseAndProcessCaseOne() {
		final String query = "how much is pish tegj glob glob ?";
		final String expectedOutput = "pish tegj glob glob is 42";
		
		fileProcessor.parseAndProcess(query);
		Assert.assertTrue(expectedOutput.equals(FileProcessorSectionThree.output));
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenMappedWordsDoesNotAbideWithTheRules() {
		final String query = "how much is glob tegj ?";
		
		fileProcessor.parseAndProcess(query);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenUnMappedWordComesAcrossCaseOne() {
		final String query = "how much is pish tegj glob plob ?";
		fileProcessor.parseAndProcess(query);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenUnMappedWordComesAcrossCaseTwo() {
		final String query = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
		fileProcessor.parseAndProcess(query);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenUnmappedWordComesAlongWithMappedElement() {
		final String query = "how many Credits is clob prok Silver ?";
		fileProcessor.parseAndProcess(query);
	}
	
	@Test
	public void shouldParseAndProcessQueryRelatedToCalulationOfCreditsForSilver() {
		final String query = "how many Credits is glob prok Silver ?";
		final String expectedOutput = "glob prok Silver is 68.0 Credits";
		
		fileProcessor.parseAndProcess(query);
		Assert.assertTrue(expectedOutput.equals(FileProcessorSectionThree.output));
	}
	
	@Test
	public void shouldParseAndProcessQueryRelatedToCalulationOfCreditsForGold() {
		final String query = "how many Credits is glob prok Gold ?";
		final String expectedOutput = "glob prok Gold is 57800.0 Credits";
		
		fileProcessor.parseAndProcess(query);
		Assert.assertTrue(expectedOutput.equals(FileProcessorSectionThree.output));
	}
	
	@Test
	public void shouldParseAndProcessQueryRelatedToCalulationOfCreditsForIron() {
		final String query = "how many Credits is glob prok Iron ?";
		final String expectedOutput = "glob prok Iron is 782.0 Credits";
		
		fileProcessor.parseAndProcess(query);
		Assert.assertTrue(expectedOutput.equals(FileProcessorSectionThree.output));
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenAnUnMappedElementIsPresentInTheQuery() {
		final String query = "how many Credits is glob prok Copper ?";
		
		fileProcessor.parseAndProcess(query);
	}
	
}
