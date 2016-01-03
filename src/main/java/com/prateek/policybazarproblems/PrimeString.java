package com.prateek.policybazarproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeString {

	private static int arr[] = new int[26];
	private static int distinctAlphates = 0;
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
		parse(array);
		return isPrimeNumber(distinctAlphates) && checkForPrimeOccurenceOfEachAlphabet();
	}

	private static boolean checkForPrimeOccurenceOfEachAlphabet() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (!isPrimeNumber(arr[i])) {
					return false;
				}
			}
		}
		return true;
	}

	private static void parse(final char[] array) {
		int headIndex = 0;
		int tailIndex = array.length - 1;
		while(headIndex <= tailIndex) {
			int i = array[headIndex] - 97;
			int j = array[tailIndex] - 97;
			if (i == j) {
				int occurence = arr[i];
				if(occurence == 0) {
					  distinctAlphates++;
				  }
				
				if(headIndex != tailIndex) {
					occurence +=2;
				} else {
					occurence++;
				}
				
				headIndex++;
				tailIndex--;
				arr[i] = occurence;
			} else {
				int occurenceOne = arr[i];
				int occurenceTwo = arr[j];
				
				if(occurenceOne == 0) {
					  distinctAlphates++;
				  }
				
				if(occurenceTwo == 0) {
					  distinctAlphates++;
				  }
				
				headIndex++;
				tailIndex--;
				occurenceOne++;
				occurenceTwo++;
				arr[i] = occurenceOne;
				arr[j] = occurenceTwo;
			}
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
