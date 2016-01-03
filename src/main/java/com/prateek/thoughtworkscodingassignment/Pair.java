package com.prateek.thoughtworkscodingassignment;

public class Pair<L, R> {
	private L left;
	private R right;
	
	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}
	
}
