package com.prateek.pubmatic;

/*
 * Will return index of element if present in array, if element repeats itself then index of first occurence is returned , if not present -1 is returned.
 * */
public class QuestionTwo {
	
	private int pivotIndex = -1;
	public int searchForElement(final int arr[], final int elementToBeFound) {
		return isIncreasingCircularSorted(arr) ? searchInIncreasingCircularSortedArray(arr, elementToBeFound) : searchInDecreasingCircularSortedArray(arr, elementToBeFound);
	}
	
	private int searchInDecreasingCircularSortedArray(final int[] arr, final int elementToBeFound) {
		int index = findPivotIndexInCircularArray(arr, false);
		if (elementToBeFound == arr[index]) {
			return index;
		} else if (arr[index] > elementToBeFound && elementToBeFound >= arr[arr.length - 1]) {
			return searchInDecreasingArray(arr, index, arr.length - 1, elementToBeFound);
		} else if (elementToBeFound <= arr[0]) {
			return searchInDecreasingArray(arr, 0, index - 1, elementToBeFound);
		}
		return -1;
	}

	private int searchInIncreasingCircularSortedArray(final int[] arr, final int elementToBeFound) {
		int index = findPivotIndexInCircularArray(arr, true);
		if (elementToBeFound == arr[index]) {
			return index;
		} else if (arr[index] < elementToBeFound && elementToBeFound <= arr[arr.length - 1]) {
			return searchInIncreasingArray(arr, index, arr.length - 1, elementToBeFound);
		} else if (elementToBeFound <= arr[index - 1]) {
			return searchInIncreasingArray(arr, 0, index - 1, elementToBeFound);
		}
 		return -1;
	}

	private int searchInIncreasingArray(int[] arr, int start, int end, int elementToBeFound) {
		int mid = (start + end) / 2;
		if (elementToBeFound == arr[mid]) {
			return mid;
		} else if (elementToBeFound > arr[mid]) {
			return searchInIncreasingArray(arr, mid + 1, end, elementToBeFound);
		} else if (elementToBeFound < arr[mid]){
			return searchInIncreasingArray(arr, start, mid - 1, elementToBeFound);
		}
		return -1;
	}
	
	private int searchInDecreasingArray(int[] arr, int start, int end, int elementToBeFound) {
		int mid = (start + end) / 2;
		if (elementToBeFound == arr[mid]) {
			return mid;
		} else if (elementToBeFound > arr[mid]) {
			return searchInDecreasingArray(arr, start, mid - 1, elementToBeFound);
		} else if (elementToBeFound < arr[mid]){
			return searchInDecreasingArray(arr, mid + 1, end, elementToBeFound);
		}
		return -1;
	}

	private int findPivotIndexInCircularArray(final int arr[], final boolean isIncreasingCircularSorted) {
		 find(arr, 0, arr.length - 1, isIncreasingCircularSorted);
		 return pivotIndex;
	}

	private void find(int[] arr, int start, int end, final boolean isIncreasingCircularSorted) {
		int mid = (start + end)/2;
		if (isIncreasingCircularSorted) {
			if (arr[mid - 1] <= arr[mid] && arr[mid] <= arr[mid + 1]) {
				if (arr[mid] > arr[arr.length - 1]) {
					find(arr, mid, arr.length - 1, true);
				} else {
					find(arr, 0, mid, true);
				}
			} else {
				if (arr[mid - 1] <= arr[mid]) {
					pivotIndex = mid + 1;
				} else {
					pivotIndex = mid;
				}
			}
		} else {
			if (arr[mid - 1] >= arr[mid] && arr[mid] >= arr[mid + 1]) {
				if (arr[mid] < arr[arr.length - 1]) {
					find(arr, mid, arr.length - 1, false);
				} else {
					find(arr, 0, mid, false);
				}
			} else {
				if (arr[mid - 1] >= arr[mid]) {
					pivotIndex = mid + 1;
				} else {
					pivotIndex = mid;
				}
			}
		}
	}

	private boolean isIncreasingCircularSorted(final int[] arr) {
		return arr[arr.length - 1] <= arr[0] ? true : false;
	}
}
