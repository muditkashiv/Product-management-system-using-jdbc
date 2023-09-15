package com.productmanagement.controller;

import com.productmanagement.dto.Customer;
import com.productmanagement.services.CustomerServices;

public class UpdateCustomer {
	public static void main(String[] args) {
		
		Customer customer = new Customer();
		customer.setId(10);
		customer.setName("Riya");
		customer.setEmail("riya54@gmail.com");
		customer.setLocation("Indore");
		CustomerServices customerServices =   new CustomerServices();
		Customer c = customerServices.updateProduct(customer);
		if(c!= null) {
			System.out.println(c.getId() + " updated sucessfully");
			
		}
		
		
	}

}
