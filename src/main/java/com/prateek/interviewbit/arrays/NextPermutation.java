package com.prateek.interviewbit.arrays;

import java.util.Collections;
import java.util.List;

public class NextPermutation {
	
	private boolean flag = false;
	
	public List<Integer> nextPermutation(final List<Integer> a) {
		processNextPermutation(a);
		if (!flag) {
			Collections.sort(a);
		}
		return a;
	}

	private void processNextPermutation(final List<Integer> a) {
		int pivot = -1;
		int index = -1;
		for (int i = a.size() - 1; i >= 1; i--) {
			if (a.get(i) > a.get(i - 1)) {
				pivot = i - 1;
				index = findElementIndexGreaterThanElementAtPivot(pivot, a);
				if (index!= -1) {
					Collections.swap(a, index, pivot);
				}
				process(i, a);
				flag = true;
				break;
			}
		}
	}

	private int findElementIndexGreaterThanElementAtPivot(final int pivot, final List<Integer> a) {
		int index = -1;
		for (int i = a.size() - 1; i > pivot; i--) {
			if (a.get(i) > a.get(pivot)) {
				index = i;
				break;
			}
		}
		return index;
	}

	private void process(final int index, final List<Integer> a) {
		for (int i = index; i < a.size() - 1; i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i) > a.get(j)) {
					Collections.swap(a, i, j);
				}
			}
		}
	}
}
