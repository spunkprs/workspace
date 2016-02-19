package com.prateek.binaryoperations;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Before;

public class OperationOnNumbersTest {

	private OperationsOnNumbersWithoutArithmeticOperators unit;
	
	@Before
	public void setUp() {
		unit = new OperationsOnNumbersWithoutArithmeticOperators();
	}
	
	@Test
	public void shouldAddNumbersHavingNoCommonBitSet() {
		
		//Set && Execute && Verify
		Assert.assertEquals(13, unit.add(8, 5));
		Assert.assertEquals(19, unit.add(3, 16));
	}
	
	@Test
	public void shouldAddNumbersHavingCommonBitSet() {
		//Set && Execute && Verify
	 Assert.assertEquals(12, unit.add(9, 3));
	 Assert.assertEquals(19, unit.add(9, 10));
	}
	
	@Test
	public void shouldSubtractNumbers() {
		//Set && Execute && Verify
		Assert.assertEquals(-2, unit.subtract(3, 5));
		Assert.assertEquals(10, unit.subtract(25, 15));
	}
	
	@Test
	public void shouldPerformMultiplicationWhenOneOrBothTheOperandsAreZero() {
		//Set && Execute && Verify
		 Assert.assertEquals(0, unit.multiply(10, 0));
		 Assert.assertEquals(0, unit.multiply(0, 0));
	}
	
	@Test
	public void shouldPerformMultiplicationWhenOneOrBothTheOperandsAreNonZero() {
		//Set && Execute && Verify
		 Assert.assertEquals(50, unit.multiply(10, 5));
		 Assert.assertEquals(32, unit.multiply(2, 16));
	}
	
	@Test
	public void shouldPerformMultiplicationWhenOneOrBothTheOperandsAreNegative() {
		//Set && Execute && Verify
		 Assert.assertEquals(50, unit.multiply(-10, -5));
		 Assert.assertEquals(-32, unit.multiply(-2, 16));
	}
	
	@Test
	public void shouldGetNumberOfOnesInANumber() {
		//Set && Execute && Verify
		Assert.assertEquals(2, OperationsOnNumbersWithoutArithmeticOperators.numberOfOnesInANumber(18));
		Assert.assertEquals(1, OperationsOnNumbersWithoutArithmeticOperators.numberOfOnesInANumber(16));
		Assert.assertEquals(3, OperationsOnNumbersWithoutArithmeticOperators.numberOfOnesInANumber(19));
		Assert.assertEquals(1, OperationsOnNumbersWithoutArithmeticOperators.numberOfOnesInANumber(2));
		Assert.assertEquals(1, OperationsOnNumbersWithoutArithmeticOperators.numberOfOnesInANumber(1));
		Assert.assertEquals(0, OperationsOnNumbersWithoutArithmeticOperators.numberOfOnesInANumber(0));
	}
	
	@Test
	public void shouldDivideTwoNumbers() {
		//Set && Execute && Verify
		Assert.assertEquals(4, unit.division(16, 4));
		Assert.assertEquals(13, unit.division(26, 2));
		Assert.assertEquals(4, unit.division(45, 11));
		Assert.assertEquals(1, unit.division(10, 10));
		Assert.assertEquals(0, unit.division(2, 10));
	}
	
	@Test
	public void shouldGetTwoNumbersInArrayWhereAllNumbersAreRepeatedEvenNumberOfTimesExceptThoseTwoNumbersWhichRepeatsOddNumberOfTimes() {
		//Set 
		final int array[] = {2, 7, 2, 3, 4, 5, 4, 9, 9, 7}; 
		final List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(3);
		expectedList.add(5);
		
		//Execute && Verify
		final List<Integer> actualList = OperationsOnNumbersWithoutArithmeticOperators.getTwoNumbersWhichAreRepeatedOddNumberOfTimesWhileOtherAreRepeatedEvenNumberOfTimes(array);
		Assert.assertEquals(expectedList.size(), actualList.size());
	}
	
	@Test
	public void shouldConvertDecimalToBinaryFormat() {
		//Set 
		final int number = 11;
		final int binaryFormat[] = OperationsOnNumbersWithoutArithmeticOperators.convertDecimalToBinaryWithoutUsingModuloOperator(number);
		for (int i = 0; i < binaryFormat.length; i++) {
			System.out.print(binaryFormat[i]);
		}
	}
}
