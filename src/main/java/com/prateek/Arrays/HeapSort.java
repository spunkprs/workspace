package com.prateek.Arrays;

public class HeapSort {

	public int[] sort(final int array[]) {
		int indexOne = array.length - 1;
		int indexTwo = indexOne - 1;
		int counter = 0;
		applySorting(indexOne, indexTwo, array, counter);
		return array;
	}

	private void applySorting(int indexOne, int indexTwo, int[] array, int counter) {
		
		if (indexTwo == counter) {
			if (array[indexTwo] > array[indexOne]) {
				swap(indexOne, indexTwo, array);
				return;
			} else {
				return;
			}
		} 
			 int parentOne = getParent(indexOne, counter) + counter;
			 int parentTwo = getParent(indexTwo, counter) + counter; 
			 int parent = 0;
			 
			 if (isParentSame(parentOne, parentTwo)) {
				 parent = parentTwo;
			 } else {
				 parent = parentOne;
				 shuffle(parent, indexOne, array);
				 indexOne = indexTwo;
				 indexTwo = indexTwo - 1;
				 parent = getParent(indexOne, counter) + counter; 
			 }
			 
			 while(indexOne != counter) {
				 
				 if (isShufflingRequired(parent, indexOne, indexTwo, array)) {
					 
					 if (array[indexOne] <= array[indexTwo]) {
						 swap(indexOne, parent, array);
					 } else {
						 swap(indexTwo, parent, array);
					 }
				 }
				 indexOne-= 2;
				 indexTwo-= 2;
				 parent = getParent(indexOne, counter) + counter;
		 }
			 counter++;
			 
			 indexOne = array.length - 1;
			 indexTwo = indexOne - 1;
			 
			 applySorting(indexOne, indexTwo, array, counter);
	}

	private void shuffle(int parent, int indexOne, int array[]) {
		if (array[parent] > array[indexOne]) {
			swap(indexOne, parent, array);
		}
	}

	private void swap(int indexOne, int indexTwo, int array[]) {
		array[indexOne] = array[indexOne] ^ array[indexTwo];
		array[indexTwo] = array[indexOne] ^ array[indexTwo];
		array[indexOne] = array[indexOne] ^ array[indexTwo];
	}

	private boolean isShufflingRequired(int parent, int indexOne, int indexTwo, int[] array) {
		if (array[parent] > array[indexOne] || array[parent] > array[indexTwo]) {
			return true;
		}
		return false;
	}

	private boolean isParentSame(final int parentOne, final int parentTwo) {
		return parentOne == parentTwo ? true : false;
	}
	
	private int getParent(final int index, final int counter) {
		return (index - 1 - counter) / 2;
	}
}
