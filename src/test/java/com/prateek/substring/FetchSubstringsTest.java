package com.prateek.substring;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class FetchSubstringsTest {

	
	private FetchSubstrings unit;
	
	@Before
	public void setUp() {
		unit = new FetchSubstrings();
	}
	
	@Test
	public void shouldReturnListOfSizeZeroWhenInputStringIsOfSizeZero() {
		//Set Up
		final String str = "";
		
		//Execute
		final List<String> subStrings = unit.fetchSubStrings(str);
		
		//Verify
		Assert.assertEquals(0, subStrings.size());
	}
	
	@Test
	public void shouldReturnListOfSizeZeroWhenInputStringIsNull() {
		//Set Up
		final String str = null;
		
		//Execute
	    final List<String> subStrings = unit.fetchSubStrings(str);
	    
	    //Verify
	    Assert.assertEquals(0, subStrings.size());
	}
	
	@Test
	public void shouldReturnListWhenInputStringIsOfNonZeroSize() {
		//Set Up
		final String string = "abcde";
		final int numberOfSubStrings = getNumberOfSubStrings(string); 
		
		//Execute
		 final List<String> subStrings = unit.fetchSubStrings(string);
		 
		 Assert.assertEquals(numberOfSubStrings, subStrings.size());
	}
	
	@Test
	public void shouldReturnListWhenInputStringIsOfSizeOne() {
		//Set Up
		final String string = "a";
		final int numberOfSubStrings = getNumberOfSubStrings(string); 
		
		//Execute
		 final List<String> subStrings = unit.fetchSubStrings(string);
		 
		 Assert.assertEquals(numberOfSubStrings, subStrings.size());
	}
	
	@Test
	public void shouldReturnListWhenInputStringIsOfSizeTwo() {
		//Set Up
		final String string = "ab";
		final int numberOfSubStrings = getNumberOfSubStrings(string); 
		
		//Execute
		 final List<String> subStrings = unit.fetchSubStrings(string);
		 
		 Assert.assertEquals(numberOfSubStrings, subStrings.size());
	}

	private int getNumberOfSubStrings(String string) {
		final int stringLength = string.length();
		return (stringLength * (stringLength + 1)) / 2;
	}
}
