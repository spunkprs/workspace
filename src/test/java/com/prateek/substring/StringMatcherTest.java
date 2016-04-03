package com.prateek.substring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringMatcherTest {
	
	private StringMatcher unit;
	
	@Before
	public void setUp() {
		unit = new StringMatcher();
	}
	
	@Test
	public void shouldReturnTrueIfStringOneContainsStringTwoCaseOne() {
		final String stringOne = "ABCCBA";
		final String stringTwo = "CB";
		
		Assert.assertTrue(unit.doesContains(stringOne, stringTwo));
	}
	
	@Test
	public void shouldReturnTrueIfStringOneContainsStringTwoCaseTwo() {
		final String stringOne = "ABCCBA";
		final String stringTwo = "CBA";
		
		Assert.assertTrue(unit.doesContains(stringOne, stringTwo));
	}
	
	@Test
	public void shouldReturnTrueIfStringOneContainsStringTwoCaseThree() {
		final String stringOne = "ABCCBA";
		final String stringTwo = "ABCCBA";
		
		Assert.assertTrue(unit.doesContains(stringOne, stringTwo));
	}
	
	@Test
	public void shouldReturnFalseIfStringOneDoesNotContainStringTwoCaseOne() {
		final String stringOne = "ABCCBA";
		final String stringTwo = "BB";
		
		Assert.assertFalse(unit.doesContains(stringOne, stringTwo));
	}
}
