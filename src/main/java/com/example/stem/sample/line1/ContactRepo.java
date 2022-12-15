package com.example.stem.sample.line1;

import org.springframework.data.repository.CrudRepository;

import com.example.stem.dao.Contact;

public interface ContactRepo extends CrudRepository<Contact, Integer> {
}
