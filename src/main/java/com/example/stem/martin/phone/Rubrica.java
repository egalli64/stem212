package com.example.stem.martin.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/martin/phone")
public class Rubrica {
	private static Logger log = LoggerFactory.getLogger(Rubrica.class);
	private ContactList svc;

	public Rubrica(ContactList svc) {
		this.svc = svc;
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String name, @RequestParam String number, Model model) {
		log.trace("enter insert");
		Contact contact = new Contact(name, number);
		svc.add(contact);
		model.addAttribute("contacts", svc.getAll());
		return "/rubrica";
	}

	@GetMapping("/delete")
	public String delete() {
		log.trace("enter delete");

		return "/rubrica";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", svc.getAll());
		return "/rubrica";

	}
}
