package com.example.stem.silviaG.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class PhoneSvc {
	private List<Contact> contacts;
	
	public PhoneSvc() {
		this.contacts = new ArrayList<>();
		this.contacts.add(new Contact("Ale", "H", "345"));
	}
	
	public List<Contact> getAll() {
		return contacts;
	}
	
	public void add(Contact conctat) {
		contacts.add(conctat);
	}
}