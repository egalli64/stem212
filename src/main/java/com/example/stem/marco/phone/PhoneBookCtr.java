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

	public static boolean containsNumbers(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		for (int i = 0; i < string.length(); ++i) {
			if (Character.isDigit(string.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	public static boolean containsLetters(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		for (int i = 0; i < string.length(); ++i) {
			if (Character.isLetter(string.charAt(i))) {
				return true;
			}
		}
		return false;
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
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone,
			Model model) {
		firstName = firstName.trim();
		lastName = lastName.trim();
		phone = phone.trim();
		log.trace("enter insert()");
		if (firstName.isEmpty() || firstName.isBlank() || lastName.isEmpty() || lastName.isBlank() || phone.isEmpty()
				|| phone.isBlank()) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorInsertBlank", "All fields must be filled in");
		} else if (containsNumbers(firstName) == true) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorInsertNumb", "Invalid first name");
		} else if (containsNumbers(lastName) == true) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorInsertNumb", "Invalid last name");
		} else if (containsLetters(phone) == true) {
			model.addAttribute("contacts", repo.findAll());
			model.addAttribute("errorInsertNumb", "Invalid phone");
		} else {
			Contact contact = new Contact(firstName, lastName, phone);
			repo.save(contact);
			model.addAttribute("contacts", repo.findAll());
		}

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

	@GetMapping("/preModify")
	public String preModify(@RequestParam Integer id, Model model) {
		log.trace("enter preModify()");
		repo.findById(id).ifPresentOrElse(c -> model.addAttribute("modContact", c),
				() -> model.addAttribute("modBadId", id));
		model.addAttribute("contacts", repo.findAll());
		return "/marco/phonebook/phonebook";
	}

	@GetMapping("/modify")
	public String modify(@RequestParam Integer id, @RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String phone, Model model) {
		log.trace("enter modify()");
		Contact modContact = repo.findById(id).get();
		modContact.setFirstName(firstName);
		modContact.setLastName(lastName);
		modContact.setPhone(phone);
		repo.save(modContact);
		model.addAttribute("contacts", repo.findAll());
		return "/marco/phonebook/phonebook";
	}
}
