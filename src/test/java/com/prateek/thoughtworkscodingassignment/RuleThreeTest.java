package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;
import org.junit.Test;

public class RuleThreeTest {

	@Test
	public void inBiggerSymbolsIShouldBeFollowedByVAndXOnly() {
		//Set Up
		Rule rule = RuleThree.getInstance();
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
		Rule rule = RuleThree.getInstance();
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
		Rule rule = RuleThree.getInstance();
		final char arr[] = {'C', 'D', 'M', 'C', 'M', 'C', 'I', 'C', 'X'};
		
		//Execute && Verify
		Assert.assertTrue(rule.validate(0, arr));
		Assert.assertTrue(rule.validate(3, arr));
		Assert.assertTrue(rule.validate(5, arr));
		Assert.assertTrue(rule.validate(7, arr));
	}
	
	@Test
	public void vShouldNotBeFollowedByAnyBiggerSymbolThanIt() {
		//Set Up
		Rule rule = RuleThree.getInstance();
		final char arr1[] = {'V', 'D', 'I', 'X'};
		final char arr2[] = {'V', 'I', 'I', 'X'};
		
		//Execute && Verify
		Assert.assertFalse(rule.validate(0, arr1));
		Assert.assertTrue(rule.validate(0, arr2));
	}
	
	@Test
	public void lShouldNotBeFollowedByAnyBiggerSymbolThanIt() {
		//Set Up
		Rule rule = RuleThree.getInstance();
		final char arr1[] = {'L', 'D', 'I', 'X'};
		final char arr2[] = {'L', 'V', 'I', 'X'};
		
		//Execute && Verify
		Assert.assertFalse(rule.validate(0, arr1));
		Assert.assertTrue(rule.validate(0, arr2));
	}
	
	@Test
	public void dShouldNotBeFollowedByAnyBiggerSymbolThanIt() {
		//Set Up
		Rule rule = RuleThree.getInstance();
		final char arr1[] = {'D', 'M', 'I', 'X'};
		final char arr2[] = {'D', 'C', 'I', 'X'};
		
		//Execute && Verify
		Assert.assertFalse(rule.validate(0, arr1));
		Assert.assertTrue(rule.validate(0, arr2));
	}
}
