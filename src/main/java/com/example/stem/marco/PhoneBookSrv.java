package com.example.stem.marco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PhoneBookSrv {
	private List<Person> result;
	
	public PhoneBookSrv() {
		this.result= new ArrayList<>();
		
		result.add(new Person("Marco", "Bo", "345"));
		result.add(new Person("Tom", "Ba", "378"));
		}

	public List<Person> getAll() {
		return result;
	}
	
	public List<Person> newAdd(Person person) {
		result.add(person);
		return result;
	}
}
