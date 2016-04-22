package com.prateek.practiceTDD;

import java.util.Map;

public class CurrencyConvertor {

	public static double convert(final Currency currencyFrom, final double currencyOneAmount, final Currency currencyTo) {
		if (currencyOneAmount != 0.0) {
			final Currencies currencies = new Currencies(currencyFrom.getCurrencyName(), currencyTo.getCurrencyName());
			final Map<Currencies, Double> conversionFactorMap = Currency.conversionFactorMap;
			
			if (conversionFactorMap.containsKey(currencies)) {
				return currencyOneAmount * conversionFactorMap.get(currencies);
			} else {
			final Currencies invertedCurrencies = new Currencies(currencies.getCurrencyTo(), currencies.getCurrencyFrom());
			if (conversionFactorMap.containsKey(invertedCurrencies)) {
				return currencyOneAmount / conversionFactorMap.get(invertedCurrencies);
			}
			}
		}
		return 0.0;
	}
}


/*
if (currencyFrom.getCurrencyName().equals("US Dollar") && currencyTo.getCurrencyName().equals("Indian Ruppee")) {
	return currencyOneAmount * 55.0;
} 

if (currencyFrom.getCurrencyName().equals("UK Pound") && currencyTo.getCurrencyName().equals("Indian Ruppee")) {
	return currencyOneAmount * 88.0;
}
*/