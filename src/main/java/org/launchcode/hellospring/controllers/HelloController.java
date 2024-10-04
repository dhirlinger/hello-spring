package org.launchcode.hellospring.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    // handles /hello?name=aParam
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String hello(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }
    // handles /hello/aParam
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model){
        String greeting = "hello, " + name + "?";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

     @GetMapping("form")
    public String helloForm(){
        return "form";
     }
     @GetMapping("hello-names")
     public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Bob");
        names.add("Java");
        names.add("Jane");
        model.addAttribute("names", names);
        return "hello-list";
     }

}
