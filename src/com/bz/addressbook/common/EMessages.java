package com.bz.addressbook.common;

public enum EMessages {

	MOBILE_NUMBER_MESSAGE("Invalid Mobile Number..."),
	EMAIL_MESSAGE(""),
	START_WITH_CAP_MESSAGE("Please Start With Capital Letter....");
	
	String constant;
	
	EMessages(final String constant){
		this.constant = constant;
	}
	
	public String getValue() {
		return this.constant;
	}
}
