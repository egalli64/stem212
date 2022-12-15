package com.example.stem.sample.line2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.stem.dao.Contact;

@Repository("ContactRepoLine2")
public interface ContactRepo extends CrudRepository<Contact, Integer> {
}
