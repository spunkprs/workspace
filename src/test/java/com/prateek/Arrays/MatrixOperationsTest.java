package com.prateek.Arrays;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class MatrixOperationsTest {
	private MatrixOperations unit;
	
	@Before
	public void setUp() {
		unit = new MatrixOperations();
	}
	
	@Test
	public void shouldTranspose() {
		//Set Up
		final int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		final int transposedArray[][] = {{1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {4, 8, 12, 16}}; 
		
		//Execute && Verify
		final int actualArray[][] = unit.transpose(arr);
		Assert.assertEquals(transposedArray.length, actualArray.length);
		Assert.assertEquals(arr[0].length, actualArray[0].length);
		verify(transposedArray, actualArray);
	}   
	
	@Test
	public void shouldRotateEvenSizedMatrixBy90Degrees() {
		final int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		final int expectedRotatedArray[][] = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}}; 
		
		//Execute && Verify
		final int actualRotatedArray[][] = unit.rotateMatrix(arr);
		verify(expectedRotatedArray, actualRotatedArray);
	}
	
	@Test
	public void shouldRotateOddSizedMatrixBy90Degrees() {
		final int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		final int expectedRotatedArray[][] = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}; 
		
		//Execute && Verify
		final int actualRotatedArray[][] = unit.rotateMatrix(arr);
		verify(expectedRotatedArray, actualRotatedArray);
	}

	private void verify(int[][] arr, int[][] actualArray) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				Assert.assertEquals(arr[i][j], actualArray[i][j]);
			}
		}
	}
}
