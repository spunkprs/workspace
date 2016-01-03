package com.prateek.Arrays;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ArrayRotationsTest {

	private ArrayRotations unit;
	
	@Before
	public void init() {
		unit = new ArrayRotations();
	}
	
	@Test
	public void shouldRotateArrayByNumberOfStepsInRight() {
		//Set Up
		final int arr[] = {2, 4, 6, 8, 10};
		
		final int rotationSteps = 8;
		
		//Execute
		int actualRotatedArray[] = unit.rightRotateWithExtraSpace(arr, rotationSteps);
		
		final int expectedRotatedArray[] = {6, 8, 10, 2, 4};
		
		//Verify
		Assert.assertEquals(expectedRotatedArray.length, actualRotatedArray.length);
		verifyElementsOfArray(expectedRotatedArray, actualRotatedArray);
	}
	
	@Test
	public void shouldRotateArrayInRight() {
		final int arr[] = {2, 4, 6, 8, 10};
		final int rotationSteps = 8;
		
		unit.rightRotateWithoutExtraSpace(arr, rotationSteps);
		final int expectedRotatedArray[] = {6, 8, 10, 2, 4};
		
		//Verify
		Assert.assertEquals(expectedRotatedArray.length, arr.length);
		verifyElementsOfArray(expectedRotatedArray, arr);
	}
	
	@Test
	public void shouldNotRotateWhenNumberOfRotationsIsEqualToLengthOfArray() {
		final int arr[] = {2, 4, 6, 8, 10};
		final int rotationSteps = arr.length;
		
		int actualRotatedArray[] = unit.rightRotateWithExtraSpace(arr, rotationSteps);
		
		final int expectedRotatedArray[] = {2, 4, 6, 8, 10};
		
		//Verify
		Assert.assertEquals(expectedRotatedArray.length, actualRotatedArray.length);
		verifyElementsOfArray(expectedRotatedArray, actualRotatedArray);
	}

	private void verifyElementsOfArray(final int[] expectedRotatedArray, final int[] actualRotatedArray) {
		for(int i = 0; i < expectedRotatedArray.length; i++) {
			Assert.assertEquals(expectedRotatedArray[i], actualRotatedArray[i]);
		}
	}
}
