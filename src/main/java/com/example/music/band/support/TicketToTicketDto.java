package com.example.music.band.support;

import com.example.music.band.dto.TicketDto;
import com.example.music.band.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketToTicketDto implements Converter<Ticket, TicketDto> {

    @Autowired
    private EventToEventDto toEventDto;

    @Override
    public TicketDto convert(Ticket ticket) {

        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(ticket.getId());
        ticketDto.setPrice(ticket.getPrice());
        ticketDto.setEventDto(toEventDto.convert(ticket.getEvent()));

        return ticketDto;
    }

    public List<TicketDto> convert(List<Ticket> tickets) {

        return tickets.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
