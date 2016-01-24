package com.prateek.thoughtworkscodingassignment;

import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;

public class RuleTwoTest {
	
	private RuleTwo rule;
	
	@Before
	public void setUp() {
		rule = RuleTwo.getInstance();
		rule.setMap(new HashMap<Character, Integer>());
	}
	
	@Test
	public void shouldGiveTrueOnFirstOccurenceOfAlphabetAndFalseOnSecondOccurenceOfSameAlphabet() {
		//Set Up
		final char arr[] = {'D', 'L', 'I', 'L', 'V', 'V'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(1, arr));
		Assert.assertFalse(rule.validate(2, arr));
		Assert.assertFalse(rule.validate(3, arr));
		Assert.assertTrue(rule.validate(4, arr));
		Assert.assertFalse(rule.validate(5, arr));
	}
	
	@Test
	public void shouldGiveTrueWhenArrayOfCharactersIsOfSizeOne() {
		//Set Up
		final char arr[] = {'D'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
	}
	
	@Test
	public void characterDShallNotBeFollowedByAnyCharacterWhichIsGreaterThanItsRank() {
		//Set Up
		final char arr[] = {'D', 'M'};
		
		//Execute && Verify
		Assert.assertFalse(rule.validate(0, arr));
	}
	
	@Test
	public void characterLShallNotBeFollowedByAnyCharacterWhichIsGreaterThanItsRank() {
		//Set Up
		final char arr[] = {'L', 'C'};
		
		//Execute && Verify
		Assert.assertFalse(rule.validate(0, arr));
	}
	
	@Test
	public void characterVShallNotBeFollowedByAnyCharacterWhichIsGreaterThanItsRank() {
		//Set Up
		final char arr[] = {'V', 'X'};
		
		//Execute && Verify
		Assert.assertFalse(rule.validate(0, arr));
	}

}
