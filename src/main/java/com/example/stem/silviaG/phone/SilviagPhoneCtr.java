package com.example.stem.silviaG.phone;

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
@RequestMapping("/silviaG/phone")
public class SilviagPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(SilviagPhoneCtr.class);
	private SilviagPhoneSvc svc;
	private SilviagPhoneRepository repo;

	public SilviagPhoneCtr(SilviagPhoneSvc svc, SilviagPhoneRepository repo) {
		this.svc = svc;
		this.repo = repo;
	}

	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		phone = phone.trim();
		firstName = firstName.trim();
		lastName = lastName.trim();
		log.trace("enter insert()");
		Contact contact = new Contact(firstName, lastName, phone);
		if(firstName.isBlank()||lastName.isBlank()||phone.isBlank()) {
			model.addAttribute("badContact", contact);
		} else {
		// svc.add(contact);
			try {
				repo.save(contact);
			} catch (Exception ex) {
				log.error("Insert failure", ex);
				model.addAttribute("badContact", contact);
			}
		}
		// model.addAttribute("contacts", svc.getAll());
		model.addAttribute("contacts", repo.findAll());
		return "/silviaG/phoneBook/phoneBook";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		log.trace("delete contact");
		repo.findById(id).ifPresentOrElse(c -> repo.delete(c), () -> model.addAttribute("badId", id));
		model.addAttribute("contacts", repo.findAll());
		return "/silviaG/phoneBook/phoneBook";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam String string, Model model) {
		log.trace("search contacts");
		if (string.isBlank()) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorSearchMessage", "Chi cerchi?");
			return "/silviaG/phoneBook/phoneBook";
		} else {
			model.addAttribute("contacts", repo.findByStringIn(string));
			//model.addAttribute("string", string);
			return "/silviaG/phoneBook/phoneBook";
		}
	}
	
	@GetMapping
	public String home(Model model) {
		log.trace("enter home()");
		model.addAttribute("contacts", svc.getAll());
		return "/silviaG/phoneBook/phoneBook";
	}

}
