package com.prateek.designpatterns;

import java.util.List;

import com.google.common.collect.Lists;

public class FilterProductsBySize implements FilterationCriteria {

	private int size;
	
	public FilterProductsBySize(final int size) {
		this.size = size;
	}
	
	public List<Product> filterProducts(List<Product> products) {
		final List<Product> filteredProducts = Lists.newArrayList();
		for (Product p : products) {
			if (p.getSize() == this.size) {
				filteredProducts.add(p);
			}
		}
		return filteredProducts;
	}
}
