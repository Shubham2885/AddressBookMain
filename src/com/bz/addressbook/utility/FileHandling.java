package com.bz.addressbook.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.bz.addressbook.model.Contacts;

public class FileHandling {
	
	public static void writeContact(Contacts contacts) {
		
	}
	
	public static void readAllContacts() {
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		final String pathAndFileName = "AddressBook.txt";
		File file = new File(pathAndFileName);
		
		final Contacts contacts = new Contacts();
		contacts.setAddress("At Post Nagpur");
		contacts.setFirstName("SHubham");
		contacts.setLastName("Chavan");
		
//		PrintWriter printWriter = new PrintWriter(file);
		
		Scanner  scanner = new Scanner(file);
		try {
//			System.out.println(file.createNewFile());
			System.out.println("File Exist : "+file.exists());
			System.out.println("Path : "+file.getAbsolutePath());
			System.out.println("CanonicalPath : "+file.getCanonicalPath());
			
//			printWriter.write(contacts.toString());
//			System.out.println("Data writen...");
			
			System.out.println("Data is reading...");
			while(scanner.hasNext()) {
				String data = scanner.nextLine();
				System.out.print(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			printWriter.close();
		}
	}
}
