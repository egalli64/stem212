package com.example.stem.vincenzo.phone;

import org.springframework.data.repository.CrudRepository;

import com.example.stem.dao.Contact;

public interface PhoneRepository extends CrudRepository<Contact, Integer> {

}
