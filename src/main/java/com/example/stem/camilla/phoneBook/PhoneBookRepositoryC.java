package com.example.stem.camilla.phoneBook;

import org.springframework.data.repository.CrudRepository;
import com.example.stem.dao.Contact;

public interface PhoneBookRepositoryC extends CrudRepository<Contact, Integer>{
}
