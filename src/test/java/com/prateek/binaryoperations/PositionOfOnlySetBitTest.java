package com.prateek.binaryoperations;

import org.junit.Assert;

import org.junit.Test;

public class PositionOfOnlySetBitTest {

	@Test
	public void shouldGetPositionOfOnlySetBitWhenNumberIsPowerOfTwo() throws Exception {
		Assert.assertEquals(4, PositionOfOnlySetBit.getPositionOfOnlySetBit(16));
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowExceptionInCaseNumberIsNotPowerOfTwo() throws Exception {
		PositionOfOnlySetBit.getPositionOfOnlySetBit(19);
	}
}
