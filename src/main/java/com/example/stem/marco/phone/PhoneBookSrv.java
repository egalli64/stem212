package com.example.stem.marco.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class PhoneBookSrv {
	private List<Contact> contacts;
	
	public PhoneBookSrv() {
		this.contacts= new ArrayList<>();
		
		contacts.add(new Contact("Marco", "Bo", "345"));
		contacts.add(new Contact("Tom", "Ba", "378"));
		}

	public List<Contact> getAll() {
		return contacts;
	}
	
	public List<Contact> newAdd(Contact contact) {
		contacts.add(contact);
		return contacts;
	}
}
