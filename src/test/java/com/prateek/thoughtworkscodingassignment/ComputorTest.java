package com.prateek.thoughtworkscodingassignment;

import org.junit.Assert;

import org.junit.Test;

public class ComputorTest {

	@Test
	public void shouldComputeValueForHappyPathScenario() {
		//Set Up
		final String text = "MMMDXXI";
		
		//Execute && Verify
		Assert.assertEquals(3521, Computor.computeUnits(text.toCharArray()));
	}
	
	@Test
	public void shouldComputeValueCaseOne() {
		//Set Up
		final String text1 = "MMDXCIV";
		final String text2 = "MCMIII";
		final String text3 = "XLII";
		
		//Execute && Verify
		Assert.assertEquals(2594, Computor.computeUnits(text1.toCharArray()));
		Assert.assertEquals(1903, Computor.computeUnits(text2.toCharArray()));
		Assert.assertEquals(42, Computor.computeUnits(text3.toCharArray()));
	}
	
	@Test
	public void shouldComputeValueCaseTwo() {
		//Set Up
		final String text1 = "MMDXCMX";
		final String text2 = "MMDXCDM";
		final String text3 = "MCMXLIV";
		
		//Execute && Verify
		Assert.assertEquals(3420, Computor.computeUnits(text1.toCharArray()));
		Assert.assertEquals(3090, Computor.computeUnits(text2.toCharArray()));
		Assert.assertEquals(1944, Computor.computeUnits(text3.toCharArray()));
	}
	
	@Test
	public void shouldComputeValueForRomanStringOfSizeTwo() {
		//Set Up
		final String text1 = "MI";
		final String text2 = "IM";
		
		//Execute && Verify
		Assert.assertEquals(1001, Computor.computeUnits(text1.toCharArray()));
		Assert.assertEquals(999, Computor.computeUnits(text2.toCharArray()));
	}
	
	@Test
	public void shouldComputeValueForRomanStringOfSizeOne() {
		//Set Up
		final String text1 = "I";
		final String text2 = "M";
		
		//Execute && Verify
		Assert.assertEquals(1, Computor.computeUnits(text1.toCharArray()));
		Assert.assertEquals(1000, Computor.computeUnits(text2.toCharArray()));
	}
}
