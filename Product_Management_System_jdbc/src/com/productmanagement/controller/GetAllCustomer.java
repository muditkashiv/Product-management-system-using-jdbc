package com.productmanagement.controller;

import com.productmanagement.services.CustomerServices;

public class GetAllCustomer {
	public static void main(String[] args) {
		CustomerServices customerServices = new CustomerServices();
		customerServices.getAllCustomer();
	}

}
