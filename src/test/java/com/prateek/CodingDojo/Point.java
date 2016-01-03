package com.prateek.CodingDojo;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class Point {

@BusinessKey private int x;
@BusinessKey private int y;

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public Point(final int x, final int y) {
	this.x = x;
	this.y = y;
}

public boolean equals(final Object obj) {
	return BusinessIdentity.areEqual(this, obj);
}

public int hashCode() {
	return BusinessIdentity.getHashCode(this);
}
}
