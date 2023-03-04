package com.bz.addressbook.service;

import java.util.List;

import com.bz.addressbook.dao.AddressBookDao;
import com.bz.addressbook.exception.InvalidMobileNumberException;
import com.bz.addressbook.exception.StartWithCapitalLetterException;
import com.bz.addressbook.interfaces.IAddressBook;
import com.bz.addressbook.interfaces.IAddressBookDao;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.utility.RegexUtil;
import com.bz.addressbook.validator.Validator;

public class AddressBookImpl implements IAddressBook {

//	private static Contacts[] contactsOfPersons = new Contacts[10];
//	private ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
	
//	private ILinkedList<Contacts> linkedList = new LinkedList<Contacts>();
//	private FileHandling fileHandling = new FileHandling();
	private IAddressBookDao addressBookDao;
	
	public AddressBookImpl() {
		addressBookDao = new AddressBookDao();
	}
	
	@Override
	public int createContact(Contacts contacts) throws InvalidMobileNumberException, StartWithCapitalLetterException {
		System.out.println("AddressBookImpl :: createContact :: contacts");
//		if(RegexUtil.isStartWithCapitalLetter(contacts.getFirstName())) {
//			if(RegexUtil.isValidMobileNumber(contacts.getPhoneNumber())) {
//				final List<Contacts> list = fileHandling.writeContact(contacts);
//				return list.size();
//			}
//		}else {
//			System.err.println("first latter should be capital...");
//		}
		try {
//			Validator.validateFields(contacts);
			addressBookDao.save(contacts);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 
//		catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		}
//		final List<Contacts> list = fileHandling.writeContact(contacts);
//		return list.size();
		return 0;
	}
	
//	private int getIndexForNextEmptyLocation() {
//		for(int i=0;i<contactsOfPersons.length;i++) {
//			if(null == contactsOfPersons[i]) {
//				return i;
//			}
//		}
//		return 0;
//	}

	@Override
	public void showAllContacts() {
//		System.out.println("Showing all contact details....");
//		for(int i=0;i<contactsList.size();i++) {
//			showContactDetails(contactsList.get(i));
//		}
//		linkedList.printLinkedList();
//		List<Contacts> contacts = fileHandling.readAllContacts();
		List<Contacts> contacts = addressBookDao.findAll();
		for(Contacts contacts2 : contacts) {
			showContactDetails(contacts2);
		}
	}

	@Override
	public void search(String firstName) {
//		for(int i=0;i<contactsList.size();i++) {
//			Contacts contacts = contactsList.get(i);
//			if(null != contacts && firstName.equalsIgnoreCase(contacts.getFirstName())) {
//				showContactDetails(contacts);
//			}
//		}
		List<Contacts> contacts = addressBookDao.findByFirstName(firstName);
		for(Contacts contacts2 : contacts) {
			showContactDetails(contacts2);
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
//		for(int i=0;i<contactsList.size();i++) {
//			Contacts contacts = contactsList.get(i);
//			if(null != contacts && mobileNo == contacts.getPhoneNumber()) {
//				return i;
//			}
//		}
		return -1;
	}

	@Override
	public void delete(long mobileNo) {
//		int i = findByMobileNumber(mobileNo);
//		if(i != -1) {
//			contactsList.remove(i);
//		}
//		showAllContacts();
	}

	@Override
	public void commit() {
		addressBookDao.commit();
	}
}
