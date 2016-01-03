package com.prateek.Permutation;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class FactorialTest {
	
	private Factorial unit;
	
	@Before
	public void setUp() {
		unit = new Factorial();
	}

@Test	
public void shallCalculateFactorialForANumber() {
	
	//SetUp,Execute && Verify
	Assert.assertEquals(720, unit.calculateFactorial(6));
	Assert.assertEquals(120, unit.calculateFactorial(5));
	Assert.assertEquals(24, unit.calculateFactorial(4));
	Assert.assertEquals(6, unit.calculateFactorial(3));
}
}
