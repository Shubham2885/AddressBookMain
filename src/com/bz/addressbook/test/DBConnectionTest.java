package com.bz.addressbook.test;

import static org.junit.Assert.assertNull;

import java.sql.Connection;

import org.junit.Test;

import com.bz.addressbook.utility.DBConnection;

public class DBConnectionTest {

	@Test
	public void getConnectionTest() {
		DBConnection connection = DBConnection.getInstance();
		Connection connection2 = connection.getConnection();
		assertNull(connection2);
	}
}
