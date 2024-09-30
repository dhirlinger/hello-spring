package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    // handles path /hello
    /*@GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }*/
    //after moving @RequestMapping above class handles path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    // lives at hello/hello
    // handles request of the form / hello?name=aParam
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!!";
    }

    //handles /hello/LaunchCode
     @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
     }
    //lives at hello/form
     @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
     }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithPathParam2(@RequestParam String name) {
        return "Hello, " + name + "!!";
    }

    //lives at hello/form2
    @GetMapping("form2")
    public String helloForm2(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language'>" +
                "<option value='french'>French</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
