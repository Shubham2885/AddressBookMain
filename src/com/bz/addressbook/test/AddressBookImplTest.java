package com.bz.addressbook.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bz.addressbook.exception.InvalidMobileNumberException;
import com.bz.addressbook.exception.StartWithCapitalLetterException;
import com.bz.addressbook.interfaces.IAddressBook;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.service.AddressBookImpl;

public class AddressBookImplTest {
	
	private IAddressBook addressBook = new AddressBookImpl();
	
	@Before
	public void setUp() {
		
	}

	@Test
	public void createContactTest1() {
		Contacts contacts = new Contacts();
		contacts.setFirstName("Shubham");
		contacts.setPhoneNumber("8773488833");
		int result1 = addressBook.createContact(contacts);
		assertEquals(1, result1);
	}
	
	@Test
	public void createContactTest2() {
		Contacts contacts1 = new Contacts();
		contacts1.setFirstName("amol");
		contacts1.setPhoneNumber("8773488833");
		try {
			int result2 = addressBook.createContact(contacts1);
			assertEquals(0, result2);
		}catch (StartWithCapitalLetterException e) {
			assertEquals("Please Start With Capital Letter....", e.getMessage());
		}
		
	}
	
	@Test(expected = InvalidMobileNumberException.class)
	public void createContactTest3() {
		Contacts contacts = new Contacts();
		contacts.setFirstName("Rahul");
		contacts.setPhoneNumber("1773488833");
		int result = addressBook.createContact(contacts);
		assertEquals(0, result);
	}
}
