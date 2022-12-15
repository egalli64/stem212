package com.example.stem.silviaG.phone;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.stem.dao.Contact;

public interface SilviagPhoneRepository extends CrudRepository<Contact, Integer> {
	@Query("select c from Contact c where c.firstName like :string% or c.lastName like :string% order by c.lastName")
    Iterable<Contact> findByStringIn(String string);
}