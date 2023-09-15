package com.productmanagement.services;

import java.util.List;

import com.productmanagement.dao.ProductDao;
import com.productmanagement.dto.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public boolean deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}
	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	 public int getProductById(int id) {
		 return productDao.getProductById(id);
	 }
	 public void getAllProduct() {
		 productDao.getAllProduct();
	 }
	 public List<Product> searchProducts(String keyword, double minPrice, double maxPrice) {
		 return productDao.searchProducts(keyword, minPrice, maxPrice);
	 }

}
