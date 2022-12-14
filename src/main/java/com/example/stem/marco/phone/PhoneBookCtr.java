package com.example.stem.marco.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/marco/phonebook")
public class PhoneBookCtr {
	private PhoneBookSrv srv;
	
	private static Logger log = LoggerFactory.getLogger(PhoneBookCtr.class);
	
	public PhoneBookCtr(PhoneBookSrv srv) {
		this.srv = srv;
	}
	
	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, phone);
		srv.newAdd(contact);
		model.addAttribute("contacts", srv.getAll());
		return "/marco/phonebook/phonebook";
	}
	
	@GetMapping()
	public String home(Model model) {
		log.trace("enter home");
  	model.addAttribute("contacts", srv.getAll());
		return "/marco/phonebook/phonebook";
	}
	
//	@GetMapping("/remove")
//	public String remove(@RequestParam String phone, Model model) {
//		log.trace("enter remove()");
//		srv.remove(conatct);
//		reutrn"marco/phonebook/removed";
//	}
}
