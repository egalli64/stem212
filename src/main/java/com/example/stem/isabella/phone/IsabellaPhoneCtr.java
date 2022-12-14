package com.example.stem.isabella.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/isabella/phone")
public class IsabellaPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(IsabellaPhoneCtr.class);
	private IsabellaPhoneSvc svc;

	public IsabellaPhoneCtr(IsabellaPhoneSvc svc) {
		this.svc = svc;
	}
	@GetMapping("/delete")
	public String delete() {
		log.trace("delete contact");	
		return "/isabella/phonebook";
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String name, @RequestParam String lastname, @RequestParam String number, Model model) {
		log.trace("enter insert()");
		IsabellaContact contact = new IsabellaContact(name, lastname, number);
		svc.add(contact);
		model.addAttribute("contacts", svc.getAll());
		return "/isabella/phonebook";
	}

	@GetMapping
	public String home(Model model) {
		model.addAttribute("contacts", svc.getAll());
		return "/isabella/phonebook";
	}
}
