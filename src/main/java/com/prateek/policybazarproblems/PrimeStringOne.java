package com.prateek.policybazarproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeStringOne {

	private static boolean flag = true;
	private static int totalDistinctOccurence = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int numberOfTestCases = Integer.parseInt(line);
        final String input[] = new String[numberOfTestCases];
        
        for (int i = 0; i < numberOfTestCases; i++) {
        	final String st = br.readLine();
        	input[i] = st;
        }
        checkForEachInput(input);
	}
	
	
	private static void checkForEachInput(String[] input) {
		for (int i = 0; i < input.length; i++) {
			printDesiredOutput(input[i]);
		}
	}

	private static void printDesiredOutput(final String str) {
		if (isPrimeString(str)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	private static boolean isPrimeString(String str) {
		char array[] = str.toCharArray();
		Arrays.sort(array);
		parse(array);
		return flag && isPrimeNumber(totalDistinctOccurence);
	}


	private static void parse(char[] array) {
		int i = 0;
		int occurenceOfEachAlphabet = 1;
		while (i < array.length - 1) {
			if (array[i] == array[i+1]) {
				occurenceOfEachAlphabet++;
			} else {
				if (!isPrimeNumber(occurenceOfEachAlphabet)) {
					flag = false;
				} else {
					occurenceOfEachAlphabet = 1;
				}
				totalDistinctOccurence++;
			}
			if (!flag) {
				break;
			}
			i++;
		}
		if (!isPrimeNumber(occurenceOfEachAlphabet)) {
			flag = false;
		}
	}
	
	private static boolean isPrimeNumber(final int number) {
		if (number == 1) {
			return false;
		}
		
		 int sqrt = (int) Math.sqrt(number) + 1;
	        for (int i = 2; i < sqrt; i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	}
}
