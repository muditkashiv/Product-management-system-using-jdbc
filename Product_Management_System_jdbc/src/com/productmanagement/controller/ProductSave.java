package com.productmanagement.controller;

import com.productmanagement.dto.Product;
import com.productmanagement.services.ProductService;

public class ProductSave {
	public static void main(String[] args) {
		Product product = new Product();
		product.setId(106);
		product.setName("Watermelon cooling sunscreen");
		product.setBrand("Dot & Key");
		product.setPrice(399.09);
		ProductService productService = new ProductService();
		Product p = productService.saveProduct(product);
		if(p!=null) {
			System.out.println(p.getId()+ " saved sucessfully");
		}
		
			  
	}

}
