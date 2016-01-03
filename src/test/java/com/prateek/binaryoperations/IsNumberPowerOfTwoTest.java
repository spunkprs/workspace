package com.prateek.binaryoperations;

import org.junit.Assert;

import org.junit.Test;

public class IsNumberPowerOfTwoTest {
	
	@Test
	public void shouldReturnTrueIfNumberIsPowerOfTwo() {
		Assert.assertTrue(IsNumberPowerOfTwo.isPowerOfTwo(16));
		Assert.assertTrue(IsNumberPowerOfTwo.isPowerOfTwo(64));
		Assert.assertTrue(IsNumberPowerOfTwo.isPowerOfTwo(256));
	}
	
	@Test
	public void shouldReturnFalseIfNumberIsNotPowerOfTwo() {
		Assert.assertFalse(IsNumberPowerOfTwo.isPowerOfTwo(20));
		Assert.assertFalse(IsNumberPowerOfTwo.isPowerOfTwo(6));
		Assert.assertFalse(IsNumberPowerOfTwo.isPowerOfTwo(1211));
	}
}
