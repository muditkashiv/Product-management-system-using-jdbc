package com.productmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.protocol.Resultset;
import com.productmanagement.configuration.HelperClass;
import com.productmanagement.dto.Product;

public class ProductDao {
	HelperClass helperClass = new HelperClass();
	Connection connection = null;
	
	//to save product data 
	
	public Product saveProduct(Product product) {
		//ESTABLISH CONNECTION
	  connection =helperClass.getConnection();
	  String sql = "INSERT INTO product VALUES(?,?,?,?)";
	  //CREATE STATEMENT
	  
	  try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2,product.getName());
		preparedStatement.setString(3,product.getBrand());
		preparedStatement.setDouble(4,product.getPrice());		
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
	 return product; 
	}
	
	// to delete product by id
	public boolean deleteProductById(int id) {
		//establish connection
		connection = helperClass.getConnection();
		String sql = "DELETE FROM product WHERE ID =?";
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
	
	//to Update product data
	 public Product updateProduct(Product product) {
		 //establish connection
		 connection = helperClass.getConnection();
		 String sql ="UPDATE  product set name=? , brand =? , price=? WHERE id = ? ";
		 // establish statement
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,product.getName());
			preparedStatement.setString(2,product.getBrand());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4,product.getId());
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
		 return product;
		 		 
	 }
	 
	 //  get product details by id 
	 
	 public int getProductById(int id) {
		 connection = helperClass.getConnection();
		 String sql = "SELECT * FROM product WHERE id = ?";
		 
		 try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				System.out.println(resultset.getInt(1));
				System.out.println(resultset.getString(2));
				System.out.println(resultset.getString(3));
				System.out.println(resultset.getDouble(4));
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
	 // to get all product data
	 public void getAllProduct() {
		 connection = helperClass.getConnection();
		 String sql = "SELECT * FROM product";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet s = preparedStatement.executeQuery();
			while(s.next()) {
				System.out.println(s.getInt(1));
				System.out.println(s.getString(2));
				System.out.println(s.getString(3));
				System.out.println(s.getDouble(4));
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
	 
	   public List<Product> searchProducts(String keyword, double minPrice, double maxPrice) {
		   connection = helperClass.getConnection();
	        List<Product> product = new ArrayList<>();
	        StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE 1=1");

            if (keyword != null && !keyword.isEmpty()) {
                sql.append(" AND name LIKE ?");
            }
            
            if (minPrice >= 0) {
                sql.append(" AND price >= ?");
            }
            
            if (maxPrice >= 0) {
                sql.append(" AND price <= ?");
            }
            try {
				PreparedStatement statement = connection.prepareStatement(sql.toString());
				int parameterIndex = 1;

	            if (keyword != null && !keyword.isEmpty()) {
	                statement.setString(parameterIndex++, "%" + keyword + "%");
	            }
	            
	            if (minPrice >= 0) {
	                statement.setDouble(parameterIndex++, minPrice);
	            }
	            
	            if (maxPrice >= 0) {
	                statement.setDouble(parameterIndex, maxPrice);
	            }

	            ResultSet s = statement.executeQuery();

	            while (s.next()) {
	            	System.out.println(s.getInt(1));
					System.out.println(s.getString(2));
					System.out.println(s.getString(3));
					System.out.println(s.getDouble(4));
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
            return product;
	        
	 

	}
	   }



