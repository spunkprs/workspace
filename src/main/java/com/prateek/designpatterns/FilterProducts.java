package com.prateek.designpatterns;

import java.util.List;

public class FilterProducts {

	public List<Product> filterProducts(final List<Product> products, final FilterationCriteria criteria) {
		return criteria.filterProducts(products);
	}
}
