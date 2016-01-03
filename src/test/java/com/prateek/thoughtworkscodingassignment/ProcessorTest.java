package com.prateek.thoughtworkscodingassignment;

import org.junit.Before;
import org.junit.Test;

/*Integration test to check end to end workflow right from reading the input file processing the data and printing the output according to the queries asked.*/

public class ProcessorTest {
	
	private Processor unit;
	
	@Before
	public void setUp() {
		unit = new Processor();
	}
	
	@Test
	public void shouldReadInputFromFileAndWriteOutputToFile() {
		//Set Up , Execute && Verify
		unit.process();
	}
}
