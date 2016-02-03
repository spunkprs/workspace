package com.prateek.thoughtworkscodingassignment;

import java.util.Map;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class FileProcessorSectionOneTest {
	
	private FileProcessor processor;
	private Map<String, String> map;
	
	@Before
	public void setUp() {
		processor = new FileProcessorSectionOne();
		map = processor.getWordToRomanCharacterMap();
	}
	
	@After
	public void after() {
		map.clear();
	}

	@Test
	public void shouldDecorateWordToRomanCharacterMapCaseOne() {
		final String query = "prok is M";
		Assert.assertEquals(0, map.size());
		
		processor.parseAndProcess(query);
		
		Assert.assertEquals(1, map.size());
		Assert.assertTrue(map.keySet().contains("prok"));
		Assert.assertEquals("M", map.get("prok"));
	}
	
	@Test
	public void shouldDecorateWordToRomanCharacterMapCaseTwo() {
		final String query = "glob is I";
		Assert.assertEquals(0, map.size());
		
		processor.parseAndProcess(query);
		
		Assert.assertEquals(1, map.size());
		Assert.assertTrue(map.keySet().contains("glob"));
		Assert.assertEquals("I", map.get("glob"));
	}
	
	@Test
	public void shouldDecorateWordToRomanCharacterMapCaseThree() {
		final String query = "pish is X";
		Assert.assertEquals(0, map.size());
		
		processor.parseAndProcess(query);
		
		Assert.assertEquals(1, map.size());
		Assert.assertTrue(map.keySet().contains("pish"));
		Assert.assertEquals("X", map.get("pish"));
	}
}
