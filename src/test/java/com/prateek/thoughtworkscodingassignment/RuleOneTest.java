package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;
import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

public class RuleOneTest {

	@Test
	public void shouldReturnTrueWhenRepetitionNumberIsThreeOrLessThanThree() {
		//Set Up
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		final char arr1[] = {'I', 'I', 'I', 'X', 'X', 'I'};
		RuleOne rule = RuleOne.getInstance(map);
		rule.setMap(new HashMap<Character, Integer>());
		
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
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		final char arr[] = {'X', 'X', 'I', 'I', 'I', 'I'};
		RuleOne rule = RuleOne.getInstance(map);
		rule.setMap(new HashMap<Character, Integer>());
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(1, arr));
		Assert.assertTrue(rule.validate(2, arr));
		Assert.assertTrue(rule.validate(3, arr));
		Assert.assertTrue(rule.validate(4, arr));
		Assert.assertFalse(rule.validate(5, arr));
	}
}
