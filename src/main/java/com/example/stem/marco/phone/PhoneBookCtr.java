package com.example.stem.marco.phone;

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
@RequestMapping("/marco/phone")
public class PhoneBookCtr {
	
	private static Logger log = LoggerFactory.getLogger(PhoneBookCtr.class);
	
	private PhoneBookRep repo;

	public PhoneBookCtr(PhoneBookRep repo) {
		this.repo = repo;
	}
	
//	private PhoneBookSrv srv;
//	
//	public PhoneBookCtr(PhoneBookSrv srv) {
//		this.srv = srv;
//	}
	
//	@GetMapping("/insert")
//	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone, Model model) {
//		log.trace("enter insert()");
//		Contact contact = new Contact(firstName, lastName, phone);
//		srv.newAdd(contact);
//		model.addAttribute("contacts", srv.getAll());
//		return "/marco/phonebook/phonebook";
//	}
	
	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, phone);
		repo.save(contact);
		model.addAttribute("contacts", repo.findAll());
		return "/marco/phonebook/phonebook";
	}
	
//	@GetMapping()
//	public String home(Model model) {
//		log.trace("enter home");
//  	model.addAttribute("contacts", srv.getAll());
//		return "/marco/phonebook/phonebook";
//	}
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("contacts", repo.findAll());
		return "/marco/phonebook/phonebook";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam Integer id, Model model) {
		log.trace("remove contact");
		Optional<Contact> contact = repo.findById(id);
		contact.ifPresent(c -> repo.delete(c));
		model.addAttribute("contacts", repo.findAll());
		return "/marco/phonebook/phonebook";
	}
}
