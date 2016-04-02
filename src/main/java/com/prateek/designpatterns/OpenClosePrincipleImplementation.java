package com.prateek.designpatterns;

import java.util.List;

import com.google.common.collect.Lists;

public class OpenClosePrincipleImplementation {
	
	private static FilterProducts filterProducts;

	public static void main(String[] args) {
		filterProducts = new FilterProducts();
		final List<Product> products = fetchProducts();
		
		//Filter Products By Size
		filterProductsBySize(products, new FilterProductsBySize(5));
		
		//Filter Products By Color
		filterProductsByColor(products, new FilterProductsByColor("GREEN"));
		
		//Filter Products By Color And Size
		filterProductsByColorAndSize(products, new FilterProductsBySizeAndColor("RED", 10));
	}
	
	private static void filterProductsByColorAndSize(final List<Product> allProducts, final FilterProductsBySizeAndColor criteria) {
		printProductsDetails(filterProducts.filterProducts(allProducts, criteria));
	}

	private static void printProductsDetails(final List<Product> filteredProducts) {
		for (Product p : filteredProducts) {
			System.out.println("Color" + p.getColor());
			System.out.println("Size" + p.getSize());
		}
	}

	private static void filterProductsByColor(final List<Product> allProducts, final FilterProductsByColor criteria) {
		printProductsDetails(filterProducts.filterProducts(allProducts, criteria));
	}

	private static void filterProductsBySize(final List<Product> allProducts, final FilterationCriteria criteria) {
		printProductsDetails(filterProducts.filterProducts(allProducts, criteria));
	}

	public static List<Product> fetchProducts() {
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
