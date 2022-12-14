package com.example.stem.martin.phone;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/martin/phone")
public class Rubrica {
	private static Logger log = LoggerFactory.getLogger(Rubrica.class);
//	private ContactList svc;
	private RubricaRepository repo;

	public Rubrica(ContactList svc, RubricaRepository repo) {
//		this.svc = svc;
		this.repo = repo;
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("enter insert");
		Contact contact = new Contact(firstName, lastName, phone);
//		svc.add(contact);
//		model.addAttribute("contacts", svc.getAll());
		repo.save(contact);
		model.addAttribute("contacts", repo.findAll());
		return "/martin/rubrica";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		log.trace("enter delete");
		Optional<Contact> contact = repo.findById(id);
		contact.ifPresent(c -> repo.delete(c));

		model.addAttribute("contacts", repo.findAll());
		return "/martin/rubrica";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
//		model.addAttribute("contacts", svc.getAll());
		model.addAttribute("contacts", repo.findAll());
		return "/martin/rubrica";

	}
}
