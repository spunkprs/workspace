package com.prateek.divideandconquer;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class MaximumSumSubArray {
	
	List<Integer> indexes;
	
	public List<Integer> getMaximumSumSubArrayIndexesUsingDivideAndConquerApproach(final int arr[]) {
		if (arr.length == 1) {
			return Lists.newArrayList(0, 0, arr[0]);
		}
		return getMaximumSubArrayIndexesAndSum(arr, 0, arr.length - 1);
	}
	
	private List<Integer> getMaximumSubArrayIndexesAndSum(final int[] arr, final int low, final int high) {
			List<Integer> leftIndexesAndSum = Lists.newArrayList();
			List<Integer> rightIndexesAndSum = Lists.newArrayList();
			List<Integer> crossIndexesAndSum = Lists.newArrayList();
			int mid = (low + high) / 2;
			
			if (mid - low > 1) {
				leftIndexesAndSum = getMaximumSubArrayIndexesAndSum(arr, low, mid);
			} else {
				leftIndexesAndSum = getIndexesAndSum(arr, low, mid);
			}
			
			if (high - (mid + 1) > 1) {
				rightIndexesAndSum = getMaximumSubArrayIndexesAndSum(arr, mid + 1, high);
			} else {
				rightIndexesAndSum = getIndexesAndSum(arr, mid + 1, high);
			}
			
			crossIndexesAndSum = getMaximumSubArrayIndexesAndSumWhenSubArrayCrossesMidPoint(arr, low, mid, high);
			return fetchIndexes(leftIndexesAndSum, rightIndexesAndSum, crossIndexesAndSum);
	}

	private List<Integer> fetchIndexes(final List<Integer> leftIndexesAndSum, final List<Integer> rightIndexesAndSum, final List<Integer> crossIndexesAndSum) {
		if (leftIndexesAndSum.get(2) >= rightIndexesAndSum.get(2) && leftIndexesAndSum.get(2) >= crossIndexesAndSum.get(2)) {
			return leftIndexesAndSum;
		} else if (rightIndexesAndSum.get(2) >= leftIndexesAndSum.get(2) && rightIndexesAndSum.get(2) >= crossIndexesAndSum.get(2)) {
			return rightIndexesAndSum;
		}
		return crossIndexesAndSum;
	}

	private List<Integer> getIndexesAndSum(final int[] arr, int low, int high) {
		if (low == high) {
			return Lists.newArrayList(low, low, arr[low]);
		} else {
			if (arr[low] < 0 && arr[high] >=0) {
				return Lists.newArrayList(high, high, arr[high]);
			} else if (arr[low] >= 0 && arr[high] < 0) {
				return Lists.newArrayList(low, low, arr[low]);
			} else if (arr[low] < 0 && arr[high] < 0) {
				if (arr[low] >= arr[high]) {
					return Lists.newArrayList(low, low, arr[low]);
				} else {
					return Lists.newArrayList(high, high, arr[high]);
				}
			} else {
				return Lists.newArrayList(low, high, arr[low] + arr[high]);
			}
		}
	}

	private List<Integer> getMaximumSubArrayIndexesAndSumWhenSubArrayCrossesMidPoint(final int arr[], final int low, final int mid, final int high) {
		int sum = 0, leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
		int l = 0,h = 0;
		for (int i = mid; i >=low ; i--) {
			sum += arr[i];
			if (sum >= leftSum) {
				leftSum = sum;
				l = i;
			}
		}
		sum = 0;
		
		for (int i = mid + 1; i <= high; i++) {
			sum += arr[i];
			if (sum >= rightSum) {
				rightSum = sum;
				h = i;
			}
		}
		return Lists.newArrayList(l, h, leftSum + rightSum);
	}

	public List<Integer> getMaximumSumSubArrayIndexesUsingBruteForceApproach(final int arr[]) {
		int max = Integer.MIN_VALUE;
		int l = 0, h = 0, sum = 0;
		int minValue;
		indexes = prepareDefaultIndexesList();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			sum = 0;
			minValue = Integer.MIN_VALUE;
			l = i;
			for (int j = i ; j < arr.length; j++) {
				sum += arr[j];
				if (sum > minValue) {
					minValue = sum;
					h = j;
				}
			}
			max = fetchMaxValueAndSetIndexes(max, minValue, l, h);
		}
		return indexes;
	}

	private List<Integer> prepareDefaultIndexesList() {
		List<Integer> indexesOfSubArray = new ArrayList<Integer>();
		indexesOfSubArray.add(0);
		indexesOfSubArray.add(0);
		return indexesOfSubArray;
	}

	private int fetchMaxValueAndSetIndexes(final int max, final int minValue, final int startIndex, final int endIndex) {
		if (minValue >= max) {
			indexes = Lists.newArrayList(startIndex, endIndex);
			return minValue;
		} 
		return max;
	}
}
