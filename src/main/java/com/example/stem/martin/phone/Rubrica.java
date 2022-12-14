package com.example.stem.martin.phone;

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
	private RubricaRepository repo;

	public Rubrica(ContactList svc, RubricaRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("enter insert");
		if (firstName.isEmpty() || firstName.isBlank() || lastName.isEmpty() || lastName.isBlank() || phone.isEmpty()
				|| phone.isBlank()) {
			model.addAttribute("errorInsert", "compila tutto");
		} else {
			Contact contact = new Contact(firstName, lastName, phone);

			try {
				repo.save(contact);
			} catch (Exception ex) {
				log.error("insert fail", ex);
				model.addAttribute("numExist", "numero già esistente");

			}
		}
		model.addAttribute("contacts", repo.findAll());
		return "/martin/rubrica";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		log.trace("enter delete");
//		Optional<Contact> contact = repo.findById(id);
//		contact.ifPresent(c -> repo.delete(c));

		try {
			repo.deleteById(id);
		} catch (Exception ex) {
			model.addAttribute("errorDelete", "id " + id + " non trovato");
		}
		model.addAttribute("contacts", repo.findAll());
		return "/martin/rubrica";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", repo.findAll());
		return "/martin/rubrica";

	}
}
