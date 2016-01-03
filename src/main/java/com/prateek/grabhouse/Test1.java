package com.prateek.grabhouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

	private static Map<Integer, Integer> map = new HashMap();
	private static int product = 1;
	
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
			if (i == 0) {
				process(arr, i);
				map.put(i, product);
			} else {
				product = map.get(i - 1) * 1 / arr[i] * arr[i - 1];
				map.put(i, product);
				System.out.print(product);
				System.out.print(" ");
			}
		}
	}
	
	private static void process(int[] arr, int i) {
		for (int j = 0; j < arr.length; j++) {
			if (j != i) {
				product*= arr[j];
			}
		}
		System.out.print(product);
		System.out.print(" ");
	}

}
