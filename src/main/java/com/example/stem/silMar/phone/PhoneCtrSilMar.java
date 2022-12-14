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
	private PhoneSvcSilMar svc;

	public PhoneCtrSilMar(PhoneSvcSilMar svc) {
		this.svc = svc;
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String phone, Model model) {
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, phone);
		svc.add(contact);
		model.addAttribute("contacts", svc.getAll());
		return "/silMar/phoneBook";
	}
		
	@GetMapping
	public String home(Model model) {
		log.trace("enter home()");
		model.addAttribute("contacts", svc.getAll());
		return "silMar/phoneBook";
	}
}
