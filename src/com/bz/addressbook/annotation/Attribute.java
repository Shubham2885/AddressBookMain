package com.bz.addressbook.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bz.addressbook.common.EMessages;
import com.bz.addressbook.common.ERegexPatter;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {
	boolean isMandatory() default false;
	int minLength() default 2;
	int maxLength() default 30;
	ERegexPatter regexPatter();
	EMessages messages();
}
