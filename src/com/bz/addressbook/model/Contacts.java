package com.bz.addressbook.model;

import com.bz.addressbook.annotation.Attribute;
import com.bz.addressbook.common.EMessages;
import com.bz.addressbook.common.ERegexPatter;

public class Contacts {

	//mandatory
	private Long id;
	@Attribute(isMandatory = true, minLength = 2, maxLength = 10, regexPatter = ERegexPatter.START_WITH_CAP_LETTER, messages = EMessages.START_WITH_CAP_MESSAGE)
	private String firstName;
	//mandatory
	@Attribute(isMandatory = true, minLength = 2, maxLength = 10, regexPatter = ERegexPatter.START_WITH_CAP_LETTER, messages = EMessages.START_WITH_CAP_MESSAGE)
	private String lastName;
	private String address;
	private String city;
	private String state;
	@Attribute(isMandatory = true, minLength = 2, maxLength = 10, regexPatter = ERegexPatter.START_WITH_CAP_LETTER, messages = EMessages.START_WITH_CAP_MESSAGE)
	private int zip;
	//mandatory
	@Attribute(isMandatory = true, minLength = 10, maxLength = 10, regexPatter = ERegexPatter.MOBILE_NUMBER_PATTERN, messages = EMessages.MOBILE_NUMBER_MESSAGE)
	private String phoneNumber;
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Contacts [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
}
