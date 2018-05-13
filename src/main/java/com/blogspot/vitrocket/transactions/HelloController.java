package com.blogspot.vitrocket.transactions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VitRocket on 13.05.2018.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Greetings from Spring Boot!";
    }
}
