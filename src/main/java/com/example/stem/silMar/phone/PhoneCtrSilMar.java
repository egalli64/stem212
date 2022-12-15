package com.example.stem.silMar.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/silMar/phone")
public class PhoneCtrSilMar {
	private static Logger log = LoggerFactory.getLogger(PhoneCtrSilMar.class);
	private PhoneBookRepo repo;

	public PhoneCtrSilMar(PhoneBookRepo repo) {
		this.repo = repo;
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("enter insert");
		Contact contact = new Contact(firstName, lastName, phone);
		if (firstName.isBlank() || lastName.isBlank() || phone.isBlank()) {
			model.addAttribute("badContact", contact);
		} else {
			try {
				repo.save(contact);
			} catch (Exception ex) {
				log.error("Insert Failure", ex);
				model.addAttribute("badContact", contact);
			}
		}

		model.addAttribute("contacts", repo.findAll());
		return "/silMar/phoneBook";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Integer id, Model model) {
		log.trace("enter remove");
		repo.findById(id).ifPresentOrElse(c -> repo.delete(c), () -> model.addAttribute("badId", id));
		model.addAttribute("contacts", repo.findAll());
		return "/silMar/phoneBook";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String string, Model model) {
		log.trace("search contacts");
		if (string.isBlank()) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorSearchMessage", "fill this field");
			return "/silMar/phoneBook";
		} else {
			model.addAttribute("contacts", repo.findByStringIn(string));
			return "/silMar/phoneBook";
		}
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", repo.findAll());
		return "/silMar/phoneBook";
	}
}
