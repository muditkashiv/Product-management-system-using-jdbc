package com.productmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.productmanagement.configuration.HelperClass;
import com.productmanagement.dto.Customer;
//import com.productmanagement.dto.Product;

public class CustomerDao {
	HelperClass helperClass = new HelperClass();
	Connection connection = null;
	
	//to save  data 
	
	public Customer saveCustomer(Customer customer) {
		//ESTABLISH CONNECTION
	  connection =helperClass.getConnection();
	  String sql = "INSERT INTO customer VALUES(?,?,?,?)";
	  //CREATE STATEMENT
	  
	  try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, customer.getId());
		preparedStatement.setString(2,customer.getName());
		preparedStatement.setString(3,customer.getEmail());
		preparedStatement.setString(4,customer.getLocation());		
		//execute the statement
		preparedStatement.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 return customer; 
	}
	
	// to delete customer by id
	public boolean deleteCustomerById(int id) {
		//establish connection
		connection = helperClass.getConnection();
		String sql = "DELETE FROM customer WHERE ID =?";
		//CREATE STATEMENT
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			//execute the statement
			int i =preparedStatement.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//to Update customer data
	 public Customer updateCustomer(Customer customer) {
		 //establish connection
		 connection = helperClass.getConnection();
		 String sql ="UPDATE  customer set name=? , email =? , location=? WHERE id = ? ";
		 // establish statement
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,customer.getName());
			preparedStatement.setString(2,customer.getEmail());
			preparedStatement.setString(3,customer.getLocation());
			preparedStatement.setInt(4,customer.getId());
			//execute the statement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return customer;
		 		 
	 }
	 
	 //  get customer details by id 
	 
	 public int getCustomerById(int id) {
		 connection = helperClass.getConnection();
		 String sql = "SELECT * FROM customer WHERE id = ?";
		 
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				System.out.println(resultset.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return id;
	 }
	 // to get all customer data
	 public void getAllCustomer() {
		 connection = helperClass.getConnection();
		 String sql = "SELECT * FROM customer";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet s = preparedStatement.executeQuery();
			while(s.next()) {
				System.out.println(s.getInt(1));
				System.out.println(s.getString(2));
				System.out.println(s.getString(3));
				System.out.println(s.getString(4));
				System.out.println("=====================================================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }			
	

}
