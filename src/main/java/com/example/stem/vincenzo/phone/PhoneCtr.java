package com.example.stem.vincenzo.phone;

import java.util.Optional;

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
		try {
			repo.save(contact);
		} catch (Exception ex) {
			log.error("Insert failure");
			model.addAttribute("badContact", contact);
		}
		model.addAttribute("contacts", repo.findAll());
		return "/vincenzo/phonebook";
	}

	@GetMapping("/delete")
	public String delete(Integer ID, Model model) {
		log.trace("enter insert()");
		try {
			repo.deleteById(ID);
		} catch (Exception ex) {
			log.error("Delete failure");
			model.addAttribute("badID", ID);
		}
		model.addAttribute("contacts", repo.findAll());
		return "/vincenzo/phonebook";
	}

	@GetMapping("/call")
	public String call(Integer id, Model model) {
		log.trace("enter insert()");
		Optional<Contact> contact = repo.findById(id);
		if (contact.isPresent()) {
			model.addAttribute("contact", contact.get());
			return "/vincenzo/calling";
		} else {
			model.addAttribute("badCallID", id);
			model.addAttribute("contacts", repo.findAll());
			return "/vincenzo/phonebook";
		}
	}

	@GetMapping("/modify")
	public String modify(Integer id, Model model) {
		log.trace("enter insert()");
		Optional<Contact> contact = repo.findById(id);
		model.addAttribute("flag", contact.isPresent());
		return "/vincenzo/phonebook";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", repo.findAll());
		return "/vincenzo/phonebook";
	}
}
