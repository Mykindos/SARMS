package deakin.edu.au.sarms.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Tom Hoogstra - SIT215123867 (21/05/2017)
 *
 */


public class Connect {
	
	public static Connection connection;


	/**
	 * Database details
	 */
	public static final String sqlServer = "144.217.242.133";
	public static final String sqlUsername = "admin";
	public static final String sqlPassword = "12345";
	public static final String sqlDataBaseName = "SARMS";
	public static final int sqlPort = 3306;


	public static String url;

	/**
	 * Establishes the connection to the MYSQL Database
	 * Database is hosted in United States, expect small delays
	 */
	public Connect(){
		
		url = "jdbc:mysql://" + sqlServer + "/" + sqlDataBaseName;
		try {
			connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
		} catch (SQLException ex) {
			System.out.println("Connection> Cannot open SQL connection. " + sqlServer);
		}
	}

	
	/*
	 * If the connection is dropped at any point,
	 * calling this function will recreate it.
	 */
	public static void openConnection() {
		try {
			connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
		} catch (SQLException ex) {
			System.out.println("Connection> Cannot open SQL connection.");
		}
	}

	/**
	 * Check if the connection to the database is open
	 * @return True if their is a connection to the MYSQL database
	 */
	public static boolean isConnected() {
		try {
			if (!connection.isClosed()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Connection> Cannot check if SQL is connected.");
		}
		return false;
	}

	
	/**
	 * If the connection is null, it recreates it
	 * @return The connection
	 */
	public static Connection getConnection() {
		if(connection == null){
			try {
				connection = DriverManager.getConnection(url, sqlUsername, sqlPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}

	
	/**
	 * Closes the connection
	 */
	public static void disableSQL() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException ex) {
			System.out.println("Connection> Cannot close SQL connection.");
		}
	}
}
