package com.coddicted.appointment.service.impl;

import com.coddicted.appointment.model.Event;
import com.coddicted.appointment.repository.EventRepository;
import com.coddicted.appointment.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents(Pageable paging) {
        return eventRepository.findAll(paging).toList();
    }

    @Override
    public Event getEventById(String eventId) {
        Optional<Event> res = eventRepository.findById(eventId);
        if(res.isPresent())
            return res.get();
        return null;
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

}
