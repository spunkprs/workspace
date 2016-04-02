package com.prateek.designpatterns;

import java.util.List;

import com.google.common.collect.Lists;

public class FilterProductsByColor implements FilterationCriteria {

	private String color;
	
	public FilterProductsByColor(final String color) {
		this.color = color;
	}

	public List<Product> filterProducts(final List<Product> products) {
		final List<Product> filteredProducts = Lists.newArrayList();
		for (Product p : products) {
			if (p.getColor().equals(this.color)) {
				filteredProducts.add(p);
			}
		}
		return filteredProducts;
	}
}
