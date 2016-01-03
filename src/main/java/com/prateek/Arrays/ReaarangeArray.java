package com.prateek.Arrays;

public class ReaarangeArray {
	
	public Integer[] reArrangeArrayWithAlternatePositiveAndNegativeIntegers(final Integer[] input) {
		int i = 0;
		int negativeIntegerPosition;
		boolean flag = false;
		while (i < input.length) {
			if (input[i] < 0) {
				
				if((i+1) % 2 == 0) 
					lookForPositiveIntegerAndPerformRightRotation();
				else {
					flag = true;
					negativeIntegerPosition = i;
					lookForNegativeIntegerAndPerformRightRotation();
				}
				i++;
			}
		}
		return null;
	}

	private void lookForNegativeIntegerAndPerformRightRotation() {
		
	}

	private void lookForPositiveIntegerAndPerformRightRotation() {
		
	}
}
