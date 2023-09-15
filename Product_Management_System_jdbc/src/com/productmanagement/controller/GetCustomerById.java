package com.productmanagement.controller;

import com.productmanagement.services.CustomerServices;

public class GetCustomerById {
	public static void main(String[] args) {
		CustomerServices customerServices = new CustomerServices();
		customerServices.getCustomerById(1);
	}

}
