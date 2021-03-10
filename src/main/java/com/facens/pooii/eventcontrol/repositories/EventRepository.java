package com.facens.pooii.eventcontrol.repositories;

import com.facens.pooii.eventcontrol.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
    
}
