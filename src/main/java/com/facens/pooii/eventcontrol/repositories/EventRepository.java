package com.facens.pooii.eventcontrol.repositories;

import com.facens.pooii.eventcontrol.entities.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
    
    // @Query(" SELECT e FROM Event e " +
    //        " WHERE " + 
    //        " LOWER(e.name)  LIKE LOWER(CONCAT('%', :name,  '%')) AND " +
    //        " LOWER(e.place) LIKE LOWER(CONCAT('%', :place, '%')) AND " +
    //        " CAST(start_date AS VARCHAR) LIKE CONCAT('%', :start_date, '%') "
    // )
    @Query(value = " select * from tb_event where " + 
                   " upper(name) like upper(CONCAT('%', :name,  '%')) and " +
                   " upper(place) like upper(CONCAT('%', :place, '%')) and " +
                   " CAST(start_date AS VARCHAR) like CONCAT('%', :start_date, '%')", nativeQuery = true
    )

    public Page<Event> find(Pageable pageRequest, String name, String place, String start_date);
}
