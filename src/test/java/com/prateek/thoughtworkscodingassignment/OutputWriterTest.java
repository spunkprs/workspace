package com.prateek.thoughtworkscodingassignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;

public class OutputWriterTest {

	private static final int NEW_LINE_CHARACTER = 10;
	private OutputWriter writer;
	private File file;
	
	@Before
	public void setUp() {
		writer = OutputWriter.getInstance();
		clearFileContents();
	}
	
	private void clearFileContents() {
		file = new File(Files.OUTPUT.getFileName());
		try {
			final FileWriter fw = new FileWriter(file);
			fw.write("");
			fw.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldWriteMessageToFileCaseOne() {
		final String expectedMessage = "Printing first time";
		writer.write(expectedMessage);
		
		final String actualMessage = readFromFile();
		
		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	public void shouldWriteMessageToFileCaseTwo() {
		final String expectedMessage = "Printing second time";
		writer.write(expectedMessage);
		
		final String actualMessage = readFromFile();
		
		Assert.assertTrue(expectedMessage.equals(actualMessage));
	}
	
	private String readFromFile() {
		String actualMessage = "";
		FileReader fr;
		try {
			fr = new FileReader(file);
			int i;
			while((i = fr.read()) != -1) {
				Character ch = (char)i;
				if (i != NEW_LINE_CHARACTER) {
					actualMessage += ch.toString();
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(final IOException e) {
			e.printStackTrace();
		}
		return actualMessage;
	}
}
