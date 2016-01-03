package com.prateek.Arrays;

public class MergeSort {
	private int sortedArray[];
	public int[] sort(final int array[]) {
		sortedArray = new int[array.length];
		final int startIndex = 0;
		final int lastIndex = array.length - 1;
		divideAndConquer(startIndex, lastIndex, array);
		return sortedArray;
	}

	private void divideAndConquer(final int startIndex, final int lastIndex, int[] array) {
		final int middleIndex = getMiddleIndex(startIndex, lastIndex);
		
		if (startIndex != middleIndex) {
			divideAndConquer(startIndex, middleIndex, array);
			rearrange(startIndex, middleIndex, array);
		}
		
		if (middleIndex + 1 != lastIndex) {
			divideAndConquer(middleIndex + 1, lastIndex, array);
			rearrange(middleIndex + 1, lastIndex, array);
		}
		
		if (startIndex != middleIndex)
		merge(array, startIndex, middleIndex, lastIndex);
	}

	private void merge(final int[] array, final int startIndex, final int middleIndex, final int lastIndex) {
		int indexOne = startIndex;
		int indexTwo = middleIndex + 1;
		int index = indexOne;

		while(indexOne <= middleIndex && indexTwo <= lastIndex) {
			if (array[indexTwo] < array[indexOne]) {
				sortedArray[index] = array[indexTwo];
				index++;
				indexTwo++;
			} else if (array[indexTwo] >= array[indexOne]) {
				sortedArray[index] = array[indexOne];
				indexOne++;
				index++;
			}
		}
		
		if (indexTwo > lastIndex) {
			populate(index, indexOne, middleIndex, array);
		} else if (indexOne > middleIndex) {
			populate(index, indexTwo, lastIndex, array);
		}
		copyContents(startIndex, lastIndex, array);
	}

	private void copyContents(int startIndex, int lastIndex, int[] array) {
		for (int i = startIndex; i <= lastIndex; i++) {
			array[i] = sortedArray[i];
		}
	}

	private void populate(int index, int startIndex, int lastIndex, int array[]) {
		for (int i = startIndex; i <= lastIndex; i++) {
			sortedArray[index] = array[i];
			index++;
		}
	}

	private void rearrange(int startIndex, int lastIndex, int array[]) {
		if (lastIndex - startIndex == 1 && array[startIndex] > array[lastIndex]) {
			swap(startIndex, lastIndex, array);
		}
	}

	private int getMiddleIndex(int startIndex, int lastIndex) {
		return (startIndex + lastIndex) / 2;
	}
	
	private void swap(int indexOne, int indexTwo, int array[]) {
		array[indexOne] = array[indexOne] ^ array[indexTwo];
		array[indexTwo] = array[indexOne] ^ array[indexTwo];
		array[indexOne] = array[indexTwo] ^ array[indexOne];
	}
 }
