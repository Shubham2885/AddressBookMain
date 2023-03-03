package com.bz.addressbook.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

import com.bz.addressbook.model.Contacts;
import com.google.gson.Gson;

public class FileHandling {
	
	private List<Contacts> list;
	final static String pathAndFileName = "AddressBook.json";
	private File file;
	private FileWriter fileWriter;
	private Scanner scanner;
	
	public FileHandling() {
		file = new File(pathAndFileName);
	}
	
	public List<Contacts> writeContact(Contacts contacts) {
		list = readAllContacts();
		if(null == list) {
			list = new ArrayList<Contacts>();
		}
		list.add(contacts);
		Gson gson = new Gson();
		String jsonData = gson.toJson(list);
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(jsonData);
			System.out.println("Data is writtern...");
			fileWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return list;
	}
	
	public List<Contacts> readAllContacts() {
		try {
			scanner = new Scanner(file);
			final String jsonData = scanner.nextLine();
			
			Gson gson = new Gson();
			Contacts[] listArray = gson.fromJson(jsonData, Contacts[].class);
			list = new ArrayList<Contacts>(Arrays.asList(listArray));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
}
