package com.prateek.Permutation;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class GeneratePermutationsTest {
	private GeneratePermutations unit;
	private Factorial factorial;
	private ComputePermutation cp;
	
	@Before
	public void setUp() {
		unit = new GeneratePermutations();
		factorial = new Factorial();
		cp = new ComputePermutation();
	}
	
	@Test
	public void shouldGeneratePermutations() {
		//Set Up && Execute
		
		final String inputString = "gil";
		final int expectedPermutations = cp.computePermutations(inputString);
		final List<String> permutations = unit.generatePermutations(inputString);
		for (final String str : permutations) {
			System.out.println(str);
		}
		Assert.assertEquals(expectedPermutations, permutations.size());
	}
	
	private class ComputePermutation {
		
		private Map<Character, Box> map = Maps.newHashMap();
		private boolean flag;
		
		private int computePermutations(final String word) {
			for (Character ch : word.toCharArray()) {
				Box box = map.get(ch);
				if (box != null) {
					flag = true;
					box.setFrequency(box.getFrequency() + 1);
					box.setFactorial(box.getFrequency());
				} 
				else {
					map.put(ch, new Box(1, 1));
				}
			}
			return factorial.calculateFactorial(word.length()) / consolidatedFrequencyComputationForEachLetter();
		}
		
		private int consolidatedFrequencyComputationForEachLetter() {
			int repetition = 1;
			if (flag) {
				for (Character ch : map.keySet()) {
					Box box = (Box)map.get(ch);
					repetition *= box.getFactorial();
				}
			}
			return repetition;
		}
	}
	
	private class Box {
		private int frequency;
		private int fact;
		
		Box(final int frequency, final int fact) {
			this.frequency = frequency;
			this.fact = fact;
		}
		
		private void setFrequency(final int frequency) {
			this.frequency = frequency;
		}
		
		private int getFrequency() {
			return this.frequency;
		}
		
		private void setFactorial(final int frequency) {
			this.fact = factorial.calculateFactorial(frequency);
		}
		
		private int getFactorial() {
			return this.fact;
		}
	}
}
