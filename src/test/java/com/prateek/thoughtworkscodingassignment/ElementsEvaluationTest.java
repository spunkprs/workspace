package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ElementsEvaluationTest {

	private ElementsEvaluation unit;
	private BufferedReader br;
	private Map<String, Character> map;
	private CurrentLineDecorator decorator;
	
	@Before
	public void setUp() {
		try {
			map = prepareMap();
			unit = new ElementsEvaluation();
			br = new BufferedReader(new FileReader(new File("EMPTYFILE.txt")));
			decorator = new CurrentLineDecorator();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Map<String, Character> prepareMap() {
		final Map<String, Character> m = new HashMap<String, Character>();
		m.put("glob", 'I');
		m.put("prok", 'V');
		m.put("pish", 'X');
		m.put("tegj", 'L');
		m.put("neft", 'C');
		m.put("short", 'D');
		m.put("long", 'M');
		return m;
	}
	
	@Test
	public void shouldBeAbleToReturnElementToItsEvaluationMapForSilver() {
		//Set Up
		final String inputLine = "glob glob Silver is 34 Credits";
		final Map<String, Pair<Integer, Integer>> expectedMap = new HashMap<String, Pair<Integer,Integer>>();
		final Pair<Integer, Integer> p = new Pair<Integer, Integer>(2, 34);
		expectedMap.put(Element.SILVER.getNameOfElement(), p);
		
		//Execute
		final Map<String, Pair<Integer, Integer>> actualMap = unit.evaluateElements(br, inputLine, map, decorator);
		
		//Verify
		Assert.assertEquals(expectedMap.size(), actualMap.size());
		verify(expectedMap, actualMap);
	}

	@Test
	public void shouldBeAbleToReturnElementToItsEvaluationMapForGold() {
		//Set Up
		final String inputLine = "glob prok Gold is 57800 Credits";
		final Map<String, Pair<Integer, Integer>> expectedMap = new HashMap<String, Pair<Integer,Integer>>();
		final Pair<Integer, Integer> p = new Pair<Integer, Integer>(4, 57800);
		expectedMap.put(Element.GOLD.getNameOfElement(), p);
		
		//Execute
		final Map<String, Pair<Integer, Integer>> actualMap = unit.evaluateElements(br, inputLine, map, decorator);
		
		//Verify
		Assert.assertEquals(expectedMap.size(), actualMap.size());
		verify(expectedMap, actualMap);
	}
	
	@Test
	public void shouldBeAbleToReturnElementToItsEvaluationMapForIron() {
		//Set Up
		final String inputLine = "pish pish Iron is 3910 Credits";
		final Map<String, Pair<Integer, Integer>> expectedMap = new HashMap<String, Pair<Integer,Integer>>();
		final Pair<Integer, Integer> p = new Pair<Integer, Integer>(20, 3910);
		expectedMap.put(Element.IRON.getNameOfElement(), p);
		
		//Execute
		final Map<String, Pair<Integer, Integer>> actualMap = unit.evaluateElements(br, inputLine, map, decorator);
		
		//Verify
		Assert.assertEquals(expectedMap.size(), actualMap.size());
		verify(expectedMap, actualMap);
	}
	
	@Test
	public void shouldNotBeAbleToReturnElementToItsEvaluationMapForPlatinum() {
		//Set Up
		final String inputLine = "pish pish Platinum is 3910 Credits";
		final Map<String, Pair<Integer, Integer>> expectedMap = new HashMap<String, Pair<Integer,Integer>>();
		
		//Execute
		final Map<String, Pair<Integer, Integer>> actualMap = unit.evaluateElements(br, inputLine, map, decorator);
		
		//Verify
		Assert.assertEquals(expectedMap.size(), actualMap.size());
		verify(expectedMap, actualMap);
	}
	
	@Test
	public void shouldBeAbleToReturnElementToItsEvaluationMapWhenTheQueryContainsKeywordHow() {
		//Set Up
		final String inputLine = "how many Credits is glob prok Silver ?";
		final Map<String, Pair<Integer, Integer>> expectedMap = new HashMap<String, Pair<Integer,Integer>>();
		
		//Execute
		final Map<String, Pair<Integer, Integer>> actualMap = unit.evaluateElements(br, inputLine, map, decorator);
		
		//Verify
		Assert.assertEquals(expectedMap.size(), actualMap.size());
		verify(expectedMap, actualMap);
	}
	
	private void verify(final Map<String, Pair<Integer, Integer>> expectedMap, final Map<String, Pair<Integer, Integer>> actualMap) {
		final Set<String> expectedSet = expectedMap.keySet();
		final Set<String> actualSet = actualMap.keySet();
		
		for (String elementName : expectedSet) {
			Assert.assertTrue(actualSet.contains(elementName));
			Assert.assertEquals(expectedMap.get(elementName).getLeft(), actualMap.get(elementName).getLeft());
			Assert.assertEquals(expectedMap.get(elementName).getRight(), actualMap.get(elementName).getRight());
		}
	}
}
