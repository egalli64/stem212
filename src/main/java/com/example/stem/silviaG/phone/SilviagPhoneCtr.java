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
public class SilviagPhoneCtr {
    private static Logger log = LoggerFactory.getLogger(SilviagPhoneCtr.class);
    private SilviagPhoneSvc svc;
    private SilviagPhoneRepository repo;
    
    public SilviagPhoneCtr (SilviagPhoneSvc svc, SilviagPhoneRepository repo) {
    	this.svc = svc;
    	this.repo = repo;
    }

    @GetMapping("/insert")
    public String insert(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String phone, Model model) {
        log.trace("enter insert()");
        Contact contact = new Contact(firstName, lastName, phone);
        //svc.add(contact);
        repo.save(contact);
        //model.addAttribute("contacts", svc.getAll());
        model.addAttribute("contacts", repo.findAll());
        return "/silviaG/phoneBook/phoneBook";
    }
    
    @GetMapping
    public String home(Model model) {
        log.trace("enter home()");
        model.addAttribute("contacts", svc.getAll());
        return "/silviaG/phoneBook/phoneBook";
    }
   

}
