package com.prateek.thoughtworkscodingassignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class ExecutorTest {

	private Executor executor;
	private MockFileProcessorDelegator fileProcessorDelegator;
	
	@Before
	public void setUp() {
		fileProcessorDelegator = new MockFileProcessorDelegator(); 
		executor = new Executor(fileProcessorDelegator);
	}
	
	@Test
	public void shouldReadFromFile() throws Exception {
		final String filename = "test.txt";
		File newFile = new File(filename);
		newFile.createNewFile();
		executor.execute(filename);
		newFile.delete();
	}

	@Test
	public void shouldDelegateLineProcessingToDelegator() {
		BufferedReader br = new BufferedReader(new StringReader("abcd\nefgh\nijk"));
		executor.process(br);
		Assert.assertEquals(3, fileProcessorDelegator.getLineCount());
		Assert.assertEquals("abcd", fileProcessorDelegator.getLine(0));
		Assert.assertEquals("efgh", fileProcessorDelegator.getLine(1));
		Assert.assertEquals("ijk", fileProcessorDelegator.getLine(2));
	}
	
	private static class MockFileProcessorDelegator implements IFileProcessorDelegator {
		private List<String> lines = new ArrayList<String>();
		public void delegate(final String line) {
			lines.add(line);
		}
		public String getLine(int index) {
			return lines.get(index);
		}
		public int getLineCount() {
			return lines.size();
		}
	}
}
