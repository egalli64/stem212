package com.example.stem.silMar.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.stem.dao.Contact;

@Service
public class PhoneSvcSilMar {
private List<Contact> contacts = new ArrayList<>();
	
    public List<Contact> getAll() {
        return contacts;
    }
    
    public List<Contact> insert(Contact contact) {
    	contacts.add(contact);
    	return contacts;
    }
    
    public List<Contact> remove(Contact contact){
    	contacts.remove(contact);
    	return contacts;
    }

}