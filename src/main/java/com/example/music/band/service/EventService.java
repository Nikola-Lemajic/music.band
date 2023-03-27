package com.example.music.band.service;

import com.example.music.band.dto.EventDto;
import com.example.music.band.model.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {

    Optional<Event> findOne(Long id);

    Event save(Event event);

    Event update(EventDto eventDto);

    void delete(Long id);

    List<Event> getAll(LocalDate eventDate);

    boolean existsById(Long id);


}
