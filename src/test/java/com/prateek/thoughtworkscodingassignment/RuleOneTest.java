package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

public class RuleOneTest {
	
	private Map<Character, Integer> map;
	private RuleOne rule;
	
	@Before
	public void setUp() {
		map = new HashMap<Character, Integer>();
		rule = RuleOne.getInstance(map);
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
}
