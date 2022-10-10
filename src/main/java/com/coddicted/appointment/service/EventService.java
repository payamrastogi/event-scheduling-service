package com.coddicted.appointment.service;


import com.coddicted.appointment.model.Event;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents(Pageable paging);
    Event getEventById(String eventId);
    Event save(Event event);
}
