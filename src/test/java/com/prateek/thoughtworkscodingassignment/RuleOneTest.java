package com.prateek.thoughtworkscodingassignment;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleOneTest {
	
	private RuleOne rule;
	
	@Before
	public void setUp() {
		rule = RuleOne.getInstance();
		rule.setMap(new HashMap<Character, Integer>());
	}

	@Test
	public void shouldReturnTrueWhenRepetitionNumberIsThreeOrLessThanThree() {
		//Set Up
		final char arr1[] = {'I', 'I', 'I', 'X', 'X', 'I'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr1));
		Assert.assertTrue(rule.validate(1, arr1));
		Assert.assertTrue(rule.validate(2, arr1));
		Assert.assertTrue(rule.validate(3, arr1));
		Assert.assertTrue(rule.validate(4, arr1));
		Assert.assertTrue(rule.validate(5, arr1));
	}
	
	@Test
	public void shouldReturnFalseWhenRepetitionNumberIsGreaterThanThree() {
		//Set Up
		final char arr[] = {'X', 'X', 'I', 'I', 'I', 'I'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(1, arr));
		Assert.assertTrue(rule.validate(2, arr));
		Assert.assertTrue(rule.validate(3, arr));
		Assert.assertTrue(rule.validate(4, arr));
		Assert.assertFalse(rule.validate(5, arr));
	}
	
	@Test
	public void shouldProcessWhenSizeOfTextIsOne() {
		//Set Up
		final char arr[] = {'X'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
	}
}
