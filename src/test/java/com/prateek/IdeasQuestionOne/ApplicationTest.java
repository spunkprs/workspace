package com.prateek.IdeasQuestionOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ApplicationTest {
	
	private Application application;
	
	private static final String SERVER_TWO = "Server2";
	private static final String SERVER_THREE = "Server3";
	private static final String OUTPUT_FILE = "Output_Ideas.txt";
	
	@Before
	public void setUp() {
		application = new Application();
	}

	@Test
	public void shouldReadFromInputFileAndWriteToOutputFile() {
		try {
			final List<String> expectedOutput = new ArrayList<String>();
			expectedOutput.add(SERVER_TWO);
			expectedOutput.add(SERVER_THREE);
			
			clearContentOfOutputFile();
			application.execute();
			
			verify(expectedOutput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void verify(final List<String> expectedOutput) throws IOException {
		final List<String> actualOutput = readDataFromFile();
		
		Assert.assertEquals(expectedOutput.size(), actualOutput.size());
		for (String serverName : expectedOutput) {
			Assert.assertTrue(actualOutput.contains(serverName));
		}
	}

	private List<String> readDataFromFile() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(OUTPUT_FILE));
		final List<String> output = new ArrayList<String>();
		
		String currentLine = null;
		while((currentLine = bufferedReader.readLine()) != null) {
			output.add(currentLine);
		}
		return output;
	}

	private void clearContentOfOutputFile() throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
		bufferedWriter.write("");
		bufferedWriter.close();
	}
}
