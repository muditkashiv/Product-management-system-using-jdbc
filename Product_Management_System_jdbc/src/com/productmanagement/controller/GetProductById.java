package com.productmanagement.controller;

import com.productmanagement.services.ProductService;

public class GetProductById {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		productService.getProductById(105);
	}

}
