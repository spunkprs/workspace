package com.prateek.thoughtworkscodingassignment;

import org.junit.Before;
import org.junit.Test;

//Integration test

public class IntegrationTest {

	private Executor executor;
	
	@Before
	public void setUp() {
		executor = new Executor(FileProcessorDelegator.getInstance());
	}
	
	@Test
	public void integrationTest() {
		executor.execute(Files.INPUT.getFileName());
	}
}
