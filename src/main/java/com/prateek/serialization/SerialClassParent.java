package com.prateek.serialization;

import java.io.Serializable;

public class SerialClassParent extends SerialClassGrandParent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String description;
	
	public SerialClassParent(String description) {
		super("GRANDPARENT");
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
