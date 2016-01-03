package com.prateek.thoughtworkscodingassignment;

/*Following are the valid elements that can be used for trading.*/

public enum Element {
	
	GOLD("Gold"),
	SILVER("Silver"), 
	IRON("Iron"),
	COPPER("Copper");
	
	private String nameOfElement;
	
	Element(final String elementName) {
		this.nameOfElement = elementName;
	}

	public String getNameOfElement() {
		return nameOfElement;
	}
}
