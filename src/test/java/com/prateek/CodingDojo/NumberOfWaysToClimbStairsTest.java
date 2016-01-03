package com.prateek.CodingDojo;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class NumberOfWaysToClimbStairsTest {

	private NumberOfWaysToClimbStairs unit;
	
	@Before
	public void setUp() {
		unit = new NumberOfWaysToClimbStairs();
	}
	
	
@Test
public void shouldFindNumberOfWaysToClimbStairsWhenNumberOfStairsIsZero() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 0;
	Assert.assertEquals(0, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}

@Test
public void shouldFindNumberOfWaysToClimbStairsAsZeroWhenNumberOfStairsIsNegative() {
	//Set Up , Execute && Verify
	final int numberOfStairs = -10;
	Assert.assertEquals(0, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}


@Test
public void shouldFindNumberOfWaysToClimbStairsAsOneWhenNumberOfStairsIsOne() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 1;
	Assert.assertEquals(1, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}	

@Test
public void shouldFindNumberOfWaysToClimbStairsAsTwoWhenNumberOfStairsAreTwo() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 2;
	Assert.assertEquals(2, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}	


@Test
public void shouldFindNumberOfWaysToClimbStairsAsFourWhenNumberOfStairsAreThree() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 3;
	Assert.assertEquals(4, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}



@Test
public void shouldFindNumberOfWaysToClimbStairsAsThirteenWhenNumberOfStairsAreFive() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 5;
	Assert.assertEquals(13, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}

@Test
public void shouldFindNumberOfWaysToClimbStairsAsSevenWhenNumberOfStairsAreFour() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 4;
	Assert.assertEquals(7, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}


@Test
public void shouldFindNumberOfWaysToClimbStairsAs24WhenNumberOfStairsAreSix() {
	//Set Up , Execute && Verify
	final int numberOfStairs = 6;
	Assert.assertEquals(24, unit.calculateNumberOfWaysToClimbStairs(numberOfStairs));
}

}
