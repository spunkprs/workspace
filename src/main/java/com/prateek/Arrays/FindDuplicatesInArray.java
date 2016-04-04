package com.prateek.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

public class FindDuplicatesInArray {
	
	public Set<Integer> findDuplicates(final int arr[]) {
		//final List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
		//Integer ar[] = (Integer[])list.toArray();
		return fetchDuplicates(arr);
	}

	private Set<Integer> fetchDuplicates(final int[] arr) {
		final Set<Integer> duplicates = new HashSet<Integer>();
		int frequencyOfZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (arr[Math.abs(arr[i])] > 0) {
					arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
				} else {
					duplicates.add(Math.abs(arr[i]));
				}
			} else {
				frequencyOfZero++;
			}
		}
		addZeroToList(duplicates, frequencyOfZero);
		return duplicates;
	}
	
	/*
	public int repeatedNumber(final List<Integer> a) {
	    Integer arr[] = a.toArray(new Integer[a.size()]);
	    int index = -1;
	    for (int i = 0; i < arr.length; i++) {
				if (arr[Math.abs(arr[i])] > 0) {
					arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
				} else {
				    index = i;
				    break;
				}
		}
		return Math.abs(arr[index]);
	}
	*/

	private void addZeroToList(final Set<Integer> duplicates, final int frequencyOfZero) {
		if (frequencyOfZero > 1) {
			duplicates.add(0);
		}
	}
}
