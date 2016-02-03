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
				closeStream();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} 
		
	private BufferedWriter getInstanceOfBufferedWriter() {
		if (null != bw) {
			return bw;
		} else {
			try {
				File file = new File(Files.OUTPUT.getFileName());
				bw = new BufferedWriter(new FileWriter(file));
			} catch(IOException e) {
			}
			return bw;
		}
	}
	
	private void closeStream() {
		try {
			bw = getInstanceOfBufferedWriter();
			bw.close();
		} catch(IOException e) {
		}
	}
}
