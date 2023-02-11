package com.bz.addressbook.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bz.addressbook.exception.InvalidMobileNumberException;
import com.bz.addressbook.exception.StartWithCapitalLetterException;

public class RegexUtil {
	
	public static boolean isStartWithCapitalLetter(String input) throws StartWithCapitalLetterException {
		boolean result = null == input ? false : getMatcher(ERegexPatter.START_WITH_CAP_LETTER.getValue(), input).find();
		if(!result) {
			throw new StartWithCapitalLetterException("Please Start With Capital Letter....");
		}
		return result;
	}

	public static boolean isValidMobileNumber(String input) throws InvalidMobileNumberException {
		boolean result = getMatcher(ERegexPatter.MOBILE_NUMBER_PATTERN.getValue(), input).find();
		if(!result) {
			throw new InvalidMobileNumberException("Invalid Mobile Number...");
		}
		return result;
	}
	
	private static Matcher getMatcher(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher;
	}

	public static boolean isValidEmail(String input) {
		return getMatcher(ERegexPatter.EMAIL_PATTERN.getValue(), input).find();
	}

}
