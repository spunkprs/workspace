package com.prateek.kulizaproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

public class KulizaChallengeTwo {

	private static int calculatedValue = 1;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		final int input = Integer.parseInt(line);
		
		for (int i = 0; i < input; i++) {
			String str = br.readLine();
			String strArray[] = str.split(" ");
			int inputOne = Integer.parseInt(strArray[0]);
			int inputTwo = Integer.parseInt(strArray[1]);
			int inputArray[] = new int[inputOne];
			String inputArr[] = br.readLine().split(" ");
			parseAndFill(inputArray, inputArr);
		}
		
		int arr[] = new int[10]; 
		process(arr);
	}

	private static void parseAndFill(int[] inputArray, String[] inputArr) {
		for (int i = 0; i < inputArr.length; i++) {
			inputArray[i] = Integer.parseInt(inputArr[i]);
		}
	}

	private static void process(int[] arr) {
		int computedVaue = 0;
		for (int i = 0; i < arr.length; i++) {
			
			if (i == 0) {
			computedVaue = compute(i, arr, arr[i]);
			calculatedValue = computedVaue;
			}
			
			if (i != 0) {
				computedVaue = compute(i, arr, arr[i]);
				if (computedVaue < calculatedValue) {
					calculatedValue = computedVaue;
				}
			}
			
		}
	}

	private static int compute(int j, int[] arr, int element) {
		int computedValue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != j) {
				if (arr[i] > arr[j]) {
					computedValue += (arr[i] - arr[j]) * 5;
				} else if (arr[i] < arr[j]) {
					computedValue += (arr[i] - arr[j]) * 3;
				}
			}
		}
		return computedValue;
	}

}

class FetchPattern {
	private Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
	
	public List<List<Integer>> fetchSubSequences(final int array[]) {
		final List<List<Integer>> subSequences = Lists.newArrayList();
		return fetch(array, subSequences);
	}
	
	private List<List<Integer>> fetch(int array[], List<List<Integer>> subSequences) {
		process(array, subSequences);
		return subSequences;
	}
	
	private void process(int[] arr, List<List<Integer>> subSequences) {
		
		for (int i = arr.length - 1; i >= 0; i--) {
			List<Integer> l = new ArrayList<Integer>();
			if (i == arr.length - 1) {
				int element = arr[arr.length - 1];
				l.add(element);
				subSequences.add(l);
				map.put(i, subSequences);
			} else {
				l = new ArrayList<Integer>();
				l.add(arr[i]);
				updateListAndMap(subSequences, arr[i], i, arr.length);
				subSequences.add(l);
				map.put(i, subSequences);
			}
		}
	}
	
	private void updateListAndMap(final List<List<Integer>> subSequences, final int element, final int position, int length) {
		for (int i = position + 1 ; i < length; i++) {
			for (List<Integer> list : getListOfNumbersFromNextPosition(i)) {
				List<Integer> l = new ArrayList<Integer>(list);
				l.add(element);
				subSequences.add(l);
				map.put(position, subSequences);
			}
		}
	}
	
	private List<List<Integer>> getListOfNumbersFromNextPosition(int i) {
		return map.get(i);
	}
}
