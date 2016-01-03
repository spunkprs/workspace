package com.prateek.junitconceptrevision;

import org.junit.Test;

public class JunitConceptRevision {
	
	//Advised not to use static variables in the test class and that too non final as they could be changed among different test cases and because of that results 
	//would be undesirable which is happening in this case.
	private static int counter = 0;
	
	public JunitConceptRevision() {
		counter++;
	}
	
	@Test
	public void testOne() {
		System.out.println("Value of counter :" + " "+ counter);
		
	}
	
	@Test
	public void testTwo() {
		System.out.println("Value of counter :" + " "+ counter);
	}
}
