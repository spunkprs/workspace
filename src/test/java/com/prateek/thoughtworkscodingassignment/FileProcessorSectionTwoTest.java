package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

public class FileProcessorSectionTwoTest {
	
	private FileProcessor processor;
	private Map<String, String> wordToRomanCharacterMap;
	private Map<String, Pair<Integer, Integer>> elementToEvaluationMap;
	
	private static final String GOLD = "Gold";
	private static final String SILVER = "Silver";
	private static final String PLATINUM = "Platinum";
	
	@Before
	public void setUp() {
		processor = new FileProcessorSectionTwo();
		wordToRomanCharacterMap = processor.getWordToRomanCharacterMap();
		
		wordToRomanCharacterMap.put("glob", "I");
		wordToRomanCharacterMap.put("prok", "V");
		wordToRomanCharacterMap.put("pish", "X");
		wordToRomanCharacterMap.put("tegj", "L");
	}
	
	@After
	public void after() {
		elementToEvaluationMap.clear();
	}
	
	@Test
	public void shouldDecorateElementsToEvaluationMapCaseOne() {
		final String query = "glob glob Silver is 34 Credits";
		elementToEvaluationMap = processor.getElementToEvaluationMap();
		
		Assert.assertEquals(0, elementToEvaluationMap.size());
		processor.parseAndProcess(query);
		
		Assert.assertEquals(1, elementToEvaluationMap.size());
		Assert.assertTrue(elementToEvaluationMap.keySet().contains(SILVER));
		
		final Pair<Integer, Integer> expectedPair = new Pair<Integer, Integer>(2, 34);
		final Pair<Integer, Integer> actualPair = elementToEvaluationMap.get(SILVER);
		Assert.assertEquals(expectedPair, actualPair);
	}
	
	@Test
	public void shouldDecorateElementsToEvaluationMapCaseTwo() {
		final String query = "glob prok Gold is 57800 Credits";
		elementToEvaluationMap = processor.getElementToEvaluationMap();
		
		Assert.assertEquals(0, elementToEvaluationMap.size());
		processor.parseAndProcess(query);
		
		Assert.assertEquals(1, elementToEvaluationMap.size());
		Assert.assertTrue(elementToEvaluationMap.keySet().contains(GOLD));
		
		final Pair<Integer, Integer> expectedPair = new Pair<Integer, Integer>(4, 57800);
		final Pair<Integer, Integer> actualPair = elementToEvaluationMap.get(GOLD);
		Assert.assertEquals(expectedPair, actualPair);
	}
	
	@Test
	public void shouldDecorateElementsToEvaluationMapCaseThree() {
		final String query = "pish pish Platinum is 3910 Credits";
		elementToEvaluationMap = processor.getElementToEvaluationMap();
		
		Assert.assertEquals(0, elementToEvaluationMap.size());
		processor.parseAndProcess(query);
		
		Assert.assertEquals(1, elementToEvaluationMap.size());
		Assert.assertTrue(elementToEvaluationMap.keySet().contains(PLATINUM));
		
		final Pair<Integer, Integer> expectedPair = new Pair<Integer, Integer>(20, 3910);
		final Pair<Integer, Integer> actualPair = elementToEvaluationMap.get(PLATINUM);
		Assert.assertEquals(expectedPair, actualPair);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionWhenNonMappedWordIsPresentInTheInputQuery() {
		final String query = "pish trap Platinum is 3910 Credits";
		elementToEvaluationMap = processor.getElementToEvaluationMap();
		
		Assert.assertEquals(0, elementToEvaluationMap.size());
		processor.parseAndProcess(query);
	}
}
