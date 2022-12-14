package com.example.stem.marco.phone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsertCtr {
	private PhoneBookSrv result;
	
	public InsertCtr(PhoneBookSrv result) {
		this.result = result;
	}
	
	@GetMapping("/marco/phonebook/inserted")
	public String add(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone, Model model) {
		result.add(firstName, lastName, phone);
		model.addAttribute("message","Contact Inserted");
		return "/marco/phonebook/inserted";
	}
}	
	
	


