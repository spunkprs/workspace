package com.prateek.nqueenproblem;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class Position {
	
	@BusinessKey private int x;
	@BusinessKey private int y;
	
	public Position(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		return BusinessIdentity.getHashCode(this);
	}

	@Override
	public boolean equals(Object object) {
		return BusinessIdentity.areEqual(this, object);
	}
}
