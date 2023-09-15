package com.productmanagement.controller;

import com.productmanagement.services.ProductService;

public class GetAllProduct {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		productService.getAllProduct();
	}

}
