package com.prateek.thoughtworkscodingassignment;

import org.junit.Before;
import org.junit.Test;

public class ExecutorTest {

	private Executor executor;
	
	@Before
	public void setUp() {
		executor = new Executor();
	}
	
	@Test
	public void shouldReadFromFile() {
		executor.execute();
	}
}
