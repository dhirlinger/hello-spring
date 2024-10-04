package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    // handles /hello?name=aParam
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String hello(@RequestParam String name) {

        return "Hello, " + name + "!";
    }
    // handles /hello/aParam
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name){
        return "Hello, " + name + "!";
    }


     @GetMapping("form")
    public String helloForm(){
        return "form";
     }
}
