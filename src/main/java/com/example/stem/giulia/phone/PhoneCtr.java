package com.example.stem.giulia.phone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/giulia/phone")
public class PhoneCtr {
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
