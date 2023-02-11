package com.bz.addressbook.interfaces;

import com.bz.addressbook.exception.InvalidMobileNumberException;
import com.bz.addressbook.exception.StartWithCapitalLetterException;
import com.bz.addressbook.model.Contacts;

public interface IAddressBook {

	int createContact(Contacts contacts) throws InvalidMobileNumberException, StartWithCapitalLetterException;
	void showAllContacts();
	void search(String firstName);
	void delete(long mobileNo);
}
