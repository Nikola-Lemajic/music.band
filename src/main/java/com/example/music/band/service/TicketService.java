package com.example.music.band.service;

import com.example.music.band.model.Ticket;

import java.util.Optional;

public interface TicketService {

    Optional<Ticket> findOne(Long id);

    Ticket save(Ticket ticket);

    void delete(Long id);

    boolean existsById(Long id);

}
