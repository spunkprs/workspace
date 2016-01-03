package com.prateek.progresssoftware;

import java.util.List;

import com.google.common.collect.Lists;
import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class Pair {
	@BusinessKey private int x;
	@BusinessKey private int y;
	private int value;
	
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
		this.value = SkiingOnHimalayas.getGrid()[x][y];
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getValue() {
		return value;
	}
	
	public int hashCode() {
		return BusinessIdentity.getHashCode(this);
	}
	
	public boolean equals(final Object obj) {
		return BusinessIdentity.areEqual(obj, this);
	}
	
	public List<Pair> getAdjoiningPoints() {
		return filter(Lists.newArrayList(getLeftPoint(), getRightPoint(), getTopPoint(), getBottomPoint()));
	}

	private List<Pair> filter(final List<Pair> points) {
	final List<Pair> filteredPoints = Lists.newArrayList();
	for (int i = 0; i < points.size(); i++) {
		if (points.get(i) != null) {
			filteredPoints.add(points.get(i));
		}
	}
	  return filteredPoints;
	}

	private Pair getBottomPoint() {
		int currentX = x;
		if (currentX == SkiingOnHimalayas.getGrid().length - 1) {
			return null;
		} else {
			Pair bottomPoint = new Pair(currentX + 1, y);
			if (qualify(bottomPoint)) {
				return bottomPoint;
			} 
			return null;
		}
	}

	private Pair getTopPoint() {
		int currentX = x;
		if (currentX == 0) {
			return null;
		} else {
			Pair topPoint = new Pair(currentX - 1, y);
			if (qualify(topPoint)) {
				return topPoint;
			} 
			return null;
		}
	}
	
	private boolean qualify(Pair pair) {
		return this.value > pair.getValue() ? true : false;
	}

	private Pair getRightPoint() {
		int currentY = y;
		if (currentY == SkiingOnHimalayas.getGrid()[0].length - 1) {
			return null;
		} else {
			Pair rightPoint = new Pair(x, currentY + 1);
			if (qualify(rightPoint)) {
				return rightPoint;
			}
			return null;
		}
	}

	private Pair getLeftPoint() {
		int currentY = y;
		if (currentY == 0) {
			return null;
		} else {
			Pair leftPoint = new Pair(x, currentY - 1);
			if (qualify(leftPoint)) {
				return leftPoint;
			}
			return null;
		}
	}
}
