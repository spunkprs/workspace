package com.prateek.designpatterns;

import java.util.List;

public interface FilterationCriteria {
	List<Product> filterProducts(final List<Product> products);
}
