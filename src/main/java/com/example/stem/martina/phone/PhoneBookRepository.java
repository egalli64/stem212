package com.example.stem.martina.phone;

import org.springframework.data.repository.CrudRepository;

import com.example.stem.dao.Contact;

public interface PhoneBookRepository extends CrudRepository<Contact, Integer>{
	
}