package com.hackerrank.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;

import org.junit.Test;

public class CircleCityTest {

	@Test
	public void testCircleCity() throws IOException {
		
		// Set Up && Reading input from file
		BufferedReader outputReader = new BufferedReader(new FileReader("/Users/singhpr/Documents/Circle City/Output 1.txt"));
		BufferedReader inputReader = new BufferedReader(new FileReader("/Users/singhpr/Documents/Circle City/Input 1.txt"));
		String input = inputReader.readLine();
		final int inputlength = Integer.parseInt(input);
		
		final String inputArr[] = new String[inputlength];
		final String outputExpectedArr[] = new String[inputlength];
		final String outputArr[] = new String[inputlength];
		
		input = inputReader.readLine();
		
		readInputFromFile(inputArr, inputReader, input);
		readInputFromFile(outputExpectedArr, outputReader, null);
		
		//Execute
		
		/*
		for (int i = 0; i < inputlength; i++) {
			outputArr[i] = CircleCity.process(inputArr[i].split(" "));
		}
		*/
		//Verify
		verify(outputExpectedArr, outputArr);
		
	}

	private void verify(final String[] outputExpectedArr, final String[] outputArr) {
		Assert.assertEquals(outputExpectedArr.length, outputArr.length);
		
		for (int i = 0; i < outputExpectedArr.length; i++) {
			System.out.println(i);
			Assert.assertEquals(outputExpectedArr[i], outputArr[i]);
		}
	}

	private void readInputFromFile(String[] arr, BufferedReader reader, String input) throws IOException {
		if (input == null) {
			input = reader.readLine();
		}
		int counter = 0;
		while(input != null) {
			arr[counter] = input;
			input = reader.readLine();
			counter++;
		}
	}
}
