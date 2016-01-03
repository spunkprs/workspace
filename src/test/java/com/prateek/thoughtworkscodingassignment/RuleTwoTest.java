package com.prateek.thoughtworkscodingassignment;

import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

import org.junit.Assert;

public class RuleTwoTest {
	
	@Test
	public void shouldGiveTrueOnFirstOccurenceOfAlphabetAndFalseOnSecondOccurenceOfSameAlphabet() {
		//Set Up
		final Map<Character, Integer> map = new HashMap<Character, Integer>();
		final char arr[] = {'D', 'L', 'D', 'L', 'V', 'V'};
		
		//Execute && Verify
		Rule rule = RuleTwo.getInstance(map);
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(1, arr));
		Assert.assertFalse(rule.validate(2, arr));
		Assert.assertFalse(rule.validate(3, arr));
		Assert.assertFalse(rule.validate(4, arr));
	}

}
