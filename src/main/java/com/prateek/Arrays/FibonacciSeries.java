package com.prateek.Arrays;

import java.util.List;

import com.google.common.collect.Lists;

public class FibonacciSeries {
	private List<Integer> fibonacciList = null;
	
	public List<Integer> getFibonacciSeries(final int limit) {
		if (limit > 2) {
			fibonacciList = Lists.newArrayList(0, 1);
			prepareSeries(limit);
		}
		return fibonacciList;
	}

	private void prepareSeries(int limit) {
		int counter = fibonacciList.size();
		if (counter < limit) {
			int i = fibonacciList.size() - 1;
			int j = i - 1;
			fibonacciList.add(fibonacciList.get(j).intValue() + fibonacciList.get(i).intValue());
			counter++;
			prepareSeries(limit);
		}
	}
}
