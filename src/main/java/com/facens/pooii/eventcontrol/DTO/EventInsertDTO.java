package com.facens.pooii.eventcontrol.DTO;

import java.time.LocalTime;

public class EventInsertDTO {
    
    private String name;
    private String description;
    private String place;
    private LocalTime startDate;
    private LocalTime endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String email;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public LocalTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalTime startDate) {
        this.startDate = startDate;
    }
    public LocalTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalTime endDate) {
        this.endDate = endDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
