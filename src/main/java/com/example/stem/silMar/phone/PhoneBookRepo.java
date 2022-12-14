package com.example.stem.silMar.phone;

import org.springframework.data.repository.CrudRepository;

import com.example.stem.dao.Contact;

public interface PhoneBookRepo extends CrudRepository<Contact, Integer> {

}
