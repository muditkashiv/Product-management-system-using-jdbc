package com.productmanagement.controller;

import java.util.List;

import com.productmanagement.dto.Product;
import com.productmanagement.services.ProductService;

public class ProductList {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		List<Product> searchResults = productService.searchProducts("keyword", 100.0, 500.0);

		for (Product product : searchResults) {
		    System.out.println(product.getName() + " - " + product.getPrice());
		}
	}

}
