package com.prateek.pramatahiringproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PramataChallengeOne {
	private static int arrayOne[];
	private static int arrayTwo[];
	private static int sumForEachSequence[];
	
	 public static void main(String[] args) throws IOException {
		
		 int a,b,c;
		 b = 10;
		 a = b = c = 20;
		 System.out.println(a);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
        String line = br.readLine();
        String arr[] = line.split(" ");
        int sizeOne = Integer.parseInt(arr[0]);
        int sizeTwo = Integer.parseInt(arr[1]);
        
        arrayOne = new int[sizeOne];
        arrayTwo = new int[sizeTwo];
        
        line = br.readLine();
        arr = line.split(" ");
        populateArray(arrayOne, arr);
        line = br.readLine();
        arr = line.split(" ");
        populateArray(arrayTwo, arr);
        
        String queries [] = new String[sizeTwo];
        generateQueries(queries, i, br);
        sumForEachSequence = new int[queries.length];
        
        findSumForEachSequence(queries);
        printOutput();
	}

	private static void printOutput() {
		for (int i = 0; i < sumForEachSequence.length; i++) {
			System.out.println(sumForEachSequence[i]);
		}
	}

	private static void findSumForEachSequence(String[] queries) {
		for (int i = 0; i < queries.length; i++) {
			String arr[] = queries[i].split(" ");
			populateSequence(arr, i);
		}
	}

	private static void populateSequence(String[] arr, int i) {
		final int startPoint = Integer.parseInt(arr[1]);
		final int endPoint = Integer.parseInt(arr[2]);
		
		if (startPoint <= arrayOne.length - 1 && endPoint <= arrayOne.length && startPoint <=endPoint) {
			if (Integer.parseInt(arr[0]) == 1) {
				populateUsing(true, startPoint, endPoint, i);
			} else if (Integer.parseInt(arr[0]) == 2) {
				populateUsing(false, startPoint, endPoint, i);
			}
		} else {
			sumForEachSequence[i] = 0;
		}
	}

	private static void populateUsing(boolean flag, int startPoint, int endPoint, int i) {
		int sum = 0;
		int j = startPoint - 1;
		int datum = populateDatum(endPoint);
		
		
		while(j < datum) {
			if (flag && j + 1 < datum) {
				sum += arrayOne[j] + arrayTwo[j + 1];
			} else if (flag && j == datum - 1){
				sum += arrayOne[j];
			}
			
			if (!flag && j + 1 < datum) {
				sum += arrayTwo[j] + arrayOne[j + 1];
			} else if (!flag && j == datum - 1) {
				sum += arrayTwo[j];
			}
			j+=2;
		}
		sumForEachSequence[i] = sum;
	}

	private static int populateDatum(int endPoint) {
		return endPoint >= arrayOne.length ? arrayOne.length : endPoint;
	}

	private static void generateQueries(String[] queries, int i, BufferedReader br) throws IOException {
		while (i < queries.length) {
			String line = br.readLine();
			queries[i] = line;
			i++;
		}
	}

	private static void populateArray(int[] array, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
	}

}


abstract class One {
	 void func() {
		 
	 }
}