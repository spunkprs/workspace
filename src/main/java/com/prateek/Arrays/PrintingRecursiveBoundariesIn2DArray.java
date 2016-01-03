package com.prateek.Arrays;

import java.util.List;
import com.google.common.collect.Lists;

public class PrintingRecursiveBoundariesIn2DArray {
	private int counter = 0;
	final List<Integer> pattern = Lists.newArrayList();
	private int startX = 0, startY = 0; 
	private int row =0, col = 0;
	
	public List<Integer> getPatternOfNumbers(final int[][] array) {
		if (array.length > 1 && array[0].length > 1) {
			operation(array);
		} else {
			if (array.length >= array[0].length) {
				insertInPattern(array, 'X', array.length);
			} else {
				insertInPattern(array, 'Y', array[0].length);
			}
		}
		return pattern;
	}
	
	private void insertInPattern(int array[][], char C, int length) {
		for (int i = 0; i < length; i++) {
			if (C == 'X') {
				pattern.add(array[i][0]);
			} else {
				pattern.add(array[0][i]);
			}
		}
	}

	private void operation(int[][] array) {
		while(counter < array.length * array[0].length) {
		func(array);	
		}
	}

	private void func(int[][] array) {
		int x = 0, y = 0;
		if (counter == 0) {
			x = 0;
			y = 0;
			row = array.length;
			col = array[0].length;
		} else {
			x = startX;
			y = startY;
			row--;
			col--;
		}
		
		for (int j = y; j < col; j++) {
			pattern.add(array[x][j]);
			y++;
			counter++;
			if (checkSize(array.length * array[0].length)) {
				return;
			}
		}
		y--;
		
		x++;
		for (int i = x; i < row; i++) {
			pattern.add(array[i][y]);
			x++;
			counter++;
			if (checkSize(array.length * array[0].length)) {
				return;
			}
		} 
		x--;
		
		y--;
		for (int j = y; j >=startY; j--) {
			pattern.add(array[x][j]);
			y--;
			counter++;
			if (checkSize(array.length * array[0].length)) {
				return;
			}
		}
		
		y++;
		x--;
		for (int i = x; i >=startX; i--) {
			if (x == startX && y == startY) {
				x++;
				startX = x;
				startY = y + 1;
				break;
			}
			pattern.add(array[i][y]);
			x--;
			counter++;
			if (checkSize(array.length * array[0].length)) {
				return;
			}
		} 
	}

	private boolean checkSize(final int size) {
		return counter >= size ? true: false;
	}
}
