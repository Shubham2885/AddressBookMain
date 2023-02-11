package com.bz.addressbook.utility;

public interface IRegexUtil {

	boolean isStartWithCapitalLetter(final String input);
	boolean isValidMobileNumber(final String input);
	boolean isValidEmail(final String input);
}
