package com.prateek.practiceTDD;

public class Currencies {

	private String currencyFrom;
	private String currencyTo;
	
	public Currencies(final String currencyFrom, final String currencyTo) {
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}
	
	public int hashCode() {
		return this.currencyFrom.hashCode() ^ this.currencyTo.hashCode();
	}
	
	public boolean equals(final Object obj) {
		Currencies currencies = (Currencies)obj;
		if (currencies.getCurrencyFrom().equals(this.currencyFrom) && currencies.getCurrencyTo().equals(this.currencyTo)) {
			return true;
		}
		return false;
	}
}
