package com.bz.addressbook.utility;

public enum ERegexPatter {

	MOBILE_NUMBER_PATTERN("^[6-9][0-9]{9}$"),
	EMAIL_PATTERN("^[a-z]*[0-9]+@{1}[a-z]+.com$"),
	START_WITH_CAP_LETTER("^[A-Z][a-z]*$");
	
	String constant;
	private ERegexPatter(String constant) {
		this.constant = constant;
	}
	
	public String getValue() {
		return constant;
	}
}
