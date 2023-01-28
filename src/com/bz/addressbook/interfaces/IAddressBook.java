package com.bz.addressbook.interfaces;

import com.bz.addressbook.model.Contacts;

public interface IAddressBook {

	int createContact(Contacts contacts);
	void showAllContacts();
	void search(String firstName);
	void delete(long mobileNo);
}
