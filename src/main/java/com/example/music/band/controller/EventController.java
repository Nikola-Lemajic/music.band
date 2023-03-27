package com.example.music.band.controller;

import com.example.music.band.dto.EventDto;
import com.example.music.band.model.Event;
import com.example.music.band.service.EventService;
import com.example.music.band.support.EventDtoToEvent;
import com.example.music.band.support.EventToEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventController {

    private final EventService eventService;

    private final EventDtoToEvent toEvent;

    private final EventToEventDto toEventDto;

    @Autowired
    public EventController(EventService eventService, EventDtoToEvent toEvent, EventToEventDto toEventDto){
        this.eventService = eventService;
        this.toEvent = toEvent;
        this.toEventDto = toEventDto;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<EventDto> getOne(@PathVariable Long id) {

        return eventService.findOne(id)
                .map(event -> new ResponseEntity<>(toEventDto.convert(event), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAfterDate/{eventDate}")
    public ResponseEntity<List<EventDto>> getAll(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate eventDate) {

        if (eventDate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Event> events = eventService.getAll(eventDate);

        return new ResponseEntity<>(toEventDto.convert(events), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDto> create(@RequestBody EventDto eventDto) {

        if(eventDto.getId() != null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Event event = toEvent.convert(eventDto);
        Event savedEvent = eventService.save(event);

        return new ResponseEntity<>(toEventDto.convert(savedEvent), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDto> update(@PathVariable Long id, @RequestBody EventDto eventDto) {

        if (!id.equals(eventDto.getId()) || !eventService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            Event event = eventService.update(eventDto);
            return new ResponseEntity<>(toEventDto.convert(event), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!eventService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        eventService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
