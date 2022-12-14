package com.example.stem.camilla.phoneBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/camilla/phoneBook")
public class PhoneBookControllerC {
	private static Logger log = LoggerFactory.getLogger(PhoneBookControllerC.class);
	private PhoneBookRepositoryC repo;

	public PhoneBookControllerC(PhoneBookRepositoryC repo) {
		this.repo = repo;
	}

	@GetMapping()
	public String getAll(Model model) {
		log.trace("get all contacts");
		model.addAttribute("contacts", repo.findAll());
		return "/camilla/phoneBook/phoneBook";
	}

	@GetMapping("/insert")
	public String add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("add contact");
		if (firstName.isEmpty() || firstName.isBlank() || lastName.isEmpty() || lastName.isBlank() || phone.isEmpty()
				|| phone.isBlank()) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorInsert", "Devi compilare tutti i campi");
		} else {
			Contact contact = new Contact(firstName, lastName, phone);
			repo.save(contact);
			model.addAttribute("contacts", repo.findAll());
		}
		return "/camilla/phoneBook/phoneBook";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Integer id, Model model) {
		log.trace("remove contact");
		try {
			repo.deleteById(id);
			model.addAttribute("contacts", repo.findAll());
		} catch (Exception ex) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorDelete", "Impossibile eliminare l'entita con id pari a " + id);
		}
		return "/camilla/phoneBook/phoneBook";
	}
}
