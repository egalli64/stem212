package com.example.stem.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stem.sample.line1.ContactRepo;

@Controller
@RequestMapping("/sample/line1")
public class Line1Ctr {
    private static final Logger log = LogManager.getLogger(Line1Ctr.class);
    ContactRepo repo;

    public Line1Ctr(ContactRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public String home(Model model) {
        log.traceEntry("home()");

        model.addAttribute("warnLevel", "yellow");

        return "/sample/mySample";
    }
}
