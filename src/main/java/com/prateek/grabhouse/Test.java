package com.prateek.grabhouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		int arr[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String in[] = input.split(" ");
		arr = new int[in.length];
		
		for (int i = 0; i < in.length; i++) {
			arr[i] = Integer.parseInt(in[i]);
		}
		
		parseArray(arr);
	}

	private static void parseArray(final int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			process(arr, i);
		}
	}

	private static void process(int[] arr, int i) {
		int product = 1;
		for (int j = 0; j < arr.length; j++) {
			if (j != i) {
				product*= arr[j];
			}
		}
		System.out.print(product);
		System.out.print(" ");
	}
}
