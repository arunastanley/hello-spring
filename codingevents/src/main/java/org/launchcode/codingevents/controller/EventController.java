package org.launchcode.codingevents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String events(Model model){
        List<String> eventList = new ArrayList<>();
        eventList.add("Load");
        eventList.add("submit");
        eventList.add("click");
        model.addAttribute("eventList",eventList);
        return "events/index";
    }

//    /events/create
    @GetMapping("create")
    public String createEventForm(){

        return "events/create";
    }



}
