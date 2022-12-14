package com.example.stem.martina.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class PhoneBookSvc {
	private List<Contact> contacts = new ArrayList<>();
	
    public List<Contact> getAll() {
        return contacts;
    }
    
    public List<Contact> insert(Contact contact) {
    	contacts.add(contact);
    	return contacts;
    }
    
    public List<Contact> delete(Contact contact){
    	contacts.remove(contact);
    	return contacts;
    }
}