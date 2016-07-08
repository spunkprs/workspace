package com.prateek.Amazon;

import org.junit.Before;
import org.junit.Test;

import com.prateek.amazon.ExpressionEvaluation;

import org.junit.Assert;

public class ExpressionEvaluationTest {
	
	private ExpressionEvaluation unit;
	
	@Before
	public void setUp() {
		unit = new ExpressionEvaluation();
	}

	@Test
	public void shouldComputeExpressionValueCaseOne() {
		Assert.assertEquals(31, unit.computeExpression("19 + 12 / 4 - ((4 - 7) * 3 / 1)"));
	}
	
	@Test
	public void shouldComputeExpressionValueCaseTwo() {
		Assert.assertEquals(1, unit.computeExpression("((2 + 4) / 3 - 2 + 1)"));
	}
	
	@Test
	public void shouldComputeExpressionValueCaseThree() {
		Assert.assertEquals(-2855, unit.computeExpression("1 + (2 - 3) * 4 + 5 - 6 * 8 - (18 * 12 * 13) - (11 / (5 + 2 + 4))"));
	}
}
