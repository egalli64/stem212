package com.example.stem.sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/mySample")
public class MySampleCtr {
    private static final Logger log = LogManager.getLogger(MySampleCtr.class);

    @GetMapping
    public String home() {
        log.traceEntry("home()");

        return "/sample/mySample";
    }
}
