package com.example.music.band.controller;

import com.example.music.band.dto.TicketDto;
import com.example.music.band.model.Ticket;
import com.example.music.band.repository.EventRepository;
import com.example.music.band.service.TicketService;
import com.example.music.band.support.TicketDtoToTicket;
import com.example.music.band.support.TicketToTicketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    private final TicketService ticketService;

    private final TicketToTicketDto toTicketDto;

    private final TicketDtoToTicket toTicket;

    private final EventRepository eventRepository;

    @Autowired
    public TicketController(
            TicketService ticketService,
            TicketToTicketDto toTicketDto,
            TicketDtoToTicket toTicket,
            EventRepository eventRepository
    ) {
        this.ticketService = ticketService;
        this.toTicketDto = toTicketDto;
        this.toTicket = toTicket;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<TicketDto> getOne(@PathVariable Long id) {

        return ticketService.findOne(id)
                .map(ticket -> new ResponseEntity<>(toTicketDto.convert(ticket), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto ticketDto) {

        if (ticketDto.getId() != null || !eventRepository.existsById(ticketDto.getEventDto().getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = toTicket.convert(ticketDto);
        Ticket savedTicked = ticketService.save(ticket);

        return new ResponseEntity<>(toTicketDto.convert(savedTicked), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!ticketService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        ticketService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
