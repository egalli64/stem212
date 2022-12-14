package com.example.stem.martina.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/martina/phone")
public class PhoneBookController {
	private static Logger log = LoggerFactory.getLogger(PhoneBookController.class);
	private PhoneBookSvc svc;

	// private phoneBookRepository repo;

	// public phoneBookController(phoneBooksvc svc, phoneBookRepository repo) {
	public PhoneBookController(PhoneBookSvc svc) {
		this.svc = svc;
		// this.repo=repo;
	}

	@PostMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		log.trace("enter insert");

		Contact contact = new Contact(firstName, lastName, phone);
		svc.insert(contact);
		model.addAttribute("contacts", svc.getAll());

		// repo.save(contacts);
		// model.addAttribute("contcts", repo.findAll());

		return "/martina/phoneBook/phoneBook";

	}

	@PostMapping("/delete")
	public String delete(@RequestParam String phone, Model model ) {
		log.trace("delete contact");
		Contact contact=new Contact();
		svc.delete(contact);
		model.addAttribute("contacts", svc.getAll());
		return "/martina/phoneBook/phoneBook" ;
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", svc.getAll());
		return "/martina/phoneBook/phoneBook";
	}

}