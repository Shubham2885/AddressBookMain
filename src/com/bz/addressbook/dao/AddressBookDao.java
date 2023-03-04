package com.bz.addressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bz.addressbook.exception.StartWithCapitalLetterException;
import com.bz.addressbook.interfaces.IAddressBookDao;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.utility.DBConnection;

public class AddressBookDao implements IAddressBookDao {

	private Connection connection;
//	private Statement statement;
	private PreparedStatement preparedStatement;

	public AddressBookDao() {
		connection = DBConnection.getInstance().getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Long save(Contacts contacts) {
		
		String query = "insert into contact(firstName, lastName, address, city, state) values(?, ?, ?, ?, ?);";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, contacts.getFirstName());
			preparedStatement.setString(2, contacts.getLastName());
			preparedStatement.setString(3, contacts.getAddress());
			preparedStatement.setString(4, contacts.getCity());
			preparedStatement.setString(5, contacts.getState());
			preparedStatement.execute();
			
			if("test".equals(contacts.getFirstName())) {
				throw new StartWithCapitalLetterException("testing error...");
			}
		} catch (SQLException | StartWithCapitalLetterException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			};
		} 
		return null;
	}

	@Override
	public void udpate(Contacts contacts) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacts findById(Long id) {
		Contacts conObj = null;
		try {
//			statement = connection.createStatement();
			String sql = "select * from contact where addressId = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet =  preparedStatement.executeQuery();

			while(resultSet.next()) {
				conObj = new Contacts();
				conObj.setId(resultSet.getLong("addressId"));
				conObj.setFirstName(resultSet.getString("firstName"));
				conObj.setLastName(resultSet.getString("lastName"));
				conObj.setAddress(resultSet.getString("address"));
				conObj.setCity(resultSet.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conObj;
	}

	@Override
	public List<Contacts> findAll() {
		//create statement and write query and execute query
		List<Contacts> contacts = null;
		try {
			String sql = "select * from contact;";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet =  preparedStatement.executeQuery();

			contacts = new ArrayList<Contacts>();

			while(resultSet.next()) {
				Contacts conObj = new Contacts();
				conObj.setId(resultSet.getLong("addressId"));
				conObj.setFirstName(resultSet.getString("firstName"));
				conObj.setLastName(resultSet.getString("lastName"));
				conObj.setAddress(resultSet.getString("address"));
				conObj.setCity(resultSet.getString("city"));
				contacts.add(conObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public List<Contacts> findByFirstName(String firstName) {
		//create statement and write query and execute query
		List<Contacts> contacts = null;
		try {
			String sql = "select * from contact where firstName = ?;";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			ResultSet resultSet =  preparedStatement.executeQuery();

			contacts = new ArrayList<Contacts>();

			while(resultSet.next()) {
				Contacts conObj = new Contacts();
				conObj.setId(resultSet.getLong("addressId"));
				conObj.setFirstName(resultSet.getString("firstName"));
				conObj.setLastName(resultSet.getString("lastName"));
				conObj.setAddress(resultSet.getString("address"));
				conObj.setCity(resultSet.getString("city"));
				contacts.add(conObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public void commit() {
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
