package com.example.stem.manuel.phone;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.stem.dao.Contact;

@Controller
@RequestMapping("/Manuel/phone")
public class ManuelPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(ManuelPhoneCtr.class);
	//private ManuelPhoneSvc svc;
	private MPhoneBookRepository repo;

	public ManuelPhoneCtr(ManuelPhoneSvc svc, MPhoneBookRepository repo) {
		//this.svc = svc;
		this.repo = repo;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		log.trace("delete contact");
		Optional<Contact> contatto = repo.findById(id);
		contatto.ifPresent(c-> repo.delete(c));
		
		model.addAttribute("contacts", repo.findAll());
		return "/Manuel/telefono";
	}

	@GetMapping("/insert")
	public String inserisci(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String number,
			Model model) {
		log.trace("enter insert");
		Contact contatto = new Contact(firstName, lastName, number);
		// svc.add(contatto);
		// model.addAttribute("contacts", svc.getAll());
		repo.save(contatto);
		model.addAttribute("contacts", repo.findAll());

		return "/Manuel/telefono";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contacts", repo.findAll());
		return "/Manuel/telefono";
	}

}
