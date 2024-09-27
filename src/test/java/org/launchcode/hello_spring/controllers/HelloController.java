package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    public String hello() {
        return "Hello, Spring!";
    }

}
