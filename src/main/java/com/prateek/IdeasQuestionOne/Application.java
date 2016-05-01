package com.prateek.IdeasQuestionOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	
	private Processor processor;
	
	private static final String INPUT_FILE = "Input_Ideas.txt";
	private static final String OUTPUT_FILE = "Output_Ideas.txt";
	
	
	public void execute() {
		processor = new Processor();
		try {
			readDataFromFileAndProcess();
			writeDataToFile(processor.fetchServersWithOldVersionOfSoftwares());
		}
		catch(FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}

	private void writeDataToFile(final List<String> serversWithOldVersionOfSoftwares) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE));
		for (String serverName : serversWithOldVersionOfSoftwares) {
			bufferedWriter.write(serverName);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}

	private void readDataFromFileAndProcess() throws IOException, FileNotFoundException {
		final List<String> input = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_FILE));
		
		String currentLine = null;
		while((currentLine = bufferedReader.readLine()) != null) {
			input.add(currentLine);
		}
		processor.process(input);
	}
	
}
