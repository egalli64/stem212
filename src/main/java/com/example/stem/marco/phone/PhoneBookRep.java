package com.example.stem.marco.phone;

import org.springframework.data.repository.CrudRepository;

import com.example.stem.dao.Contact;

public interface PhoneBookRep extends CrudRepository<Contact, Integer> {

}