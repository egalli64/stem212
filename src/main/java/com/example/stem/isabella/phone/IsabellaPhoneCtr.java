package com.example.stem.isabella.phone;

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
@RequestMapping("/isabella/phone")
public class IsabellaPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(IsabellaPhoneCtr.class);
	private PhoneRepo repo;

	public IsabellaPhoneCtr(PhoneRepo repo) {
		this.repo = repo;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		log.trace("delete contact");
		Optional<Contact> contact = repo.findById(id);
		contact.ifPresent(c -> repo.delete(c));
		model.addAttribute("contacts", repo.findAll());
		return "/isabella/phonebook";
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, phone);
		repo.save(contact);
		model.addAttribute("contacts", repo.findAll());
		return "/isabella/phonebook";
	}

	@GetMapping
	public String home(Model model) {
		model.addAttribute("contacts", repo.findAll());
		return "/isabella/phonebook";
	}
}
