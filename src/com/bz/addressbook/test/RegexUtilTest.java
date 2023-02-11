package com.bz.addressbook.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bz.addressbook.utility.RegexUtil;

public class RegexUtilTest {

	@Test
	public void isStartWithCapitalLetterTest1() {
		boolean result = RegexUtil.isStartWithCapitalLetter("Shubham");
		assertTrue(result);
	}
	
	@Test
	public void isStartWithCapitalLetterTest2() {
		boolean result = RegexUtil.isStartWithCapitalLetter("ShuBham");
		assertFalse(result);
	}
	
	@Test
	public void isStartWithCapitalLetterTest3() {
		boolean result = RegexUtil.isStartWithCapitalLetter("ShubhaM");
		assertFalse(result);
	}
	
	@Test
	public void isStartWithCapitalLetterTest4() {
		boolean result = RegexUtil.isStartWithCapitalLetter("S********");
		assertFalse(result);
	}
	
	@Test
	public void isStartWithCapitalLetterTest5() {
		boolean result = RegexUtil.isStartWithCapitalLetter(null);
		assertFalse(result);
	}
}
