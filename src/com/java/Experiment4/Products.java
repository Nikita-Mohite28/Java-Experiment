package com.java.Experiment4;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public class Products {
    public static void main(String[] args) { 
        // Database name corrected
        String url = "jdbc:mysql://localhost:3306/ProductDB";  
        String username = "root";  
        String password = "root123";  

        // Table name and columns corrected
        String query = "SELECT * FROM Products";  
          try {   
            Class.forName("com.mysql.cj.jdbc.Driver");  

            // Establish connection  
            Connection c = DriverManager.getConnection(url, username, password); 

            // Create a statement  
            Statement st = c.createStatement();  

            // Execute query
            ResultSet rs = st.executeQuery(query); 

            // Display data
            while(rs.next()) { 
                System.out.println("Id: " + rs.getInt("Product_id") + " , Name: " + rs.getString("Product_name") + ", Price: " + rs.getDouble("Product_price")); 
            } 

            // Close resources
            rs.close();
            st.close();
            c.close();  
            System.out.println("Connection closed.");  

        } catch (ClassNotFoundException e) {  
            System.err.println("JDBC Driver not found: "+ e.getMessage());  
        } catch (SQLException e) {  
            System.err.println("SQL Error: " + e.getMessage());  
        }  
    } 
}