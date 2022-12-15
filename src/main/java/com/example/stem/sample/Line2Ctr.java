package com.example.stem.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stem.sample.line2.ContactRepo;

@Controller
@RequestMapping("/sample/line2")
public class Line2Ctr {
    private static final Logger log = LogManager.getLogger(Line2Ctr.class);
    @Qualifier("ContactRepoLine2")
    ContactRepo repo;

    public Line2Ctr(ContactRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public String home(Model model) {
        log.traceEntry("home()");

        model.addAttribute("warnLevel", "red");

        return "/sample/mySample";
    }
}
