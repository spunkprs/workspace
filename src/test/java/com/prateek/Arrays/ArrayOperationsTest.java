package com.prateek.Arrays;

import java.util.List;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ArrayOperationsTest {

	private ArrayOperations unit;
	
	@Before
	public void setUp() {
		unit = new ArrayOperations();
	}
	
	@Test
	public void shouldReturnCountOfInversionsCaseOne() {
		//Set Up
		int array [] = {2, 4, 1, 3, 5};
		
		//Execute && Verify
		Assert.assertEquals(3, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnCountOfInversionsCaseTwo() {
		//Set Up
		int array [] = {2, 9, 7, 1, 4};
		
		//Execute && Verify
		Assert.assertEquals(6, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnCountOfInversionsWhenArrayIsSortedInIncreasingOrder() {
		//Set Up
		int array[] = {1, 2, 3, 4, 5};
		
		//Execute && Verify
		Assert.assertEquals(0, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnCountOfInversionsWhenArrayIsSortedInDecreasingOrder() {
		//Set Up
		int array[] = {5, 4, 3, 2, 1};
		
		//Execute && Verify
		Assert.assertEquals(10, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnCountOfInversionsWhenArrayIsOfLengthThree() {
		//Set Up
		int array[] = {5, 4, 3};
		
		//Execute && Verify
		Assert.assertEquals(3, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnCountOfInversionsWhenArrayIsOfLengthTwo() {
		//Set Up
		int array[] = {5, 4};
		
		//Execute && Verify
		Assert.assertEquals(1, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnCountOfInversionsWhenArrayIsOfLengthOne() {
		//Set Up
		int array[] = {5};
		
		//Execute && Verify
		Assert.assertEquals(0, unit.countInversionsInAnArray(array));
	}
	
	@Test
	public void shouldReturnNumberOfZeroesWhenFirstZeroLiesInSecondHalf() {
		//Set Up
		int array[] = {1, 1, 1, 1, 0, 0};
		
		//Execute && Verify
		Assert.assertEquals(2, unit.countNumberOfZeroesInAnArray(array));
	}
	
	@Test
	public void shouldReturnNumberOfZeroesWhenThereIsNoZeroInTheArray() {
		//Set Up
		int array[] = {1, 1, 1, 1, 1};
		
		//Execute && Verify
		Assert.assertEquals(-1, unit.countNumberOfZeroesInAnArray(array));
	}
	
	@Test
	public void shouldReturnNumberOfZeroesWhenZeroLiesAtTheEndOfArray() {
		//Set Up
		int array[] = {1, 1, 1, 1, 0};
		
		//Execute && Verify
		Assert.assertEquals(1, unit.countNumberOfZeroesInAnArray(array));
	}
	
	@Test
	public void shouldReturnNumberOfZeroesWhenThereAreNoOnesInTheArray() {
		//Set Up
		int array[] = {0, 0, 0, 0, 0, 0};
		
		//Execute && Verify
		Assert.assertEquals(6, unit.countNumberOfZeroesInAnArray(array));
	}
	
	@Test
	public void shouldReturnNumberOfZeroesWhenFirstZeroLiesInFirstHalfOfArray() {
		//Set Up
		int array[] = {1, 0, 0, 0, 0, 0};
		
		//Execute && Verify
		Assert.assertEquals(5, unit.countNumberOfZeroesInAnArray(array));
	}
	
	@Test
	public void shouldPrintPatternCaseOne() {
		//Set Up
		int number = 10;
		final List<Integer> expectedListOfIntegers = Lists.newArrayList(10, 5, 0, 5, 10);
		
		//Execute &&  Verify
		final List<Integer> actaulListOfIntegers = unit.printPattern(number);
		Assert.assertEquals(expectedListOfIntegers.size(), actaulListOfIntegers.size());
		verify(expectedListOfIntegers, actaulListOfIntegers);
	}
	
	@Test
	public void shouldPrintPatternCaseTwo() {
		//Set Up
		int number = 16;
		final List<Integer> expectedListOfIntegers = Lists.newArrayList(16, 11, 6, 1, -4, 1, 6, 11, 16);
		
		//Execute &&  Verify
		final List<Integer> actaulListOfIntegers = unit.printPattern(number);
		Assert.assertEquals(expectedListOfIntegers.size(), actaulListOfIntegers.size());
		verify(expectedListOfIntegers, actaulListOfIntegers);
	}
	
	@Test
	public void shouldGetIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbersCaseOne() {
		//Set Up
		int n = 6; 
		int length = 4;
		
		final List<String> expectedSequence = Lists.newArrayList("1234", "1235", "1236", "1245", "1246", "1256", "1345", "1346", "1356", "1456", "2345", "2346", "2356", "2456", "3456");
		final List<String> actualSequence = unit.getIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbers(length, n);
		
		Assert.assertEquals(expectedSequence.size(), actualSequence.size());
		verifySequences(expectedSequence, actualSequence);
	}
	
	@Test
	public void shouldGetIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbersCaseTwo() {
		//Set Up
		int n = 6; 
		int length = 5;
		
		final List<String> expectedSequence = Lists.newArrayList("12345", "12346", "12356", "12456", "13456", "23456");
		final List<String> actualSequence = unit.getIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbers(length, n);
		
		Assert.assertEquals(expectedSequence.size(), actualSequence.size());
		verifySequences(expectedSequence, actualSequence);
	}
	
	@Test
	public void shouldGetIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbersCaseThree() {
		//Set Up
		int n = 6; 
		int length = 6;
		
		final List<String> expectedSequence = Lists.newArrayList("123456");
		final List<String> actualSequence = unit.getIncreasingSequenceOfMentionedLengthFromFirstNNaturalNumbers(length, n);
		
		Assert.assertEquals(expectedSequence.size(), actualSequence.size());
		verifySequences(expectedSequence, actualSequence);
	}
	
	@Test
	public void shouldGetAllPossibleStringsFormedFromSetOfNCharactersCaseOne() {
		//Set Up
		int k = 2;
		final char arr[] = {'a', 'b', 'c'};
		
		final List<String> expectedSequences = Lists.newArrayList("aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb", "cc");
		final List<String> actualSequences = unit.getAllPossibleStringsFormedFromSetOfNCharacters(arr, k);
		
		Assert.assertEquals(expectedSequences.size(), actualSequences.size());
		verifySequences(expectedSequences, actualSequences);
	}
	
	@Test
	public void shouldGetAllPossibleStringsFormedFromSetOfNCharactersCaseTwo() {
		//Set Up
		int k = 3;
		final char arr[] = {'a', 'b'};
		
		final List<String> expectedSequences = Lists.newArrayList("aaa", "aab", "aba", "abb", "baa", "bab", "bba", "bbb");
		final List<String> actualSequences = unit.getAllPossibleStringsFormedFromSetOfNCharacters(arr, k);
		
		Assert.assertEquals(expectedSequences.size(), actualSequences.size());
		verifySequences(expectedSequences, actualSequences);
	}
	
	@Test
	public void shouldGetAllPossibleStringsFormedFromSetOfNCharactersCaseThree() {
		//Set Up
		int k = 1;
		final char arr[] = {'a', 'b'};
		
		final List<String> expectedSequences = Lists.newArrayList("a", "b");
		final List<String> actualSequences = unit.getAllPossibleStringsFormedFromSetOfNCharacters(arr, k);
		
		Assert.assertEquals(expectedSequences.size(), actualSequences.size());
		verifySequences(expectedSequences, actualSequences);
	}
	
	@Test
	public void shouldGetMinimumNumberOfStepsToReachDestination() {
		//Set Up
		int numberToReach = 9;
		
		Assert.assertEquals(5, unit.getMinimumStepsToReachDestination(numberToReach));
	}

	private void verifySequences(final List<String> expectedSequence, final List<String> actualSequence) {
		for (int i = 0; i < expectedSequence.size(); i++) {
			Assert.assertEquals(expectedSequence.get(i), actualSequence.get(i));
			
		}
	}

	private void verify(final List<Integer> expectedListOfIntegers, final List<Integer> actaulListOfIntegers) {
		for (int i = 0; i < expectedListOfIntegers.size(); i++) {
			Assert.assertEquals(expectedListOfIntegers.get(i), actaulListOfIntegers.get(i));
		}
	}
}
