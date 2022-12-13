package com.example.stem.martin.phone;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContactList {
	private List<Contact> contacts;

	public ContactList() {
		this.contacts = new ArrayList<>();
		contacts.add(new Contact("tom", "123"));
	}

	public List<Contact> getAll() {

		return contacts;
	}

	public void add(Contact contact) {
		contacts.add(contact);

	}

}
