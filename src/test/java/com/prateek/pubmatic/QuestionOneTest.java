package com.prateek.pubmatic;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class QuestionOneTest {
	
	private QuestionOne unit;

	@Before
	public void setUp() {
		unit = new QuestionOne();
	}
	
	@Test
	public void shouldGetMinimumNumberOfStepsToReduceAnyNumberToOneCaseOne() {
		//Set Up
		final int number = 3;
		
		//Execute && Verify
		Assert.assertEquals(1, unit.getMinimumNumberOfStepsToReduceAnyNumberToOne(number));
	}
	
	@Test
	public void shouldGetMinimumNumberOfStepsToReduceAnyNumberToOneCaseTwo() {
		//Set Up
		final int number = 2;
		
		//Execute && Verify
		Assert.assertEquals(1, unit.getMinimumNumberOfStepsToReduceAnyNumberToOne(number));
	}
	
	@Test
	public void shouldGetMinimumNumberOfStepsToReduceAnyNumberToOneCaseThree() {
		//Set Up
		final int number = 10;
		
		//Execute && Verify
		Assert.assertEquals(3, unit.getMinimumNumberOfStepsToReduceAnyNumberToOne(number));
	}
}
