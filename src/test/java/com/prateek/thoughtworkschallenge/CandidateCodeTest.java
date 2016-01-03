package com.prateek.thoughtworkschallenge;

import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;

public class CandidateCodeTest {
	
	private static final String INVALID = "Invalid";
	private static final String EQUAL = "Equal";
	private static final String UNEQUAL = "Unequal";
	
	@Before
	public void setUp() {
		CandidateCode.output = EQUAL;
	}

	@Test
	public void shouldGiveInvalidOutputWhenFirstArrayContainsNegativeInteger() {
		//Set Up
		int arrOne[] = {5, 10, 11, -9}; 
		int arrTwo[] = {4, 9, 9, 3};
		
		//Execute && Verify
		Assert.assertEquals(INVALID, CandidateCode.partiesCompare(arrOne, arrTwo));
	}
	
	@Test
	public void shouldGiveInvalidOutputWhenSecondArrayContainsNegativeInteger() {
		//Set Up
		int arrOne[] = {5, 10, 11, 9}; 
		int arrTwo[] = {4, 9, 9, -3};
		
		//Execute && Verify
		Assert.assertEquals(INVALID, CandidateCode.partiesCompare(arrOne, arrTwo));
	}
	
	@Test
	public void shouldGiveUnequalOutputWhenTwoArraysAreOfDifferentLengthButNoneOfThemContainsNegativeInteger() {
		//Set Up
		int arrOne[] = {5, 10, 11, 9, 0}; 
		int arrTwo[] = {4, 9, 9, 3};
		
		//Execute && Verify
		Assert.assertEquals(UNEQUAL, CandidateCode.partiesCompare(arrOne, arrTwo));
	}
	
	@Test
	public void shouldGiveUnequalOutputWhenTwoArraysHaveSameLengthButElementsWithDifferentFrequencies() {
		//Set Up
		int arrOne[] = {5, 10, 11, 9, 0}; 
		int arrTwo[] = {4, 9, 9, 3, 0};
		
		//Execute && Verify
		Assert.assertEquals(UNEQUAL, CandidateCode.partiesCompare(arrOne, arrTwo));
	}
	
	@Test
	public void shouldGiveEqualOutputWhenTwoArraysHaveSameLengthAndHaveElementsWithSameFrequencies() {
		//Set Up
		int arrOne[] = {5, 10, 9, 9, 11}; 
		int arrTwo[] = {11, 9, 10, 9, 5};
		
		//Execute && Verify
		Assert.assertEquals(EQUAL, CandidateCode.partiesCompare(arrOne, arrTwo));
	}
	
	@Test
	public void shouldGiveUnequalOutputWhenTwoArraysHaveSameLengthAndHaveElementsWithDifferentFrequenciesStatingThatAllTheElementsArePresentInBothArraysAtleastOnce() {
		//Set Up
		int arrOne[] = {5, 10, 9, 9, 11}; 
		int arrTwo[] = {11, 9, 10, 5, 5};
		
		//Execute && Verify
		Assert.assertEquals(UNEQUAL, CandidateCode.partiesCompare(arrOne, arrTwo));
	}
	
}
