package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class ComputorTest {

	private Computor unit;
	
	@Before
	public void setUp() {
		unit = new Computor();
	}
	
	@Test
	public void shouldComputeValueForHappyPathScenario() {
		//Set Up
		final String text = "MMMDXXI";
		
		//Execute && Verify
		Assert.assertEquals(3521, unit.computeUnits(text.toCharArray()));
	}
	
	@Test
	public void shouldComputeValue1() {
		//Set Up
		final String text1 = "MMDXCIV";
		final String text2 = "MCMIII";
		final String text3 = "XLII";
		
		//Execute && Verify
		Assert.assertEquals(2594, unit.computeUnits(text1.toCharArray()));
		Assert.assertEquals(1903, unit.computeUnits(text2.toCharArray()));
		Assert.assertEquals(42, unit.computeUnits(text3.toCharArray()));
	}
	
	@Test
	public void shouldComputeValue2() {
		//Set Up
		final String text1 = "MMDXCMX";
		final String text2 = "MMDXCDM";
		final String text3 = "MCMXLIV";
		
		//Execute && Verify
		Assert.assertEquals(3420, unit.computeUnits(text1.toCharArray()));
		Assert.assertEquals(3090, unit.computeUnits(text2.toCharArray()));
		Assert.assertEquals(1944, unit.computeUnits(text3.toCharArray()));
	}
	
	@Test
	public void shouldComputeValueForRomanStringOfSizeTwo() {
		//Set Up
		final String text1 = "MI";
		final String text2 = "IM";
		
		//Execute && Verify
		Assert.assertEquals(1001, unit.computeUnits(text1.toCharArray()));
		Assert.assertEquals(999, unit.computeUnits(text2.toCharArray()));
	}
	
	@Test
	public void shouldComputeValueForRomanStringOfSizeOne() {
		//Set Up
		final String text1 = "I";
		final String text2 = "M";
		
		//Execute && Verify
		Assert.assertEquals(1, unit.computeUnits(text1.toCharArray()));
		Assert.assertEquals(1000, unit.computeUnits(text2.toCharArray()));
	}
}
