package com.prateek.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;

public class PairOfNumbersThatSumUpToANumber {
	
	private Set<Pair> pairs = Sets.newHashSet();
	
	public Set<Pair> getPairOfNumbersThatSumUpToANumber(final int arr[], final int number) {
		Arrays.sort(arr);
		Integer arrray[] = new Integer[arr.length];
		assignValues(arr, arrray);
		Arrays.sort(arrray, Collections.reverseOrder());
		
		findPairs(arr, arrray, number);
		return pairs;
	}

	private void findPairs(final int arr[], final Integer arrray[], final int number) {
         int i = 0;
         int j = 0;
         while (i < arrray.length && j < arr.length) {
        	 while (j < arr.length && i < arrray.length) {
        		 
        		 final int sumOfPair = arrray[i] + arr[j];
        		 if (sumOfPair == number) {
        			 pairs.add(new Pair(arrray[i], arr[j]));
        			 if (i+1 < arr.length && arrray[i] == arrray[i+1]) {
        				 i+=2;
        			 } else {
        				 i++;
        			 }
        		 } else if (sumOfPair > number) {
        			 if (i+1 < arr.length && arrray[i] == arrray[i+1]) {
        				 i+=2;
        			 } else {
        				 i++;
        			 }
        			
        		 } else if (sumOfPair < number) {
        			 if (j+1 < arr.length && arr[j] == arr[j+1]) {
        				 j+=2;
        			 } else {
        				 j++;
        			 }
        		 }
        	 }
         }
	}

	private void assignValues(int[] arr, Integer[] arrray) {
		for (int i = 0; i < arr.length; i++) {
			arrray[i] = arr[i];
		}
	}
}
