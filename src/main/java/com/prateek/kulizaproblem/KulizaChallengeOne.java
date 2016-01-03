package com.prateek.kulizaproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KulizaChallengeOne {

	private static int diffOne = 0;
	private static int diffTwo = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int numberOfCheckPoints = Integer.parseInt(line);
		final String arr1[] = br.readLine().split(" ");
		final String arr2[] = br.readLine().split(" ");
		
		int arr3[] = new int[numberOfCheckPoints];
		int arr4[] = new int[numberOfCheckPoints];
		populate(arr1, arr3);
		populate(arr2, arr4);
		processOne(arr3);
		processTwo(arr4);
		if (diffOne > diffTwo) {
			System.out.println("Dom");
			System.out.println(diffOne);
		} else if (diffTwo > diffOne) {
			System.out.println("Brian");
			System.out.println(diffTwo);
		} else {
			System.out.println("Tie");
			System.out.println(diffOne);
		}
	}

	private static void processTwo(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				int diff = array[i] - array[i + 1];
				if (diff > diffTwo) {
					diffTwo = diff;
				}
			} else {
				int diff = array[i + 1] - array[i];
				if (diff > diffTwo) {
					diffTwo = diff;
				}
			}
		}
	}

	private static void processOne(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				int diff = array[i] - array[i + 1];
				if (diff > diffOne) {
					diffOne = diff;
				}
			} else {
				int diff = array[i + 1] - array[i];
				if (diff > diffOne) {
					diffOne = diff;
				}
			}
		}
	}

	private static void populate(String[] arrayOne, int[] arrayTwo) {
		for (int i = 0; i < arrayOne.length; i++) {
			arrayTwo[i] = Integer.parseInt(arrayOne[i]);
		}
	}
}
