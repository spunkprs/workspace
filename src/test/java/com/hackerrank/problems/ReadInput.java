package com.hackerrank.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInput {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		final int testCases = Integer.parseInt(input);
		for (int i = 1; i <= testCases; i++) {
			System.out.println(br.readLine());
		}
	}

}
