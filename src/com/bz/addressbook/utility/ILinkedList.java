package com.bz.addressbook.utility;

public interface ILinkedList <T> {
	<T> void add(T data);
	
	void printLinkedList();
	
	int size();
}
