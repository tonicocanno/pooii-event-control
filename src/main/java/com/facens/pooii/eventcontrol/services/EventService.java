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
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event> op = eventRepository.findById(id);
        Event event = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
        return event;
    }

    public Event insertEvent(EventInsertDTO dto) {
        Event event = new Event(dto);
        event = eventRepository.save(event);
        return event;
    }

    public Event updateEvent(Long id, EventInsertDTO dto) {
        try {
            Event event = eventRepository.getOne(id);
            event.setName(dto.getName());
            event.setDescription(dto.getDescription());
            event.setPlace(dto.getPlace());
            event.setStartDate(dto.getStartDate());
            event.setEndDate(dto.getEndDate());
            event.setStartTime(dto.getStartTime());
            event.setEndTime(dto.getEndTime());
            event.setEmail(dto.getEmail());
            event = eventRepository.save(event);
            return event;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
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
