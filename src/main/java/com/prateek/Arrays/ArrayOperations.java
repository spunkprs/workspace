package com.prateek.Arrays;

import java.util.List;

import javax.sound.midi.Sequence;

import com.google.common.collect.Lists;

public class ArrayOperations {

	private int positionOfZero = -1;
	private int inversionCounter = 0;
	private int dummyArray[];
	private List<Integer> patternOfNumbers;
	private int minimumNumberOfSteps = Integer.MAX_VALUE;
	
	public int countNumberOfZeroesInAnArray(final int[] array) {
		getPositionOfFirstOccurenceOfZero(array, 0, array.length - 1);
		if (positionOfZero == -1) {
			return -1;
		}
		return array.length - positionOfZero;
	}
	
	/*
	 * Thing to notice here is the time taken to generate the result is O(n^k)
	 * where n is the number of characters and k is the length of the desired string.
	 * */
	
	public List<String> getAllPossibleStringsFormedFromSetOfNCharacters(final char arr[], int length) {
		List<String> sequences = Lists.newArrayList();
		int counter = 1;
		String sequence = "";
		for (int i = 0; i < arr.length; i++) {
			sequence += Character.toString(arr[i]);
			prepareSequences(counter, sequence, length, sequences, arr);
			sequence = "";
		}
		return sequences;
	}
	
	private void prepareSequences(int counter, String sequence, int length, List<String> sequences, char arr[]) {
		if (counter == length) {
			sequences.add(sequence);
		} else {
			for (int i = 0; i < arr.length; i++) {
				sequence += Character.toString(arr[i]);
				prepareSequences(counter + 1, sequence, length, sequences, arr);
				sequence = removeLastCharacter(sequence);
			}
		}
	}
	
	private String removeLastCharacter(String sequence) {
		return sequence.substring(0, sequence.length() - 1);
	}

	public List<String> getIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbers(final int length, final int n) {
		List<String> increasingSequences = Lists.newArrayList();
		if (length == n) {
			prepareIncreasingSequence(n, increasingSequences);
		} else if (length > n) {
			increasingSequences = null;
		} else {
			String sequence = "";
			for (int i = 1; i <= (n - length + 1); i++) {
				int counter = 1;
				sequence += Integer.toString(i);
				getIncreasingSequence(i + 1, length, n, increasingSequences, counter, sequence);
				sequence = "";
			}
		}
		return increasingSequences;
	}
	
	private void getIncreasingSequence(final int i, final int length, final int n, final List<String> increasingSequences, final int counter, String sequence) {
		int margin = length - counter;
		if (counter == length - 1) {
			String seq = sequence;
			for (int j = i; j <= n; j++) {
				seq += Integer.toString(j);
				increasingSequences.add(seq);
				seq = sequence;
			}
		} else {
			for (int j = i; j <= n - margin + 1; j++) {
				sequence += Integer.toString(j);
				getIncreasingSequence(j + 1, length, n, increasingSequences, counter + 1, sequence);
				sequence = sequence.replace(Integer.toString(j), "");
			}
		}
	}

	private void prepareIncreasingSequence(final int n, final List<String> increasingSequences) {
		String sequence = "";
		for (int i = 1; i <= n; i++) {
			sequence += Integer.toString(i);
		}
		increasingSequences.add(sequence);
	}
	
	public List<Integer> printPattern(final int number) {
		patternOfNumbers = Lists.newArrayList();
		createPatternOfPositiveNumbers(number, number);
		return patternOfNumbers;
	}

	private void createPatternOfPositiveNumbers(int number, int initialNumber) {
		if (number > 0) {
			patternOfNumbers.add(number);
			createPatternOfPositiveNumbers(number - 5, initialNumber);
		}
		if (number <= 0) {
			patternOfNumbers.add(number);
			createPatternOfNegativeNumbers(number + 5, initialNumber);
		}
	}


	private void createPatternOfNegativeNumbers(int number, int initialNumber) {
		if (number != initialNumber) {
			patternOfNumbers.add(number);
			createPatternOfNegativeNumbers(number + 5, initialNumber);
		} else if (number == initialNumber) {
			patternOfNumbers.add(number);
		}
	}


