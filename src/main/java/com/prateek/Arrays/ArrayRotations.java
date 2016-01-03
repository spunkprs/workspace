package com.prateek.Arrays;

public class ArrayRotations {
	
	protected int[] rightRotateWithExtraSpace(final int arr[], final int numberOfTimes) {
		int timesToRotate = numberOfTimes % arr.length;
		return performRightRotation(arr, timesToRotate);
	}
	
	protected void rightRotateWithoutExtraSpace(final int arr[], final int numberOfTimes) {
		int timesToRotate = numberOfTimes % arr.length;
		int numberOfLeftRotations = -1;
		if (timesToRotate != 0) {
			numberOfLeftRotations = arr.length - timesToRotate;
			leftRotationWithoutExtraSpace(arr, numberOfLeftRotations);
		}
	}

	private void leftRotationWithoutExtraSpace(final int[] arr, final int timesToRotate) {
		if (timesToRotate != 0) {
			performLeftRotation(arr, 0, timesToRotate - 1);
			performLeftRotation(arr, timesToRotate, arr.length - 1);
			performLeftRotation(arr, 0, arr.length - 1);
		}
	}

	private void performLeftRotation(final int[] arr, final int startIndex, final int endIndex) {
		int i = startIndex;
		int j = endIndex;
		int tempVariable = -1;
		while(i < j) {
			tempVariable = arr[i];
			arr[i] = arr[j];
			arr[j] = tempVariable;
			i++;
			j--;
		}
	}

	private int[] performRightRotation(final int[] arr, final int timesToRotate) {
		final int tempArray[] = new int[arr.length];
		if (timesToRotate != 0) {
			for (int i = 0; i < arr.length; i++) {
				int index = (i + timesToRotate) % arr.length;
				tempArray[index] = arr[i];
			}
			return tempArray;
		}
		return arr;
	}
}
