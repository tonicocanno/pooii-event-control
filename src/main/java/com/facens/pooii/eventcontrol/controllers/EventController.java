package com.facens.pooii.eventcontrol.controllers;

import java.net.URI;

import com.facens.pooii.eventcontrol.DTO.EventInsertDTO;
import com.facens.pooii.eventcontrol.entities.Event;
import com.facens.pooii.eventcontrol.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
// import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {
    
    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<Event>> getAllEvents(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
        @RequestParam(value = "name", defaultValue = "") String name,
        @RequestParam(value = "place", defaultValue = "") String place

    ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        Page<Event> events = service.getAllEvents(pageRequest, name, place);
        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = service.getEventById(id);
        return ResponseEntity.ok().body(event);
    }

    @PostMapping
    public ResponseEntity<Event> insertEvent(@RequestBody EventInsertDTO insertDTO) {
        Event event = service.insertEvent(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(event.getId()).toUri();
        return ResponseEntity.created(uri).body(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        service.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody EventInsertDTO updatDTO){
        Event event = service.updateEvent(id, updatDTO);
        return ResponseEntity.ok().body(event);
    }

}
