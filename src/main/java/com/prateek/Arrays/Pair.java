package com.prateek.Arrays;


public class Pair {

	private int first;
	private int second;
	
	Pair(final int first, final int second) {
		this.first = first;
		this.second = second;
	}
	
	
	public int getFirst() {
		return first;
	}
	public int getSecond() {
		return second;
	}
	
	
	@Override
	public int hashCode() {
		return this.first * this.second;
	}
	
	@Override
	public boolean equals(final Object pair) {
		final Pair obj = (Pair)pair;
		return checkEquality(obj);
	}

	private boolean checkEquality(Pair obj) {
		final int  num1 = this.getFirst();
		final int  num2 = this.getSecond();
		
        if (num1 == obj.getFirst() && num2 == obj.getSecond()) {
			return true;
		} else if (num1 == obj.getSecond() && num2 == obj.getFirst()) {
			return true;
		} else {
			return false;
		}
	}
}
