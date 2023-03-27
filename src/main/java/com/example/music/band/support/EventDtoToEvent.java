package com.example.music.band.support;

import com.example.music.band.dto.EventDto;
import com.example.music.band.model.Event;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EventDtoToEvent implements Converter<EventDto, Event> {

    @Override
    public Event convert(EventDto eventDto) {

        Event event = new Event();

        event.setName(eventDto.getName());
        event.setEventDate(eventDto.getEventDate());
        event.setLocation(eventDto.getLocation());
        event.setCapacity(eventDto.getCapacity());

        return event;

    }
}

