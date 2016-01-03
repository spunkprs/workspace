package com.prateek.nqueenproblem;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class NQueenProblemTest {
	private NQueenProblem unit;
	
	@Before
	public void setUp() {
		unit = new NQueenProblem();
	}

	@Test
	public void shallGeneratePositionsOfNonAttackingQueens() {
		//Set Up
		final int size = RandomUtils.nextInt(20) + 1;
		final int board [][] = new int[size][size];
		
		//Execute
		Map<Integer, List<Position>> positionsMap = unit.generatePositionsOfNonAttackingQueens(board);
		
		//Verify
		verify(board.length, positionsMap);
	}
	
	private void verify(int length, Map<Integer, List<Position>> positionsMap) {
		if (length <= 3) {
			Assert.assertEquals(0, positionsMap.size());
		} else {
			for (Integer i : positionsMap.keySet()) {
				Assert.assertEquals(length, positionsMap.get(i).size());
			}
		}
	}

	@Test
	public void shallCheckIfQueensAreInAttackingPositions() {
		//Set Up
		//Execute && Verify
		Assert.assertFalse(unit.areQueensInAttackingPosition(createFirstNonAttackingPositionsForQueens(),  new Position(2, 3)));
		Assert.assertFalse(unit.areQueensInAttackingPosition(createSecondNonAttackingPositionsForQueens(),  new Position(1, 3)));
		Assert.assertTrue(unit.areQueensInAttackingPosition(createFirstAttackingPositionsForQueens(), new Position(2, 1)));
	}

	private List<Position> createFirstNonAttackingPositionsForQueens() {
		return  Lists.newArrayList(new Position(1, 0), new Position(3, 1), new Position(0, 2));
	}
	
	private List<Position> createSecondNonAttackingPositionsForQueens() {
		return  Lists.newArrayList(new Position(2, 0), new Position(0, 1), new Position(3, 2));
	}
	
	private List<Position> createFirstAttackingPositionsForQueens() {
		return  Lists.newArrayList(new Position(2, 0),  new Position(3, 2));
	}
}
