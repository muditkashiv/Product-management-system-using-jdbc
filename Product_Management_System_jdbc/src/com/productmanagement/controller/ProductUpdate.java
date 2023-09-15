package com.productmanagement.controller;

import com.productmanagement.dto.Product;
import com.productmanagement.services.ProductService;

public class ProductUpdate {
	public static void main(String[] args) {
		Product product = new Product();
		product.setId(101);
		product.setName("hello clear skin fashwash");
		product.setBrand("skinit");
		product.setPrice(339.99);
		
		ProductService productService = new ProductService();
		Product p = productService.updateProduct(product);
		if(p!=null) {
			System.out.println(p.getId() +" updated sucessfully ");
			
		}
		
	}

}
