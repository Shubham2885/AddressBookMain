package com.bz.addressbook.interfaces;

import java.util.List;

import com.bz.addressbook.model.Contacts;

public interface IAddressBookDao {

	Long save(Contacts contacts);
	
	void udpate(Contacts contacts);
	
	boolean deleteById(Long id);
	
	Contacts findById(Long id);
	
	List<Contacts> findByFirstName(final String firstName);
	
	List<Contacts> findAll();
	
	void commit();
}
