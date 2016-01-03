package com.prateek.subsequence;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FetchSubsequencesTest {

	private FetchSubsequences unit;
	
	@Before
	public void setUp() {
		unit = new FetchSubsequences();
	}
	
	@Test
	public void shouldReturnListOfSizeZeroWhenInputStringIsOfSizeZero() {
		//Set Up
		final String str = "";
		
		//Execute
		final List<String> subStrings = unit.fetchSubSequences(str);
		
		//Verify
		Assert.assertEquals(0, subStrings.size());
	}
	
	@Test
	public void shouldReturnListOfSizeZeroWhenInputStringIsNull() {
		//Set Up
		final String str = null;
		
		//Execute
	    final List<String> subStrings = unit.fetchSubSequences(str);
	    
	    //Verify
	    Assert.assertEquals(0, subStrings.size());
	}
	
	@Test
	public void shouldReturnListOfSusSequencesWhenInputStringIsOfNonZeroSizeOne() {
		//Set Up
		final String string = "abcde";
		
		//Execute
		 final List<String> subSequences = unit.fetchSubSequences(string);
		 
		//Verify
		Assert.assertEquals(getNumberOfSubSequences(string), subSequences.size()); 
	}
	
	@Test
	public void shouldReturnListOfSusSequencesWhenInputStringIsOfNonZeroSizeTwo() {
		//Set Up
		final String string = "abcd";
		
		//Execute
		 final List<String> subSequences = unit.fetchSubSequences(string);
		 
		//Verify
		Assert.assertEquals(getNumberOfSubSequences(string), subSequences.size()); 
	}
	
	@Test
	public void shouldReturnListOfSusSequencesWhenInputStringIsOfSizeTwo() {
		//Set Up
		final String string = "ab";
		
		//Execute
		 final List<String> subSequences = unit.fetchSubSequences(string);
		 
		//Verify
		Assert.assertEquals(getNumberOfSubSequences(string), subSequences.size()); 
	}
	
	@Test
	public void shouldReturnListOfSusSequencesWhenInputStringIsOfSizeOne() {
		//Set Up
		final String string = "a";
		
		//Execute
		 final List<String> subSequences = unit.fetchSubSequences(string);
		 
		//Verify
		Assert.assertEquals(getNumberOfSubSequences(string), subSequences.size()); 
	}
	
	private int getNumberOfSubSequences(final String string) {
		return (int) (Math.pow(2, string.length()) - 1);
	}
}
