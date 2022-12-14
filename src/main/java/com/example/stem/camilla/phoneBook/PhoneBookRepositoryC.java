package com.example.stem.camilla.phoneBook;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.stem.dao.Contact;

public interface PhoneBookRepositoryC extends CrudRepository<Contact, Integer>{
	@Query("select c from Contact c where c.firstName like :string% or c.lastName like :string%")
    Iterable<Contact> findByStringIn(String string);
}
