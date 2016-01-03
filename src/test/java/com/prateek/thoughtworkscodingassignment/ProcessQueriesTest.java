package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/*More than a unit test as it verifies the output after reading from output file.*/

public class ProcessQueriesTest {
	
	private ProcessQueries unit;
	private BufferedReader br;
	private Map<String, Character> wordToRomanCharacterMap;
	private Map<String, Pair<Integer, Integer>> elementToItsWorthMap;
	private static final String INVALIDQUERY = "Invalid Query";
	
	@Before
	public void setUp() {
		try {
			wordToRomanCharacterMap = createElementToRomanCharacterMap();
			elementToItsWorthMap = createElementToItsWorthMap();
			unit = new ProcessQueries();
			br = new BufferedReader(new FileReader(new File(Files.EMPTY.getFileName())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Map<String, Pair<Integer, Integer>> createElementToItsWorthMap() {
		final Map<String, Pair<Integer, Integer>> map = new HashMap<String, Pair<Integer,Integer>>();
		map.put(Element.SILVER.getNameOfElement(), new Pair<Integer, Integer>(2, 34));
		map.put(Element.GOLD.getNameOfElement(), new Pair<Integer, Integer>(4, 57800));
		map.put(Element.IRON.getNameOfElement(), new Pair<Integer, Integer>(20, 3910));
		map.put(Element.COPPER.getNameOfElement(), new Pair<Integer, Integer>(60, 3600));
		return map;
	}

	private Map<String, Character> createElementToRomanCharacterMap() {
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
	public void shouldProcessQueryThatAsksToCalculateTotalUnits() {
		//Set Up
		try {
			final String query = "how much is pish tegj glob glob ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals("42", readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldWriteExceptionMessageWhenTheOrderOfRomanCharactersAreNotAsPerRules() {
		//Set Up
		try {
			final String query = "how much is glob tegj tegj ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals(INVALIDQUERY, readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void clearContentsOfFile() {
		try {
			FileWriter fw = new FileWriter(new File(Files.OUTPUT.getFileName()));
			fw.write("");
			fw.close();
		} catch(IOException e) {
		}
	}

	private String readFromFile(final BufferedReader bufferedReader) {
		String line = null;
		try {
			line = bufferedReader.readLine();
		} catch(IOException e) {
		}
		return line;
	}

	@Test
	public void shouldProcessQueryForSilver() {
		try {
			//Set Up
			final String query = "how many Credits is glob prok Silver ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals("68.0", readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
		}
	}
	
	@Test
	public void shouldProcessQueryForGold() {
		try {
			//Set Up
			final String query = "how many Credits is glob prok Gold ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals("57800.0", readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
		}
	}
	
	@Test
	public void shouldProcessQueryForIron() {
		try {
			//Set Up
			final String query = "how many Credits is glob prok Iron ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals("782.0", readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
		}
	}	
	
	@Test
	public void shouldProcessQueryForCopper() {
		try {
			//Set Up
			final String query = "how many Credits is pish glob glob Copper ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals("720.0", readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
		}
	}
	
	@Test
	public void shouldWriteExceptionMessageWhenAnInvalidWordsAreUsedForTrading() {
		try {
			//Set Up
			final String query = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals(INVALIDQUERY, readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
		}
	}
	
	@Test
	public void shouldWriteExceptionMessageWhenAnInvalidElementIsProcessed() {
		try {
			//Set Up
			final String query = "how many Credits is glob prok Platinum ?";
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Files.OUTPUT.getFileName())));
			
			//Execute
			unit.processQueriesAndCompute(br, query, elementToItsWorthMap, wordToRomanCharacterMap);
			
			//Verify
			Assert.assertEquals(INVALIDQUERY, readFromFile(bufferedReader));
			clearContentsOfFile();
		} catch(IOException e) {
		}
	}
 
}
