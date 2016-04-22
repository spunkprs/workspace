package com.prateek.practiceTDD;

import java.util.HashMap;
import java.util.Map;

public enum Currency {
US_DOLLAR("US Dollar"),
UK_POUND("UK Pound"),
INDIAN_RUPPEE("Indian Ruppee");
	
private String currencyName;
static Map<Currencies, Double> conversionFactorMap = populateMap();

private Currency(final String currencyName) {
	this.currencyName = currencyName;
}

private static Map<Currencies, Double> populateMap() {
	final Map<Currencies, Double> map = new HashMap<Currencies, Double>(); 
	map.put(new Currencies(Currency.US_DOLLAR.currencyName, Currency.INDIAN_RUPPEE.currencyName), 55.0);
	map.put(new Currencies(Currency.UK_POUND.currencyName, Currency.INDIAN_RUPPEE.currencyName), 88.0);
	return map;
}

public String getCurrencyName() {
	return currencyName;
}

}
