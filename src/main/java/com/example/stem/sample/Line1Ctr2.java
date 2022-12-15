package com.example.stem.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.stem.sample.line2.ContactRepo;

@Controller
@RequestMapping("/sample/line2")
public class Line1Ctr2 {
    private static final Logger log = LogManager.getLogger(Line1Ctr2.class);
    @Qualifier("ContactRepoLine2")
    ContactRepo repo;

    public Line1Ctr2(ContactRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public String home() {
        log.traceEntry("home()");

        return "/sample/mySample";
    }
}
