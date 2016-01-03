package com.prateek.nqueenproblem;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class NQueenProblem {
	private int chessBoard[][];
	private TreeMap<Integer, List<Position>> nonAttackingPositions = Maps.newTreeMap();
	 
	
	public TreeMap<Integer, List<Position>> generatePositionsOfNonAttackingQueens(final int board[][]) {
		this.chessBoard = board;
		
		if (chessBoard.length > 3) {
			for (int i = 0; i < board.length; i++) {
				final int j = 0;
				generate(getLastSolution() + 1, i, j);
				removeIncompleteAttackingPositionMappings();
			}
		}
		return nonAttackingPositions;
	}
	
	private void removeIncompleteAttackingPositionMappings() {
		for (Integer sequenceNumber : nonAttackingPositions.keySet()) {
			if(nonAttackingPositions.get(sequenceNumber).size() != chessBoard.length) {
				nonAttackingPositions.remove(sequenceNumber);
			}
		}
	}

	private void generate(int sequenceNumber , int i, int j) {
		if (j < chessBoard.length && i < chessBoard.length) {
			List<Position> positions = nonAttackingPositions.get(sequenceNumber);
			if (positions != null && positions.size() >= 1) {
				final Position newPosition = new Position(i, j);
				
				if (!areQueensInAttackingPosition(positions, newPosition)) {
					positions.add(newPosition);
					if (positions.size() == chessBoard.length) {
						getLastSolution();
						return;
					}
					
					generate(sequenceNumber, 0, ++j);
					if (positions.size() != chessBoard.length) {
						positions.remove(newPosition);
						generate(sequenceNumber, ++i, --j);
					}
				} else {
					//positions.remove(newPosition);
					generate(sequenceNumber, ++i, j);
				}
			} else {
				nonAttackingPositions.put(sequenceNumber, Lists.newArrayList(new Position(i, j)));
				generate(sequenceNumber, 0, ++j);
			}
		}
	}

	private Integer getLastSolution() {
		if (nonAttackingPositions.size() > 0) {
			return nonAttackingPositions.lastKey();
		} else {
			return 0;
		}
	}

	public boolean areQueensInAttackingPosition(final List<Position> positions, final Position position) {
		return areQueensAttacking(positions, position);
	}

	private boolean areQueensAttacking(final List<Position> positions, final Position position) {
		boolean areAttacking = false;
		for (Position pos : positions) {
			if (isAttacking(pos, position)) {
					return true;
			}
		}
		return areAttacking;
	}

	private boolean isAttacking(final Position pos1, final Position pos2) {
		if (pos1.getX() == pos2.getX() || pos1.getY() == pos2.getY() || areDiagonalToOneAnother(pos1, pos2)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean areDiagonalToOneAnother(final Position pos1, final Position pos2) {
		if (Math.abs(pos1.getX() - pos2.getX()) == Math.abs(pos1.getY() - pos2.getY())) {
			return true;
		} else {
			return false;	
		}
	}
}
