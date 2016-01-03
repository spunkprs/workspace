package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*Responsible to write the data to the Output file.*/

public class Writer {
	
	private BufferedWriter bw;
	public void write(final String message) {
			try {
				bw = getInstanceOfBufferedWriter();
				bw.write(message);
				bw.newLine();
			} catch(IOException e) {
				
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
	
	public void closeStream() {
		try {
			bw = getInstanceOfBufferedWriter();
			bw.close();
		} catch(IOException e) {
		}
	}
}
