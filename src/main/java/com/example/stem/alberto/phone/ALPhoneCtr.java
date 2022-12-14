package com.example.stem.alberto.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/alberto/phone")
public class ALPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(ALPhoneCtr.class);
	private ALPhoneRepository repo;

	public ALPhoneCtr(ALPhoneRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/add")
	public String add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		firstName = firstName.trim();
		lastName = lastName.trim();
		phone = phone.trim();
		log.trace("enter insert({},{},{})", firstName, lastName, phone);
		Contact contact = new Contact(firstName, lastName, phone);
		if (firstName.isBlank() || lastName.isBlank() || phone.isBlank()) {
			model.addAttribute("badContact", contact);
		} else {
			try {
				repo.save(contact);
			} catch (Exception ex) {
				log.error("insert failure", ex);
				model.addAttribute("badContact", contact);
			}
		}
		model.addAttribute("contacts", repo.findAll());
		return "/alberto/phone/alPhoneBook";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Integer id, Model model) {
		log.trace("enter remove()");
		repo.findById(id).ifPresentOrElse(c -> repo.delete(c), () -> model.addAttribute("badId", id));
		model.addAttribute("contacts", repo.findAll());
		return "/alberto/phone/alPhoneBook";
	}
	
	@GetMapping("/preModify")
	public String preModify(@RequestParam Integer id, Model model) {
		log.trace("enter modify()");
		repo.findById(id).ifPresentOrElse(c -> model.addAttribute("modContact", c), () -> model.addAttribute("modBadId", id));
		model.addAttribute("contacts", repo.findAll());
		return"/alberto/phone/alPhoneBook";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("enter modify()");
		Contact mContact= repo.findById(id).get();
		mContact.setFirstName(firstName);
		mContact.setLastName(lastName);
		mContact.setPhone(phone);
		repo.save(mContact);
		model.addAttribute("contacts", repo.findAll());
		return"/alberto/phone/alPhoneBook";
	}

	@GetMapping()
	public String home(Model model) {
		log.trace("enter home()");
		model.addAttribute("contacts", repo.findAll());
		return "/alberto/phone/alPhoneBook";
	}
}
