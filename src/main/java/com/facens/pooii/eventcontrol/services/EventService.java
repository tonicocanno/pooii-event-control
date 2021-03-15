package com.facens.pooii.eventcontrol.services;

import java.util.List;
import java.util.Optional;

import com.facens.pooii.eventcontrol.DTO.EventInsertDTO;
import com.facens.pooii.eventcontrol.entities.Event;
import com.facens.pooii.eventcontrol.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events;
    }

    public Event getEventById(Long id) {
        Optional<Event> op = eventRepository.findById(id);
        Event ev = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        return ev;
    }

    public Event insertEvent(EventInsertDTO dto) {
        Event event = new Event(dto);
        event = eventRepository.save(event);
        return event;
    }

    public void deleteEvent(Long id) {
        try{
            eventRepository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }
}
