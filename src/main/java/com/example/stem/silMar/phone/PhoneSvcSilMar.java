package com.example.stem.silMar.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PhoneSvcSilMar {
	private List<ContactSilMar> result;
	
	public PhoneSvcSilMar() {
		this.result = new ArrayList<>();
	}
	
	public List<ContactSilMar> getAll() {
		this.result.add(new ContactSilMar("Alexander", "Hunold", "34567428"));
		return this.result;
	}
	
	public List<ContactSilMar> add(ContactSilMar contact) {
		this.result.add(contact);
		return this.result;
	}
}
