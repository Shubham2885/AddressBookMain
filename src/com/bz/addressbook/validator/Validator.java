package com.bz.addressbook.validator;

import java.lang.reflect.Field;

import com.bz.addressbook.annotation.Attribute;
import com.bz.addressbook.model.Contacts;
import com.bz.addressbook.utility.RegexUtil;

public class Validator {

	public static void validateFields(Contacts contacts) throws IllegalArgumentException, IllegalAccessException {

		Class<Contacts> class1 = (Class<Contacts>) contacts.getClass();
		Field[] fields = class1.getDeclaredFields();
		for(Field field : fields) {
			Attribute attribute = field.getAnnotation(Attribute.class);
			if(null != attribute) {
				field.setAccessible(true);
				validateField(field.getName(), field.get(contacts), attribute);
			}
		}
	}

	private static void validateField(String fieldName, Object data, Attribute attribute) {
		if(attribute.isMandatory() && fieldName != "phoneNumber") {
			String str = (String) data;
			RegexUtil.isStartWithCapitalLetter(str);
		}else if(attribute.isMandatory() && fieldName == "phoneNumber") {
			String str = (String) data;
			RegexUtil.isValidMobileNumber(str);
		}
	}
}
