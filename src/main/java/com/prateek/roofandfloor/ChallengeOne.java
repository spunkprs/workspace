package com.prateek.roofandfloor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChallengeOne {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		final int input = Integer.parseInt(line);
		int arr[] = new int[input];
		
		for (int i = 0; i < arr.length; i++) {
			String str = br.readLine();
			arr[i] = Integer.parseInt(str);
		}
		
		System.out.println(process(arr));
	}

	private static int process(int[] arr) {
		int rating = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				rating += arr[i];
			} else if (arr[i] == 0) {
				rating -= arr[i - 1];
			} else {
				rating += arr[i];
			}
		}
		return rating;
	}
}
