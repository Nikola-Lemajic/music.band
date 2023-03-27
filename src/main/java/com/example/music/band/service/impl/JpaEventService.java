package com.example.music.band.service.impl;

import com.example.music.band.dto.EventDto;
import com.example.music.band.model.Event;
import com.example.music.band.repository.EventRepository;
import com.example.music.band.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JpaEventService implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public JpaEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Optional<Event> findOne(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event update(EventDto eventDto) {

      return eventRepository.findById(eventDto.getId())
                .map(event -> {
                    event.setName(eventDto.getName());
                    event.setEventDate(eventDto.getEventDate());
                    event.setLocation(eventDto.getLocation());
                    event.setCapacity(eventDto.getCapacity());
                    return eventRepository.save(event);
                }).orElseThrow();

    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAll(LocalDate eventDate) {

        return eventRepository.findByEventDateAfter(eventDate);
    }

    @Override
    public boolean existsById(Long id){
       return eventRepository.existsById(id);
    }
}
