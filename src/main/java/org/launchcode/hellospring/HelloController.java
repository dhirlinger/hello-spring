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
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, String language) {
        String greeting = createMessage(language);
        return greeting + ", " + name + "!";
    }

    public static String createMessage(String language){
        return switch (language) {
            case "fr" -> "Bonjour";
            case "es" -> "Hola";
            case "en" -> "Hello";
            case "ma" -> "你好";
            case "hi" -> "नमस्ते";
            default -> "Hi";
        };
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


    //lives at hello/form2
    @GetMapping("form2")
    public String helloForm2(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language'>" +
                "<option value='fr'>French</option>" +
                "<option value='es'>Spanish</option>" +
                "<option value='en'>English</option>" +
                "<option value='ma'>Mandarin</option>" +
                //你好 Nǐ hǎo
                "<option value='mn'>Mandarin</option>" +
                //नमस्ते namaste
                "<option value='hi'>Hindi</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
