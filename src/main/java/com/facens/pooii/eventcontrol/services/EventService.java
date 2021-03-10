package com.facens.pooii.eventcontrol.services;

import java.time.LocalDateTime;
import java.util.List;

import com.facens.pooii.eventcontrol.entities.Event;
import com.facens.pooii.eventcontrol.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class EventService {

    @Service
    public class FuncionarioService {

        @Autowired
        EventRepository eventRepository;

        public Event saveEvent(Event e) {
            eventRepository.save(e);
            return e;
        }

        public List<Event> getAllEvents() {
            return eventRepository.findAll();
        }

        public Event getEventById(Long id) {
            for (Event e : eventRepository.findAll()) {
                if (e.getId() == id) {
                    return e;
                }
            }
            return null;
        }

        public void deleteEvent(Event e) {
            if (getEventById(e.getId()) != null) {
                eventRepository.deleteById(e.getId());
            }
        }

        public void deleteEventById(Long codigo) {
            eventRepository.deleteById(codigo);
        }

        // AINDA SEM UTILIZAR DTO :: FAZER
        public Event updateEvent(Event e) {

            Event alterar = getEventById(e.getId());

            if (alterar != null) {
                alterar.setId(e.getId());
                alterar.setName(e.getName());
                alterar.setDescription(e.getDescription());
                alterar.setPlace(e.getPlace());
                alterar.setStartDate(e.getStartDate());
                alterar.setEndDate(e.getEndDate());
                alterar.setStartTime(e.getStartTime());
                alterar.setEndTime(e.getEndTime());
                alterar.setEmail(e.getEmail());
                return alterar;
            } else {
                return null;
            }
        }

        //////// TESTING////////
        public void insereListaFunc() {
            LocalDateTime time = LocalDateTime.now();
            eventRepository.save(new Event());
        }
    }
}
