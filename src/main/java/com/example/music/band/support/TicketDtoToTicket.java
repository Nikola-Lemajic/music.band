package com.example.music.band.support;

import com.example.music.band.dto.EventDto;
import com.example.music.band.dto.TicketDto;
import com.example.music.band.model.Event;
import com.example.music.band.model.Ticket;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoToTicket implements Converter<TicketDto, Ticket> {

    @Override
    public Ticket convert(TicketDto ticketDto) {

        Ticket ticket = new Ticket();
        ticket.setPrice(ticketDto.getPrice());

        Event event = new Event();
        EventDto eventDto = ticketDto.getEventDto();
        event.setId(eventDto.getId());
        ticket.setEvent(event);

        return ticket;
    }
}
