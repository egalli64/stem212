package com.example.stem.alberto.phone;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/alberto/phone")
public class ALPhoneCtr {
//	private static Logger log = LoggerFactory.getLogger(PhoneCtr.class);
	private ALPhoneSvc svc;

	public ALPhoneCtr(ALPhoneSvc svc) {
		this.svc = svc;
	}

	@GetMapping("/add")
	public String add(@RequestParam String name, @RequestParam String surname, @RequestParam String number, Model model) {
		Contact contact = new Contact(name, surname, number);
		svc.add(contact);
		model.addAttribute("contacts", svc.getAll());
		return "/alberto/phone/alPhoneBook";
	}

	@GetMapping("/remove")
	public String remove() {
		return "/alberto/phone/alPhoneBook";
	}

	@GetMapping()
	public String home(Model model) {
		model.addAttribute("contacts", svc.getAll());
		return "/alberto/phone/alPhoneBook";
	}
}
