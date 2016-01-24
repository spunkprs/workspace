package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;

import org.junit.Test;

public class ParseTextTest {

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionForInvalidTextCaseOne() {
		//Set Up
		final String text = "XXXXLXI";
		
		//Execute && Verify
		ParseText.parse(text);
	}
	
	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionForInvalidTextCaseTwo() {
		//Set Up
		final String text = "XXM";
		
		//Execute && Verify
		ParseText.parse(text);
	}
	
	@Test
	public void shouldNotThrowExceptionForValidText() {
		//Set Up
		final String text = "MDXI";
		int counter = 0;
		
		//Execute
		try {
			ParseText.parse(text);
		} catch(RuntimeException e) {
			counter++;
		}
		
		//Verify
		Assert.assertEquals(0, counter);
	}
}
