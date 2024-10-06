package org.launchcode.hellospring.controllers;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String theGreeting = "Hello " +name+ "!";
        model.addAttribute("greeting",theGreeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String sayHello = "Hello, " + name + "!";
        model.addAttribute("greeting",sayHello);
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }



    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> namesList = new ArrayList<>();
        namesList.add("Java");
        namesList.add("JavaScript");
        namesList.add("Python");
        model.addAttribute("names",namesList);
        return "hello-names";
    }
}