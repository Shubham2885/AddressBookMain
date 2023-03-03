package com.bz.addressbook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bz.addressbook.interfaces.IAddressBookDao;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.utility.DBConnection;

public class AddressBookDao implements IAddressBookDao {

	private Connection connection;
	private Statement statement;

	public AddressBookDao() {
		connection = DBConnection.getInstance().getConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Long save(Contacts contacts) {
		String query = "insert into contact(firstName, lastName, address, city, state) values('"+contacts.getFirstName()+"', '"+contacts.getLastName()+"', '"+contacts.getAddress()+"', '"+contacts.getCity()+"', '"+contacts.getState()+"');";
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
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
			statement = connection.createStatement();
			String sql = "select * from contact where addressId = "+id+";";

			ResultSet resultSet =  statement.executeQuery(sql);

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

			ResultSet resultSet =  statement.executeQuery(sql);

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
			String sql = "select * from contact where firstName = '"+firstName+"';";

			ResultSet resultSet =  statement.executeQuery(sql);

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

}
