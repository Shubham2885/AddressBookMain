package com.bz.addressbook.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	//single object -> singleton pattern
	private static final DBConnection instance = new DBConnection();
	
	private static final String userName = "root";
	private static final String password = "mysql";
	private static final String dbName = "address_book";
	private static final String hostName = "localhost";
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded...");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver is missing...");
		}
	}
	
	public static DBConnection getInstance() {
		return instance;
	}

	//Connection obj
	public Connection getConnection() {
		StringBuilder builder = new StringBuilder();
		builder.append("jdbc:mysql://");
		builder.append(hostName).append("/").append(dbName);
		String url = builder.toString();
		System.out.println(url);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println(connection);
			System.out.println("Connection is successfull...");
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
		}
		return connection;
	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		
//		Connection connection = DBConnection.getInstance().getConnection();
//		
//		//create statement and write query and execute query
//		Statement statement = connection.createStatement();
//		String sql = "select * from contact;";
//		
//		ResultSet resultSet =  statement.executeQuery(sql);
//		//retrieve the data
//		
//		while(resultSet.next()) {
//			System.out.println("************************************************");
//			System.out.println("address id = "+ resultSet.getLong("addressId"));
//			System.out.println("firstname = "+ resultSet.getString("firstName"));
//			System.out.println("lastName = "+ resultSet.getString("lastName"));
//			System.out.println("address = "+ resultSet.getString("address"));
//			System.out.println("city = "+ resultSet.getString("city"));
//			System.out.println();
//		}
//		//close connection
//		
//		statement.close();
//		connection.close();
//	}
}
