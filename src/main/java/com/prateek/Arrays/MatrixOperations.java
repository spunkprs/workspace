package com.prateek.Arrays;

public class MatrixOperations {

private int x = 0, y = 0;
	
public int[][] transpose(final int arr[][]) {
		
		while(x < arr.length - 1) {
			y = x + 1;
			while(y < arr[0].length) {
					performOperation(x, y, arr);
					y++;
			}
			x++;
		}
		return arr;
	}

	private void performOperation(int i, int j, int arr[][]) {
		 int temp = arr[i][j];
		 arr[i][j] = arr[j][i];
		 arr[j][i] = temp;
	}
	
	public int[][] rotateMatrix(final int arr[][]) {
		final int tranposedArray[][] = transpose(arr);
		reverseRows(tranposedArray);
		return tranposedArray;
	}

	private void reverseRows(final int[][] tranposedArray) {
		int midPoint = isEven(tranposedArray[0].length) ? tranposedArray[0].length/2 - 1: tranposedArray[0].length/2;
		
		for (int i = 0; i < tranposedArray.length; i++) {
			reverse(i, tranposedArray, midPoint);
		}
	}

	private boolean isEven(final int number) {
		return number % 2 == 0 ? true : false;
	}

	private void reverse(int i, int[][] tranposedArray, final int midPoint) {
		int len = tranposedArray[0].length;
		for (int j = len - 1; j > midPoint; j--) {
			int temp = tranposedArray[i][j];
			tranposedArray[i][j] = tranposedArray[i][len-1-j];
			tranposedArray[i][len-1-j] = temp;
		}
	}
 }
