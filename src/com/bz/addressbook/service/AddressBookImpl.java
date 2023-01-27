package com.bz.addressbook.service;

import com.bz.addressbook.interfaces.IAddressBook;
import com.bz.addressbook.model.Contacts;

public class AddressBookImpl implements IAddressBook {

	private static Contacts[] contactsOfPersons = new Contacts[10];
	@Override
	public int createContact(Contacts contacts) {
		System.out.println("AddressBookImpl :: createContact :: contacts");
		System.out.println(contacts);
		int index = getIndexForNextEmptyLocation();
		System.out.println("index : "+index);
		contactsOfPersons[index] = contacts;
		return index;
	}
	
	private int getIndexForNextEmptyLocation() {
		for(int i=0;i<contactsOfPersons.length;i++) {
			if(null == contactsOfPersons[i]) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public void showAllContacts() {
		System.out.println("Showing all contact details....");
		for(int i=0;i<contactsOfPersons.length;i++) {
			System.out.println(contactsOfPersons[i]);
		}
	}

}
