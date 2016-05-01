package com.prateek.IdeasQuestionOne;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	
	private Processor processor;
	
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

	private void writeDataToFile(final List<String> serversWithOldVersionOfSoftwares) {
		
	}

	private void readDataFromFileAndProcess() throws IOException, FileNotFoundException {
		final List<String> input = new ArrayList<String>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("Input.txt"));
		
		String currentLine = null;
		while((currentLine = bufferedReader.readLine()) != null) {
			input.add(currentLine);
		}
		processor.process(input);
	}
	
}
