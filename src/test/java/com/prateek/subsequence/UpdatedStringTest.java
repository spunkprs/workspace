package com.prateek.subsequence;

import org.junit.Assert;
import org.junit.Test;

public class UpdatedStringTest {

	@Test
	public void isOneStringSubsequenceOfAnotherOne() {
		//Set Up
		final String one = "Prateek";
		final String two = "rtk";
		
		Assert.assertTrue(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
	
	@Test
	public void isOneStringSubsequenceOfAnotherTwo() {
		//Set Up
		final String one = "rtk";
		final String two = "Prateek";
		
		Assert.assertTrue(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
	
	@Test
	public void isOneStringSubsequenceOfAnotherThree() {
		//Set Up
		final String one = "ABCD";
		final String two = "ABCK";
		
		Assert.assertFalse(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
	
	@Test
	public void isOneStringSubsequenceOfAnotherFour() {
		//Set Up
		final String one = "ABCD";
		final String two = "ABCD";
		
		Assert.assertTrue(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
	
	@Test
	public void isOneStringSubstringOfAnotherOne() {
		//Set Up
		final String one = "Prateek";
		final String two = "rat";
		
		Assert.assertTrue(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
	
	@Test
	public void isOneStringSubstringOfAnotherTwo() {
		//Set Up
		final String one = "rat";
		final String two = "Prateek";
		
		Assert.assertTrue(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
	
	@Test
	public void isOneStringSubstringOfAnotherThree() {
		//Set Up
		final String one = "rat";
		final String two = "rat";
		
		Assert.assertTrue(UpdatedString.isOneStringSubsequenceOfAnother(one, two));
	}
}
