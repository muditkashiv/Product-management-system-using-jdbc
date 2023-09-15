package com.productmanagement.controller;

import com.productmanagement.dto.Customer;
import com.productmanagement.services.CustomerServices;

public class SaveCustomer {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(12);
		customer.setName("anisha");
		customer.setEmail("anisha324@gmail.com");
		customer.setLocation("uran");
		CustomerServices customerServices = new CustomerServices();
		Customer c = customerServices.saveProduct(customer);
		if(c!=null) {
			System.out.println(c.getId() +" saved sucessfully");
		}
	}

}
