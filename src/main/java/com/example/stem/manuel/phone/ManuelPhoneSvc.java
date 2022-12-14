package com.example.stem.manuel.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class ManuelPhoneSvc {
	private List<Contact> contacts;

	public ManuelPhoneSvc() {
		this.contacts = new ArrayList<>();
		this.contacts.add(new Contact("Alexander", "Hunold", "54556"));
	}

	public List<ManuelContatti> getAll() {
		List<ManuelContatti> result = new ArrayList<>();

		result.add(new ManuelContatti("Alexander", "Hunold", "8_997.85"));

		return result;
	}

	public List<Contact> add(Contact contact) {
		contacts.add(contact);
		return contacts;

	}
}
