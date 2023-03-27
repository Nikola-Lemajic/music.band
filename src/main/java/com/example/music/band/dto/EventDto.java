package com.example.music.band.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class EventDto {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate eventDate;

    @NotNull
    private String location;

    @Positive
    private int capacity;

    public EventDto() {
    }

    public EventDto(Long id, String name, LocalDate date, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.eventDate = date;
        this.location = location;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
