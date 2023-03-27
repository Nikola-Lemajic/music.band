package com.example.music.band.model;

import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate eventDate;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int capacity;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private List<Ticket> tickets;

    public Event() {
    }

    public Event(Long id, String name, LocalDate eventDate, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return capacity == event.capacity &&
                Objects.equals(id, event.id) &&
                Objects.equals(name, event.name) &&
                Objects.equals(eventDate, event.eventDate) &&
                Objects.equals(location, event.location) &&
                Objects.equals(tickets, event.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, eventDate, location, capacity, tickets);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventDate=" + eventDate +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", tickets=" + tickets +
                '}';
    }
}
