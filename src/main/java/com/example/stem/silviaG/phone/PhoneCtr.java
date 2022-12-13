package com.example.stem.silviaG.phone;

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
public class PhoneCtr {
    private static Logger log = LoggerFactory.getLogger(PhoneCtr.class);
    private PhoneSvc svc;
    
    public PhoneCtr (PhoneSvc svc) {
    	this.svc = svc;
    }

    @GetMapping("/insert")
    public String insert(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String number, Model model) {
        log.trace("enter insert()");
        Contact contact = new Contact(firstName, lastName, number);
        svc.add(contact);
        model.addAttribute("contacts", svc.getAll());
        return "/phoneBook";
    }
    
    @GetMapping
    public String home(Model model) {
        log.trace("enter home()");
        model.addAttribute("contacts", svc.getAll());
        return "/phoneBook";
    }
   

}
