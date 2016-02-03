package com.prateek.thoughtworkscodingassignment;

import org.junit.Test;

import org.junit.Assert;
import java.util.List;

public class FileProcessorDelegatorTest {

	@Test
	public void shouldGiveSingleInstance() {
		FileProcessorDelegator fileProcessorDelegatorOne = FileProcessorDelegator.getInstance();
		FileProcessorDelegator fileProcessorDelegatorTwo = FileProcessorDelegator.getInstance();
		Assert.assertTrue(fileProcessorDelegatorOne == fileProcessorDelegatorTwo);
	}
	
	@Test
	public void delegatorInstanceShallHaveFileProcessors() {
		FileProcessorDelegator fileProcessorDelegator = FileProcessorDelegator.getInstance();
		
		final List<FileProcessor> processors = fileProcessorDelegator.getProcessors();
		
		Assert.assertEquals(3, processors.size());
		Assert.assertTrue(processors.get(0) instanceof FileProcessorSectionOne);
		Assert.assertTrue(processors.get(1) instanceof FileProcessorSectionTwo);
		Assert.assertTrue(processors.get(2) instanceof FileProcessorSectionThree);
	}
}
