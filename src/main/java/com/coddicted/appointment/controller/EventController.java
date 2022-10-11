package com.coddicted.appointment.controller;

import com.coddicted.appointment.model.Event;
import com.coddicted.appointment.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {
    private EventService eventService;

    @GetMapping
    public List<Event> getEvents(@RequestParam(defaultValue = "0", name="page") int page,
                                 @RequestParam(defaultValue = "10", name="size") int size){
        Pageable paging = PageRequest.of(page, size);
        return eventService.getAllEvents(paging);
    }

    @GetMapping("/{id}")
    public Event getEvent(@PathVariable("id") String id){
        return eventService.getEventById(id);
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event){
        return this.eventService.save(event);
    }
}
