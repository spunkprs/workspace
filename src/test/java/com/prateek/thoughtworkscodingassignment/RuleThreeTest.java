package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleThreeTest {
	
	private RuleThree rule;
	
	@Before
	public void setUp() {
		rule = RuleThree.getInstance();
	}

	@Test
	public void inBiggerSymbolsIShouldBeFollowedByVAndXOnly() {
		//Set Up
		final char arr[] = {'I', 'V', 'X', 'I', 'X', 'I', 'M', 'I'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(3, arr));
		Assert.assertFalse(rule.validate(5, arr));
		Assert.assertTrue(rule.validate(6, arr));
	}
	
	@Test
	public void inBiggerSymbolsXShouldBeFollowedByLAndCOnly() {
		//Set Up
		final char arr[] = {'X', 'L', 'C', 'X', 'C', 'X', 'D', 'X', 'M', 'X', 'V'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(3, arr));
		Assert.assertFalse(rule.validate(5, arr));
		Assert.assertFalse(rule.validate(7, arr));
		Assert.assertTrue(rule.validate(9, arr));
	}
	
	@Test
	public void inBiggerSymbolsCShouldBeFollowedByDAndMOnly() {
		//Set Up
		final char arr[] = {'C', 'D', 'M', 'C', 'M', 'C', 'I', 'C', 'X'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(3, arr));
		Assert.assertTrue(rule.validate(5, arr));
		Assert.assertTrue(rule.validate(7, arr));
	}
}
