package com.example.stem.camilla.phoneBook;

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
@RequestMapping("/camilla/phoneBook")
public class PhoneBookControllerC {
	private static Logger log = LoggerFactory.getLogger(PhoneBookControllerC.class);
	private PhoneBookRepositoryC repo;

	public PhoneBookControllerC(PhoneBookRepositoryC repo) {
		this.repo = repo;
	}

	@GetMapping()
	public String getAll(Model model) {
		log.trace("getAll method");
		model.addAttribute("contacts", repo.findAll());
		return "/camilla/phoneBook/phoneBook";
	}

	@GetMapping("/insert")
	public String add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("add method");
		firstName = firstName.trim();
		lastName = lastName.trim();
		phone = phone.trim();
		Contact contact = new Contact(firstName, lastName, phone);

		if (firstName.isEmpty() || firstName.isBlank() || lastName.isEmpty() || lastName.isBlank() || phone.isEmpty()
				|| phone.isBlank()) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorInsert", "Devi compilare tutti i campi");
			model.addAttribute("badContact", contact);
		} else {
			try {
				repo.save(contact);
			} catch (Exception ex) {
				log.error("Non sono riuscito a inserire", ex);
				model.addAttribute("badContact", contact);
				model.addAttribute("errorNumber", "Numero di telefono non accettabile");
			}
			model.addAttribute("contacts", repo.findAll());
		}
		return "/camilla/phoneBook/phoneBook";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Integer id, Model model) {
		log.trace("remove method");
		try {
			repo.deleteById(id);
			model.addAttribute("contacts", repo.findAll());
		} catch (Exception ex) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorDelete", "Impossibile eliminare l'entita con id pari a " + id);
		}
		return "/camilla/phoneBook/phoneBook";
	}

	@GetMapping("/search")
	public String search(@RequestParam String string, Model model) {
		log.trace("search method");
		if (string.isEmpty() || string.isBlank()) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorSearch", "Devi compilare il campo");
			return "/camilla/phoneBook/phoneBook";
		} else {
			model.addAttribute("contacts", repo.findByStringIn(string));
			model.addAttribute("string", string);
			return "/camilla/phoneBook/phoneBook";
		}
	}

	@GetMapping("/preModify")
	public String preModify(@RequestParam Integer id, Model model) {
		log.trace("preModify method");
		Optional<Contact> contact = repo.findById(id);
		if (contact.isPresent()) {
			model.addAttribute("contactToBeModified", contact.get());
		}
		model.addAttribute("contacts", repo.findAll());
		return "/camilla/phoneBook/phoneBook";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String phone, Model model) {
		log.trace("modify method");
		Optional<Contact> contact = repo.findById(id);
		if (contact.isPresent()) {
			try {
				contact.get().setFirstName(firstName);
				contact.get().setLastName(lastName);
				contact.get().setPhone(phone);
				repo.save(contact.get());
			} catch (Exception ex) {
				log.error("Non sono riuscito a inserire", ex);
				model.addAttribute("contactToBeModified", contact.get());
				model.addAttribute("errorNumberModify", "Numero di telefono non accettabile");
			}
		}
		model.addAttribute("contacts", repo.findAll());
		return "/camilla/phoneBook/phoneBook";
	}
}
