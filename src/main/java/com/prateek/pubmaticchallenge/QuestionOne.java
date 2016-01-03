package com.prateek.pubmaticchallenge;

public class QuestionOne {

	public static void main(String[] args) {
     
		final int arr1[] = {4,1,0,2,9,6,8,7,5,3};
		final int arr2[] = {6,4,7,2,1,0,8,3,9};
		
		System.out.println(getRemovedElementFromArray(arr1, arr2));
	}

	private static int getRemovedElementFromArray(int arr1[], int arr2[]) {
		int sumOfFirstArray = getSumOfArrayElements(arr1);
		int sumOfSecondArray = getSumOfArrayElements(arr2);
		return sumOfFirstArray - sumOfSecondArray;
	}

	private static int getSumOfArrayElements(int[] array) {
		int sum = 0;
		for (int element : array) {
			sum+= element;
		}
		return sum;
	}
}
