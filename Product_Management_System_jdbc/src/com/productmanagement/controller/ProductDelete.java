package com.productmanagement.controller;


import com.productmanagement.services.ProductService;

public class ProductDelete {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		productService.deleteProductById(101);
				
	}

}
