package com.prateek.designpatterns;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class FilterProductsByColorAndSizeTest {

private FilterProductsBySizeAndColor unit;
	
	@Test
	public void shouldFilterProductsBySizeWhenSizeIsTenAndColorIsGreen() {
		final List<Product> allProducts = fetchProducts();
		final List<Product> expectedProducts = Lists.newArrayList(allProducts.get(2));
		
		unit = new FilterProductsBySizeAndColor("GREEN", 10);
		final List<Product> actualProducts = unit.filterProducts(allProducts);
		
		Assert.assertEquals(expectedProducts.size(), actualProducts.size());
		verify(expectedProducts, actualProducts);
	}
	
	@Test
	public void shouldFilterProductsBySizeWhenSizeIsFiveAndColorIsRed() {
		final List<Product> allProducts = fetchProducts();
		final List<Product> expectedProducts = Lists.newArrayList(allProducts.get(0));
		
		unit = new FilterProductsBySizeAndColor("RED", 5);
		final List<Product> actualProducts = unit.filterProducts(allProducts);
		
		Assert.assertEquals(expectedProducts.size(), actualProducts.size());
		verify(expectedProducts, actualProducts);
	}
	
	@Test
	public void shouldReturnEmptyListWhenSizeOfPassedProductsIsZero() {
		final List<Product> allProducts = Lists.newArrayList();
		
		unit = new FilterProductsBySizeAndColor("RED", 5);
		
		Assert.assertEquals(0, unit.filterProducts(allProducts).size());
	}
	
	private void verify(final List<Product> expectedProducts, final List<Product> actualProducts) {
		for (Product product : expectedProducts) {
			Assert.assertTrue(actualProducts.contains(product));
		}
	}

	public List<Product> fetchProducts() {
		final Product productOne = new Product("RED", 5);
		final Product productTwo = new Product("BLACK", 10);
		final Product productThree = new Product("GREEN", 10);
		final Product productFour = new Product("GREEN", 5);
		final Product productFive = new Product("BLUE", 10);
		final Product productSix = new Product("RED", 10);
		final List<Product> products = Lists.newArrayList(productOne, productTwo, productThree, productFour, productFive, productSix);
		return products;
	}
}
