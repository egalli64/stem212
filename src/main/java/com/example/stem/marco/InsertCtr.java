package com.example.stem.marco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jsp/phonebook")
public class InsertCtr {
	private PhoneBookSrv srv;
	
	private static Logger log = LoggerFactory.getLogger(InsertCtr.class);
	
	public InsertCtr(PhoneBookSrv srv) {
		this.srv = srv;
	}
	
	@GetMapping("/insert")
	public String insert(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String Number) {
		log.trace("enter insert()");
		Person person = new Person(firstName, lastName, Number);
		srv.newAdd(person);
		return "/jsp/phonebook";
	}
	
	@GetMapping
	public String home() {
		log.trace("enter home");
		return "/phonebook";
	}
}
