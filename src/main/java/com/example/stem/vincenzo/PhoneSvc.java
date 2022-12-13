package com.example.stem.vincenzo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PhoneSvc {
	List<Contact> result = new ArrayList<>();

	public List<Contact> getAll() {
		result.add(new Contact("Alexander", "Hunold", "345"));
		return result;
	}

	public List<Contact> Add(Contact contact) {
		result.add(contact);
		return result;
	}

	public List<Contact> Delete(Contact contact) {
		result.remove(contact);
		return result;
	}

}
