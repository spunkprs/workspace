package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*Execution starts from here.
 * It reads input statements from file. 
 * */

public class Executor {

	private IFileProcessorDelegator fileProcessorDelegator;
	
	public Executor(final IFileProcessorDelegator fileProcessorDelegator) {
		this.fileProcessorDelegator = fileProcessorDelegator;
	}
	
	public void execute(final String fileName) {
		try {
			final BufferedReader br = new BufferedReader(new FileReader(fileName));
			process(br);
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void process(final BufferedReader br) {
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
