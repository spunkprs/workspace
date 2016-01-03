package com.prateek.Arrays;

import java.util.Arrays;
import java.util.Set;

import com.google.common.collect.Sets;

public class PairOfNumbersThatSumUpToCommonNumber {

	private Set<Pair> pairs = Sets.newHashSet();
	private Pair tempPair = null; 
	private boolean flag = true;
	
	public Set<Pair> getPairOfNumbersThatSumUpToACommonNumber(final int arr[]) {
		Arrays.sort(arr);
		findAndAddPairs(arr);
		return pairs;
	}
	
	private void findAndAddPairs(final int[] arr) {
		int i = 0;
		int j = arr.length-1;
		while (j >= 0) {
			while(i < arr.length) {
				flag = true;
				
				Pair pair = new Pair(arr[j], arr[i]);
				boolean fl = pairs.contains(pair) ? false : true; 
				
				if (j != i && fl && i < arr.length - 1 && j > 0)
				findPairs(i, j-1, arr, pair);
				
				if(i < arr.length - 1 && arr[i] == arr[i+1])  {
					i+=2;
				} else {
					i++;
				}
			}
			i = 0;
			if (j >= 1 && arr[j] == arr[j-1]) {
				j-=2;
			} else {
				j--;
			}
		}
	}

	private void findPairs(int i, int j, final int[] arr, final Pair pair) {
		int counter = 1;
		pairs.add(pair);
		tempPair = new Pair(arr[j], arr[i]);
		int sumofConcernedPair = pair.getFirst() + pair.getSecond();
			while(i < arr.length && j >=0 && !pair.equals(tempPair) && flag) {
				if (j != i) {
					int sumOfPair = tempPair.getFirst() + tempPair.getSecond();
					
					if (sumOfPair < sumofConcernedPair) {
						if (i < arr.length - 1 && arr[i] == arr[i+1]) {
							i+=2;
						} else {
							i++;
						}
					} else if (sumOfPair == sumofConcernedPair) {
						if (doesNotContain()) {
							pairs.add(tempPair);
							counter++;
							j--;
						} else {
							break;
						}
						
					} else {
						if (j >= 1 && arr[j] == arr[j-1]) {
							j-=2;
						} else {
							j--;
						}
					}
				} else {
					if (tempPair.getFirst() + tempPair.getSecond() >= sumofConcernedPair) {
						j--;
					} else {
						i++;
					}
				}
				if (i < arr.length && j >=0)
				tempPair = new Pair(arr[j], arr[i]);
			}
		if (counter == 1)
			pairs.remove(pair);
	}

	private boolean doesNotContain() {
		if (pairs.contains(tempPair)) {
			flag = false;
		}
		return flag;
	}
}
