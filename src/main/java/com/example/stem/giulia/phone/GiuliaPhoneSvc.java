package com.example.stem.giulia.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class GiuliaPhoneSvc {
	private List<Contact> contacts;
	
	public GiuliaPhoneSvc() {
		this.contacts = new ArrayList<>();
		this.contacts.add(new Contact("Alexander", "Hunold", "567463"));
	}
	
    public List<Contact> getAll() {
        return contacts;
    }
    
    public void add(Contact contact) {
        contacts.add(contact);
    }
}
