package org.zerock.boardtest.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class HellowController {

    @GetMapping("/hello")
    public void hello(){
        log.info("Hello...........");
    }
}
