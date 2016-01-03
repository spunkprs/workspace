package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ParseTextTest {

	private ParseText parseText;
	
	@Before
	public void setUp() {
		parseText = new ParseText();
	}
 	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionForInvalidTextCaseOne() {
		//Set Up
		final String text = "XXXXLXI";
		
		//Execute && Verify
		parseText.parse(text);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionForInvalidTextCaseTwo() {
		//Set Up
		final String text = "XXM";
		
		//Execute && Verify
		parseText.parse(text);
	}
	
	@Test
	public void shouldNotThrowExceptionForValidText() {
		//Set Up
		final String text = "MDXI";
		int counter = 0;
		
		//Execute
		try {
			parseText.parse(text);
		} catch(RuntimeException e) {
			counter++;
		}
		
		//Verify
		Assert.assertEquals(0, counter);
	}
}
