package ua.epam.dana.persistant;

import java.sql.*;

public class ConnectionManager {
	
	 private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Dogs?serverTimezone=UTC&useSSL=false";
	 private static final String USER = "root";
	 private static final String PASSWORD = "1488";
	 
	 private static Connection connection = null;
	 
	 private ConnectionManager() {
	    }

	    public static Connection getConnection() {
	        if (connection == null) {
	            try {
	                connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
	            } catch (SQLException e) {
	                System.out.println("SQLException: " + e.getMessage());
	                System.out.println("SQLState: " + e.getSQLState());
	                System.out.println("VendorError: " + e.getErrorCode());
	            }
	        }
	        return connection;
	    }

}
