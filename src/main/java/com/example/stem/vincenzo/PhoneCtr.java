package com.example.stem.vincenzo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vincenzo/phone")
public class PhoneCtr {
	private static Logger log = LoggerFactory.getLogger(PhoneCtr.class);
	private PhoneSvc svc;

	public PhoneCtr(PhoneSvc svc) {
		this.svc = svc;
	}

	@GetMapping("/insert")
	public String insert(String firstName, String lastName, String number, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, number);
		model.addAttribute("contacts", svc.Add(contact));
		return "phonebook";
	}

	@GetMapping("/delete")
	public String delete(String firstName, String lastName, String number, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, number);
		model.addAttribute("contacts", svc.Delete(contact));
		return "phonebook";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", svc.getAll());
		return "phonebook";
	}
}
