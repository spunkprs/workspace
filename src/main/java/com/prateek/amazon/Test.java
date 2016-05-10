package com.prateek.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test {
	
	static int arr[];
	static Map<Pair<Integer>, Integer> mapOne = new HashMap<Pair<Integer>, Integer>();
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
				sum += computeGCD(i, number);
			}
			mapTwo.put(number, sum);
			return sum;
		}
	}

	private static void populateArrayElements(String[] elements, int size, int arr[]) {
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(elements[i]);
		}
	}
	
	private static int computeGCD(final int a, final int b) {
		final Pair<Integer> p = new Pair<Integer>(a, b);
		if (mapOne.containsKey(p)) {
			return mapOne.get(p);
		} else {
			int gcd = findGCD(a, b);
			mapOne.put(p, gcd);
			return gcd;
		}
	}
	
	private static int findGCD(final int a, final int b) {
			if(b == 0) { 
				return a; 
			} 
			return findGCD(b, a % b);
	}
	
	static class Pair<Integer> {
		private Integer x;
		private Integer y;
		
		public Pair(final Integer a, final Integer b) {
			this.x = a;
			this.y = b;
		}
		
		public int hashCode() {
			return this.x.hashCode() * this.y.hashCode();
		}
		
		public boolean equals(Object obj) {
			final Pair<Integer> p = (Pair<Integer>)obj;
			if (this.x.equals(p.x) && this.y.equals(p.y)) {
				return true;
			} else if (this.x.equals(p.y) && this.y.equals(p.x)) {
				return true;
			}
			return false;
		}
	}
}
