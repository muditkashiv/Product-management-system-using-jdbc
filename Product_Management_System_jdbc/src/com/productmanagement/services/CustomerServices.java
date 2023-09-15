package com.productmanagement.services;

import com.productmanagement.dao.CustomerDao;
import com.productmanagement.dto.Customer;


public class CustomerServices {
	CustomerDao customerDao = new CustomerDao();
	public Customer saveProduct(Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	public boolean deleteCustomerById(int id) {
		return customerDao.deleteCustomerById(id);
	}
	public Customer updateProduct(Customer customer) {
		return customerDao.updateCustomer(customer);
	}
	 public int getCustomerById(int id) {
		 return customerDao.getCustomerById(id);
	 }
	 public void getAllCustomer() {
		 customerDao.getAllCustomer();
	 }

}
