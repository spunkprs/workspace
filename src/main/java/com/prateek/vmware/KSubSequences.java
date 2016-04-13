package com.prateek.vmware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSubSequences {

	private int counter = 0;
	public int countOfKSubSequences(final int arr[], int kSubsequence) {
		process(arr, kSubsequence);
		return counter;
	}

	private void process(int[] arr, int kSubsequence) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = arr.length - 1; i >=0 ; i--) {
			
			if (i != arr.length - 1) {
				final List<Integer> listOfSumsFromPreviousIndex = map.get(i + 1);
				final List<Integer> sum = new ArrayList<Integer>();
				for (int s : listOfSumsFromPreviousIndex) {
					sum.add(s + arr[i]);
					checkForSubSequence(kSubsequence, s + arr[i]);
				}
				sum.add(arr[i]);
				checkForSubSequence(kSubsequence, arr[i]);
				map.put(i, sum);
			} else {
				final List<Integer> sum = new ArrayList<Integer>();
				sum.add(arr[i]);
				map.put(i, sum);
			}
		}
	}

	private void checkForSubSequence(int kSubsequence, int sum) {
		if (sum % kSubsequence == 0) {
			counter++;
		}
	}
}
