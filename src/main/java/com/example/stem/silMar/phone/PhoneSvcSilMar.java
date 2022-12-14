package com.example.stem.silMar.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class PhoneSvcSilMar {
	private List<Contact> contacts;

	public PhoneSvcSilMar() {
		this.contacts = new ArrayList<>();
		this.contacts.add(new Contact("Alexander", "Hunold", "3456754"));

	}

	public List<Contact> getAll() {
		return contacts;
	}

	public void add(Contact conctat) {
		contacts.add(conctat);
	}
}