package com.example.timesheetbackent.controller;


import com.example.timesheetbackent.model.Event;
import com.example.timesheetbackent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;


    @PostMapping("/addEventByManager/{id}")
    public Event addEvent(@PathVariable("id") Long id,@RequestBody Event event){
        return eventService.addEvent(id,event);
    }



}
