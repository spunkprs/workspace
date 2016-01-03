package com.prateek.implementationofcaches;

import com.openpojo.business.BusinessIdentity;
import com.openpojo.business.annotation.BusinessKey;

public class Node {

	@BusinessKey private int uniqueIdentity;
	
	public Node(final int uniqueIdentity) {
		this.uniqueIdentity = uniqueIdentity;
	}
	
	public int hashCode() {
		return BusinessIdentity.getHashCode(this);
	}
	
	public boolean equals(final Object obj) {
		return BusinessIdentity.areEqual(this, obj);
	}
	
	public int getUniqueIdentity() {
		return this.uniqueIdentity;
	}
}
