package com.prateek.WalmartLabExam;

import org.junit.Assert;

import org.junit.Test;

public class CandidateCodeTest {
	
	@Test
	public void shouldFindMaxProfit1() {
		//Set Up && Execute && Verify
		Assert.assertEquals(2000, CandidateCode.jobMachine(createInputData()));
	}

	private String[] createInputData() {
		final String[] input = {"2PM#4PM", "6AM#8AM", "7AM#10AM", "7AM#8AM", "8AM#9AM", "10AM#12PM", "1PM#4PM", "11AM#1PM"};
		return input;
	}
}
