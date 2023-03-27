package com.example.music.band.dto;

import com.example.music.band.model.Event;
import jakarta.validation.constraints.Positive;

public class TicketDto {

    private Long id;

    @Positive
    private Long price;

    private EventDto eventDto;

    public TicketDto() {
    }

    public TicketDto(Long id, Long price, EventDto eventDto) {
        this.id = id;
        this.price = price;
        this.eventDto = eventDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public EventDto getEventDto() {
        return eventDto;
    }

    public void setEventDto(EventDto eventDto) {
        this.eventDto = eventDto;
    }
}
