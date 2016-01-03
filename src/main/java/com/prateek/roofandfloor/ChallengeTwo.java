package com.prateek.roofandfloor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChallengeTwo {

	private static int leftCounter = 0;
	private static int rightCounter = 0;
	private static int leftCounterSum = 0;
	private static int rightCounterSum = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int numberOfTestCases = Integer.parseInt(line);
		
		for (int i = 0; i < numberOfTestCases; i++) {
			String str = br.readLine();
			int numberOfPencils = Integer.parseInt(str);
			String pencilLengths[] = br.readLine().split(" ");
			int array[] = new int[numberOfPencils];
			parseAndFillArray(array, pencilLengths);
			leftCounter = 0;
			rightCounter = array.length - 1;
			leftCounterSum = array[0];
			rightCounterSum = array[array.length - 1];
			process(array);
		}
	}

	private static void parseAndFillArray(int[] array, String[] pencilLengths) {
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(pencilLengths[i]);
		}
	}

	private static void process(int array[]) {
		int i = leftCounter;
		int j = array.length - rightCounter;
		
		while ((i + j) != array.length) {
			if (leftCounterSum > rightCounterSum * 2) {
				rightCounter--;
				leftCounterSum = leftCounterSum - rightCounterSum * 2;
				rightCounterSum = array[rightCounter];
			} else if (leftCounterSum == rightCounterSum * 2) {
				leftCounter++;
				rightCounter--;
				leftCounterSum = array[leftCounter];
				rightCounterSum = array[rightCounter];
			} else if (leftCounterSum > rightCounterSum) {
				leftCounter++;
				rightCounterSum = rightCounterSum - (leftCounterSum / 2); 
				leftCounterSum = array[leftCounter];
			} else if (leftCounterSum == rightCounterSum) {
				leftCounter++;
				leftCounterSum = array[leftCounter];
				rightCounterSum  = rightCounterSum / 2;
			} else if (leftCounterSum < rightCounterSum) {
				leftCounter++;
				rightCounterSum = rightCounterSum - (leftCounterSum / 2);
				leftCounterSum = array[leftCounter];
			}
			
			i = leftCounter + 1;
			j = array.length - rightCounter;
		}
		System.out.print(i);
		System.out.print(" ");
		System.out.print(j);
	}
}
