package com.prateek.serialization;

public class Human {

	private String color;
	private String gender;
	
	public Human() {
		
	}
	
	public Human(final String color, final String gender) {
		this.color = color;
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public String getGender() {
		return gender;
	}
}
