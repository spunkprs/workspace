package com.prateek.pubmatic;

public class QuestionOne {
	
	private int arr[];
	
	public int getMinimumNumberOfStepsToReduceAnyNumberToOne(final int number) {
		arr = new int[number];
		return reduceToOne(number);
	}

	private int reduceToOne(final int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			arr[0] = 1;
			return 1;
		} else if (arr[number - 1] != 0) {
			return arr[number - 1] + 1;
		}
		arr[number - 1] = min(reduceToOne(number - 1), reduceToOne(getSecondNumber(number)), reduceToOne(getThirdNumber(number)));
		return arr[number - 1];
	}

	private int getSecondNumber(int number) {
		if (number % 2 == 0) {
			return number / 2;
		}
		return 0;
	}

	private int getThirdNumber(int number) {
		if (number % 3 == 0) {
			return number / 3;
		}
		return 0;
	}

	private int min(int one, int two, int three) {
		if (one >= two) {
			if (one >= three) {
				return one;
			} else {
				return three;
			}
		} else {
			if (two >= three) {
				return two;
			} else {
				return three;
			}
		}
	}
}
