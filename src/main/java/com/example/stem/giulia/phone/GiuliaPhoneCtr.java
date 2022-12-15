package com.example.stem.giulia.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;


@Controller
@RequestMapping("/giulia/phone")
public class GiuliaPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(GiuliaPhoneCtr.class);
	private PhoneRepositoryG repo;

	public GiuliaPhoneCtr(PhoneRepositoryG repo) {
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
		return "/giulia/phone/GiuliaPhoneBook";
	}
	
	
	
//	private static Logger log = LoggerFactory.getLogger(PhoneCtr.class);
//	private PhoneSvc svc;

//	public PhoneCtr(PhoneSvc svc) {
//		this.svc = svc;
//	}

//	@GetMapping("/insert")
//	public String insert(@RequestParam String name, @RequestParam String lastName, @RequestParam String number, Model model) {
//		log.trace("enter insert()");
//		Contact contact = new Contact(name, lastName, number);
//		svc.add(contact);
//		model.addAttribute("contacts", svc.getAll());
//		return "/phoneBook";
//	}
//
//	@GetMapping
//    public String home(Model model) {
//        log.trace("enter home");
//        model.addAttribute("contacts", svc.getAll());
//        return "phoneBook";
//    }
}
