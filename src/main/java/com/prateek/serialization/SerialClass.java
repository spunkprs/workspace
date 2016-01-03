package com.prateek.serialization;

import java.util.Calendar;
import java.util.Date;

public class SerialClass extends SerialClassParent {

	private static final long serialVersionUID = 1L;
	
	/*
	 * Static fields doesn't gets serialized
	 * */
	public static int counter = 0;
	
	private Date currentTime;
	private String description;
	
	public SerialClass(final String description) {
		super("PARENT");
		this.description = description;
		currentTime = Calendar.getInstance().getTime();
	}
	
	public Date getCurrentTime() {
		return currentTime;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean equals(final Object obj) {
		final SerialClass object = (SerialClass)obj;
		if (this.getCurrentTime().equals(object.getCurrentTime()) && this.getDescription().equals(object.getDescription())) {
			return true;
		} else {
			return false;
		}
	}
}
