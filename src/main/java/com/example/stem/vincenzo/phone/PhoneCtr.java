package com.example.stem.vincenzo.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/vincenzo/phone")
public class PhoneCtr {
	private static Logger log = LoggerFactory.getLogger(PhoneCtr.class);
	private PhoneRepository repo;

	public PhoneCtr(PhoneRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/insert")
	public String insert(String firstName, String lastName, String number, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, number);
		repo.save(contact);
		model.addAttribute("contacts", repo.findAll());
		return "/vincenzo/phonebook";
	}

	@GetMapping("/delete")
	public String delete(String firstName, String lastName, String number, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, number);
		repo.delete(contact);
		model.addAttribute("contacts", repo.findAll());
		return "/vincenzo/phonebook";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", repo.findAll());
		return "vincenzo/phonebook";
	}
}
