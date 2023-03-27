package com.example.music.band.service.impl;

import com.example.music.band.dto.TicketDto;
import com.example.music.band.model.Ticket;
import com.example.music.band.repository.MusicRecordRepository;
import com.example.music.band.repository.TicketRepository;
import com.example.music.band.service.TicketService;
import com.example.music.band.support.EventDtoToEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaTicketService implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public EventDtoToEvent toEvent;

    @Autowired
    public JpaTicketService (TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> findOne(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id){
        return ticketRepository.existsById(id);
    }
}
