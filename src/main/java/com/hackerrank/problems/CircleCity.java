package com.hackerrank.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircleCity {

	public static void main(final String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();
		
		final int testCases = Integer.parseInt(input);
		for (int i = 1; i <= testCases; i++) {
			process(br.readLine().split(" ")); 
		}
	}

	private static void process(String[] arr) {
		final double radius = Math.sqrt(Long.parseLong(arr[0]));
		final long expectedNumberOfPoliceStations = Long.parseLong(arr[1]);
		final long computedRadius = (long)radius;
        long actualNumberOfPoliceStations = 0;
		
			for (long i = 1; i <= computedRadius; i++) {
				if (isIntegerPointLyingOnCircle(Long.parseLong(arr[0]), i)) {
					actualNumberOfPoliceStations++;
				}
			}
			
			if (isPerfectSquare(Long.parseLong(arr[0]))) {
				actualNumberOfPoliceStations = actualNumberOfPoliceStations * 4 + 4;
			} else {
				actualNumberOfPoliceStations = actualNumberOfPoliceStations * 4;
			}
			
		if (expectedNumberOfPoliceStations >= actualNumberOfPoliceStations) {
			System.out.println("possible");
		} else {
			System.out.println("impossible");
		}
	}

	private static boolean isIntegerPointLyingOnCircle(final double squareOfRadius, final long abcissa) {
		final long squareOfOrdinate = (long)(squareOfRadius - abcissa * abcissa);
		final long ordinate = (long)Math.sqrt(squareOfOrdinate);
		if (squareOfOrdinate == 0) {
			return false;
		}
		return isPerfectSquare(squareOfOrdinate) && ordinate <= (long)Math.sqrt(squareOfRadius) ? true : false;
	}

	private static boolean isPerfectSquare(long squareOfOrdinate) {
		final long ordinate = (long)Math.sqrt(squareOfOrdinate);
		return ordinate * ordinate == squareOfOrdinate ? true : false; 
	}
}
