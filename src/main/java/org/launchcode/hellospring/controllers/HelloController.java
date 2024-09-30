package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("hello")
@ResponseBody
@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String Hello(){
//        return "Hello Spring";
//    }
//URL: localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodBye(){
        return "GoodBye Spring";
    }

    //Hello with url: /hello/helloParam?name=something
    @GetMapping("helloParam")
    public String helloWithParam(@RequestParam String name){
        return "Hello " + name + "!";
    }

    //URL: localhost:8080/hello/somename
    @GetMapping("{name}")
    public String helloWithPathVariable(@PathVariable String name){
        return "Hello " + name + "!";
    }

//    @GetMapping("hello/{name}")
//    public String redirectToDesiredPath(@PathVariable String name) {
//        return "redirect:hello/{name}";
//    }

    //URL: localhost:8080/hello/form
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action = 'helloParam'>" +
//                "<input type = 'text' name = 'name'>" +
//                "<input type = 'submit' value = 'Greet me'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//
//    }

    // Responds to get and post requests at /hello?coder=LaunchCoder
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String hello(@RequestParam String coder) {
//        return "Hello, " + coder + "!";
//    }


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, String language) {
            String greet;
        if (language.equals("English")){
            greet = "Hello, " + name + "!";
        } else if (language.equals("French")) {
            greet = "Bonjour, " + name + "!";
        } else if (language.equals("Spanish")) {
            greet = "Hola, " + name + "!";
        } else if (language.equals("Hindi")) {
            greet = "Namaste, " + name + "!";
        }else {
            greet = "Vanakkam, " + name + "!";
        }
         return "<html>" +
                 "<body>" +
                 "<p style=\"background-color:DodgerBlue;\">" + greet +
                 "</p>" +
                 "</body>" +
                 "</html>";

    }

    //URL: localhost:8080/hello/form
    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'post' action = '/hello'>" +
                        "<input type = 'text' name = 'name' />" +
                        "<select name='language' id='lang'>" +
                        "  <option value='English'>English</option>" +
                        "  <option value='French'>French</option>" +
                        "  <option value='Spanish'>Spanish</option>" +
                        "  <option value='Hindi'>Hindi</option>" +
                        "  <option value='Tamil'>Tamil</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }
}

