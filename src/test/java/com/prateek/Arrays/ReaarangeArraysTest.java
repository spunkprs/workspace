package com.prateek.Arrays;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ReaarangeArraysTest {
	
	private Box input;
	private ReaarangeArray reaarangeArray;

	@Before
	public void setUp() {
		reaarangeArray = new ReaarangeArray();
	}
	
	@Test
	public void shouldReaarangeArraysWithAlternatePositiveAndNegativeIntegers() {
		//Execute
		Assert.assertNull(reaarangeArray.reArrangeArrayWithAlternatePositiveAndNegativeIntegers(input.getInput()));
	}
	
	public ReaarangeArraysTest(final Box input) {
		this.input = input;
	}
	
	@Parameters
	public static Collection<Box[]> input() {
		return Arrays.asList(new Box[][]{{ new Box(new Integer[]{1, 2, 3, -4, -1, 4}, new Integer[]{-4, 1, -1, 2, 3, 4})}, { new Box(new Integer[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}, 
				new Integer[]{-5, 5, -2, 2, -8, 4, 7, 1, 8, 0})}});
	}
	
	private static class Box {
		private final Integer[] input;
		private final Integer[] result;
		
		public Box(final Integer[] input, final Integer[] result) {
			this.input = input;
			this.result = result;
		}

		public Integer[] getInput() {
			return input;
		}

		public Integer[] getResult() {
			return result;
		}
	}
}
