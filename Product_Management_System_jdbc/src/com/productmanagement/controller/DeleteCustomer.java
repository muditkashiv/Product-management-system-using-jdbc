package com.productmanagement.controller;

import com.productmanagement.services.CustomerServices;

public class DeleteCustomer {
	public static void main(String[] args) {
		CustomerServices customerServices = new CustomerServices();
		customerServices.deleteCustomerById(11);
	}

}