	private void getPositionOfFirstOccurenceOfZero(final int[] array, int min, int max) {
		int median = (min + max)/2;
		if (median != 0 && array[median] == 0 && array[median - 1] == 1) {
			positionOfZero = median;
		} else if (median == 0 && array[median] == 0) {
			positionOfZero = 0;
		} else if (array[median] == 1 && median != max) {
			getPositionOfFirstOccurenceOfZero(array, median + 1, max);
		} else if (array[median] == 0 && array[median - 1] != 1) {
			getPositionOfFirstOccurenceOfZero(array, 0, median - 1);
		} 
	}
	
	public int countInversionsInAnArray(final int [] array) {
		if (array.length >= 3) {
			countInversions(array, 0, array.length - 1);
			return inversionCounter;
		} else if (array.length > 1 && array.length < 3) {
			rearrange(array, 0, 1);
			return inversionCounter;
		} else {
			return 0;
		}
	}

	private void countInversions(final int[] array, final int min, int max) {
		int median = (min + max) / 2;
		
		if (median - min > 1) {
			countInversions(array, 0, median);
		} else {
			rearrange(array, min, median);
		}
		
		if(max - (median + 1) > 1) {
			countInversions(array, median + 1, max);
		} else {
			rearrange(array, median + 1, max);
		}
		
		merge(array, min, median, max);
	}

	private void merge(final int[] array, final int min, final int median, final int max) {
		dummyArray = new int[max - min + 1];
		int counterOne = min;
		int counterTwo = median + 1;
		int index = counterOne;
		while((counterOne != median + 1) && (counterTwo != max + 1)) {
			if (array[counterOne] > array[counterTwo]) {
				inversionCounter = inversionCounter + median - counterOne + 1;
				dummyArray[index] = array[counterTwo];
				counterTwo++;
				index++;
			} else {
				dummyArray[index] = array[counterOne];
				counterOne++;
				index++;
			}
		}
		populateDummyArray(counterOne, counterTwo, median, max, index, array);
		copyContents(array, min, max);
	}

	private void populateDummyArray(final int counterOne, final int counterTwo, final int median, final int max, int index, final int array[]) {
		for (int i = counterOne; i <= median; i++) {
			dummyArray[index] = array[i];
			index++;
		}
		for (int i = counterTwo; i <= max; i++) {
			dummyArray[index] = array[i];
			index++;
		}
	}

	private void copyContents(final int[] array, final int min, final int max) {
		for (int i = min; i <= max; i++) {
			array[i] = dummyArray[i];
		}
	}

	private void rearrange(final int[] array, final int indexOne, final int indexTwo) {
		if (indexOne != indexTwo && array[indexOne] > array[indexTwo]) {
			swap(indexOne, indexTwo, array);
			inversionCounter++;
		}
	}

	private void swap(final int indexOne, int indexTwo, final int[] array) {
		final int temp = array[indexOne] ^ array[indexTwo];
		array[indexOne] = array[indexOne] ^ temp;
		array[indexTwo] = array[indexOne] ^ temp;
	}
	
	
public int getMinimumStepsToReachDestination(final int num) {
	String path = "0";
	int currentIndex = 0;
	int step = 0;
	preparePathAndGetMinimumSteps(num, currentIndex, step, path);
	return minimumNumberOfSteps;
}

private void preparePathAndGetMinimumSteps(int num, int currentIndex, int step, String path) {
	
		if (Math.abs(currentIndex) == num) {
			int minSteps = 0;
			path = path + String.valueOf(step);
			minSteps = getPositiveSteps(step);
			if (minSteps < minimumNumberOfSteps) {
				minimumNumberOfSteps = minSteps;
			}
			
		} else if (Math.abs(currentIndex) < num) {
			if (step >= 0) {
				preparePathAndGetMinimumSteps(num, currentIndex + step + 1, step + 1, path);
				step = step * - 1;
				preparePathAndGetMinimumSteps(num, currentIndex + step - 1, step - 1, path);
			}
			if (step < 0) {
				preparePathAndGetMinimumSteps(num, currentIndex + step - 1, step - 1, path);
				step = step * - 1;
				preparePathAndGetMinimumSteps(num, currentIndex + step + 1, step + 1, path);
			}
		}
}

private int getPositiveSteps(int step) {
	return step < 0 ? step * -1 : step;
}
	
}
