package com.prateek.serialization;

import java.io.Serializable;

public class Man extends Human implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String address;
	
	public Man(final String name, final String address, final String color) {
		super(color, "MALE");
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public boolean equals(final Object obj) {
		final Man man = (Man)obj; 
		final String name = man.getName();
		final String address = man.getAddress();
		final String color = man.getColor();
		final String gender = man.getGender();
		
		if (this.getName().equals(name) && this.getAddress().equals(address) && this.getColor().equals(color) && this.getGender().equals(gender)) {
			return true;
		}
		return false;
	}
}
