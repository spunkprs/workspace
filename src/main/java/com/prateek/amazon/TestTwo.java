package com.prateek.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestTwo {

	static int arr[];
	static Map<Integer, Integer> mapTwo = new HashMap<Integer, Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int size = Integer.parseInt(line);
		
		 arr = new int[size];
		
		String arrayElements = br.readLine();
		String elements [] = arrayElements.split(" ");
		
		populateArrayElements(elements, size, arr);
		int numberOfQueries = Integer.parseInt(br.readLine());
		
        for (int i = 0; i < numberOfQueries; i++) {
        	String query = br.readLine();
        	processQuery(query);
        }
	}
	
	private static void processQuery(final String query) {
		final String queryDetails[] = query.split(" ");
		if ("C".equals(queryDetails[0])) {
			int source = Integer.parseInt(queryDetails[1]);
			int destination = Integer.parseInt(queryDetails[2]);
			System.out.println(process(source, destination));
		} else if ("U".equals(queryDetails[0])) {
			int index = Integer.parseInt(queryDetails[1]);
			int value = Integer.parseInt(queryDetails[2]);
			arr[index - 1] = value;
		}
	}
	
	private static int process(final int source, final int destination) {
		int sumCalculatedFromProcessOfComputation = 0;
		for (int i = source; i <= destination; i++) {
			sumCalculatedFromProcessOfComputation += applyFunctionToCalculateGCD(arr[i - 1]);
		}
		return sumCalculatedFromProcessOfComputation;
	}
	
	private static int applyFunctionToCalculateGCD(final int number) {
		if (mapTwo.containsKey(number)) {
			return mapTwo.get(number);
		} else {
			int sum = 0;
			for (int i = 1; i <= number; i++) {
				sum += findGCD(i, number);
			}
			mapTwo.put(number, sum);
			return sum;
		}
	}
	
	private static int findGCD(final int a, final int b) {
		if(b == 0) { 
			return a; 
		} 
		return findGCD(b, a % b);
}
	
	private static void populateArrayElements(String[] elements, int size, int arr[]) {
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(elements[i]);
		}
	}
}
