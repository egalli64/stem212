package com.example.stem.isabella.phone;

import org.springframework.data.repository.CrudRepository;

import com.example.stem.dao.Contact;

public interface PhoneRepo extends CrudRepository<Contact, Integer> {

}
