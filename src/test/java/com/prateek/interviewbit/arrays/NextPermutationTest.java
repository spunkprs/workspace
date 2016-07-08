package com.prateek.interviewbit.arrays;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import org.junit.Assert;

import java.util.List;

public class NextPermutationTest {
	
	private NextPermutation unit;
	
	@Before
	public void setUp() {
		unit = new NextPermutation();
	}

	@Test
	public void shouldFetchNextPermutationCaseOne() {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		final List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(1);
		expectedList.add(3);
		expectedList.add(2);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseTwo() {
		final List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		
		final List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(3);
		expectedList.add(1);
		expectedList.add(2);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseThree() {
		final List<Integer> list = Lists.newArrayList(4, 1, 5, 3);
		
		final List<Integer> expectedList = Lists.newArrayList(4, 3, 1, 5);
	
		final List<Integer> actualList = unit.nextPermutation(list);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseFour() {
		final List<Integer> list = Lists.newArrayList(251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991);
		
		final List<Integer> expectedList = Lists.newArrayList(251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 991, 891);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseFive() {
		final List<Integer> list = Lists.newArrayList(769, 533);
		
		final List<Integer> expectedList = Lists.newArrayList(533, 769);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseSix() {
		final List<Integer> list = Lists.newArrayList(626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506, 59, 854, 422);
		final List<Integer> expectedList = Lists.newArrayList(626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506, 422, 59, 854);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseSeven() {
		final List<Integer> list = Lists.newArrayList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52);
		final List<Integer> expectedList = Lists.newArrayList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 695, 52, 319);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}
	
	@Test
	public void shouldFetchNextPermutationCaseEight() {
		final List<Integer> list = Lists.newArrayList(684, 220, 999, 437, 105, 3, 693, 271, 103);
		
		final List<Integer> expectedList = Lists.newArrayList(684, 220, 999, 437, 105 ,103, 3, 271, 693);
		
		final List<Integer> actualList = unit.nextPermutation(list);
		
		Assert.assertEquals(expectedList.size(), actualList.size());
		verify(expectedList, actualList);
	}


	private void verify(final List<Integer> expectedList, final List<Integer> actualList) {
		for (int i = 0; i < expectedList.size(); i++) {
			Assert.assertEquals(expectedList.get(i), actualList.get(i));
		}
	}
	
}
