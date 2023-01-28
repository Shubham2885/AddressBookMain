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
			showContactDetails(contactsOfPersons[i]);
		}
	}

	@Override
	public void search(String firstName) {
		for(int i=0;i<contactsOfPersons.length;i++) {
			Contacts contacts = contactsOfPersons[i];
			if(null != contacts && firstName.equalsIgnoreCase(contacts.getFirstName())) {
				showContactDetails(contacts);
			}
		}
	}

	private void showContactDetails(Contacts contacts) {
		if(contacts != null) {
			System.out.println("******************Contact Details *******************");
			System.out.println("First Name = "+ contacts.getFirstName());
			System.out.println("Last Name = "+ contacts.getLastName());
			System.out.println("Address = "+ contacts.getAddress());
		}
	}
	
	private int findByMobileNumber(Long mobileNo) {
		for(int i=0;i<contactsOfPersons.length;i++) {
			Contacts contacts = contactsOfPersons[i];
			if(null != contacts && mobileNo == contacts.getPhoneNumber()) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void delete(long mobileNo) {
		int i = findByMobileNumber(mobileNo);
		if(i != -1) {
			contactsOfPersons[i] = null;
		}
		showAllContacts();
	}
}
