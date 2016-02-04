package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter extends Writer {
	
	private static OutputWriter outputWriter;
	
	protected OutputWriter() {
		
	}
	
	protected static OutputWriter getInstance() {
		if (outputWriter == null) {
			outputWriter = new OutputWriter();
			return outputWriter;
		} else {
			return outputWriter;
		}
	}

	private BufferedWriter bw;
	
	protected void write(final String message) {
			try {
				bw = getInstanceOfBufferedWriter();
				bw.write(message);
				bw.newLine();
				cleanUp();
			} catch(final IOException e) {
				e.printStackTrace();
			}
		}
	
	private BufferedWriter getInstanceOfBufferedWriter() {
			try {
				File file = new File(Files.OUTPUT.getFileName());
				bw = new BufferedWriter(new FileWriter(file, true));
			} catch(final IOException e) {
				//Log Exception
			}
			return bw;
	}
	
	private void cleanUp() {
		try {
			bw.close();
		} catch(IOException e) {
		}
	}
}
