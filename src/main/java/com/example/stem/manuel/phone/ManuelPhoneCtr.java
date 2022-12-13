package com.example.stem.manuel.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manuel/phone")
public class ManuelPhoneCtr {
	private static Logger log = LoggerFactory.getLogger(ManuelPhoneCtr.class);
	private ManuelPhoneSvc svc;

	public ManuelPhoneCtr(ManuelPhoneSvc svc) {
		this.svc = svc;
	}

	@GetMapping("/delete")
	public String delete() {
		log.trace("delete contact");
		
		return "telefono";
	}

	@GetMapping("/insert")
	public String inserisci(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String number) {
		log.trace("enter insert");
		//Contatti contatti = new Contatti(firstName,lastName,number);
		
		return "telefono";
	}

	@GetMapping
	public String home(Model model) {
		log.trace("enter home");
		model.addAttribute("contatti", svc.getAll());
		return "telefono";
	}

}
