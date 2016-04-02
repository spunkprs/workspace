package com.prateek.designpatterns;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class Product {

	@BusinessKey private String color;
	@BusinessKey private int size;
	
	public Product(final String color, final int size) {
		this.color = color;
		this.size = size;
	}
	
	public int hashCode() {
		return BusinessIdentity.getHashCode(this);
	}
	
	public boolean equals(final Object obj) {
		return BusinessIdentity.areEqual(this, obj);
	}

	public String getColor() {
		return color;
	}

	public int getSize() {
		return size;
	}
}
