package com.java.Experiment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banking_System {

    public static void Fund_Transfer(int fromAccount, int toAccount, double Amount) {
        String url = "jdbc:mysql://localhost:3306/Banking_system";
        String username = "root";
        String password = "root123"; // Update your MySQL password

        Connection c = null;
        Statement st = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            c = DriverManager.getConnection(url, username, password);
            c.setAutoCommit(false);

            st = c.createStatement();

            // Display accounts before transfer
            rs = st.executeQuery("SELECT * FROM Account_Details");
            System.out.println("Before Transfer:");
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("Account_id") +
                        " , Name: " + rs.getString("Account_holder_name") +
                        ", Balance: " + rs.getDouble("Balance"));
            }

            // Check balance of sender
            String query = "SELECT Balance FROM Account_Details WHERE Account_id= ?";
            pst = c.prepareStatement(query);
            pst.setInt(1, fromAccount);
            rs = pst.executeQuery();

            if (rs.next()) {
                double Balance = rs.getDouble("Balance");

                if (Balance < Amount) {
                    System.out.println("Insufficient Balance");
                    return;
                }

                // Deduct from sender
                String Updatefromquery = "UPDATE Account_Details SET Balance = Balance - ? WHERE Account_id= ?";
                pst = c.prepareStatement(Updatefromquery);
                pst.setDouble(1, Amount);
                pst.setInt(2, fromAccount);
                int rowFrom = pst.executeUpdate();

                // Add to receiver
                String Updatetoquery = "UPDATE Account_Details SET Balance = Balance + ? WHERE Account_id= ?";
                pst = c.prepareStatement(Updatetoquery);
                pst.setDouble(1, Amount);
                pst.setInt(2, toAccount);
                int rowTo = pst.executeUpdate();

                // Commit or rollback
                if (rowFrom > 0 && rowTo > 0) {
                    c.commit();
                    System.out.println("Transfer Successful");
                } else {
                    c.rollback();
                    System.out.println("Transfer Failed");
                }
            } else {
                System.out.println("Sender Account Not found");
            }

            // Display accounts after transfer
            rs = st.executeQuery("SELECT * FROM Account_Details");
            System.out.println("After Transfer:");
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("Account_id") +
                        " , Name: " + rs.getString("Account_holder_name") +
                        ", Balance: " + rs.getDouble("Balance"));
            }

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Error occurred!");
            e.printStackTrace();
            try {
                if (c != null) c.rollback(); // Rollback on error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (pst != null) pst.close();
                if (c != null) c.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Fund_Transfer(1, 2, 1000);
    }
}