package org.launchcode.codingevents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> eventList = new ArrayList<>();

    @GetMapping
    public String displayEvents(Model model){
//        List<String> eventList = new ArrayList<>();
//        eventList.add("Load");
//        eventList.add("submit");
//        eventList.add("click");
        model.addAttribute("eventList",eventList);
        return "events/index";
    }

//    /events/create
    @GetMapping("create")
    public String createEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String submitForm(@RequestParam String name){
        eventList.add(name);
        return "redirect:/events";
    }


}
