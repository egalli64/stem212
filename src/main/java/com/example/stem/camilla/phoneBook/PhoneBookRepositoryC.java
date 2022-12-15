package com.example.stem.camilla.phoneBook;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.stem.dao.Contact;

public interface PhoneBookRepositoryC extends CrudRepository<Contact, Integer>{
	@Query("select c from Contact c where c.firstName like :string% or c.lastName like :string%")
    Iterable<Contact> findByStringIn(String string);
	
	@Query("select c from Contact c order by c.lastName, c.firstName")
    Iterable<Contact> orderByLastName();
	
	@Query("select c from Contact c order by c.firstName, c.lastName")
    Iterable<Contact> orderByFirstName();
	
	@Query("select c from Contact c where c.firstName like :string% or c.lastName like :string% order by c.firstName, c.lastName")
    Iterable<Contact> findByStringInAndOrderByFirstName(String string);
	
	@Query("select c from Contact c where c.firstName like :string% or c.lastName like :string% order by c.lastName, c.firstName")
    Iterable<Contact> findByStringInAndOrderByLastName(String string);
}
