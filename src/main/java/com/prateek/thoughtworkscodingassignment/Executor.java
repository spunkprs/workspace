package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*Execution starts from here.
 * It reads input statements from file. 
 * */

public class Executor {

	public void execute() {
		try {
			final BufferedReader br = new BufferedReader(new FileReader(Files.INPUT.getFileName()));
			process(br);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void process(final BufferedReader br) {
		final FileProcessorDelegator fileProcessorDelegator = FileProcessorDelegator.getInstance();
		try {
			String line = br.readLine();
			while(line != null) {
				fileProcessorDelegator.delegate(line);
				line = br.readLine();
			}
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
