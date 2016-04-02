package com.prateek.designpatterns;

import java.util.List;

import com.google.common.collect.Lists;

public class FilterProductsBySizeAndColor implements FilterationCriteria {

	private int size;
	private String color;
	
	public FilterProductsBySizeAndColor(final String color, final int size) {
		this.size = size;
		this.color = color;
	}

	public List<Product> filterProducts(final List<Product> products) {
		final List<Product> filteredProducts = Lists.newArrayList();
		for (Product p : products) {
			if (p.getColor().equals(this.color) && (p.getSize() == this.size)) {
				filteredProducts.add(p);
			}
		}
		return filteredProducts;
	}
}
