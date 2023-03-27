package com.example.music.band.support;

import com.example.music.band.dto.EventDto;
import com.example.music.band.model.Event;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventToEventDto implements Converter<Event, EventDto> {

    @Override
    public EventDto convert(Event event) {

        EventDto eventDto = new EventDto();

        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setEventDate(event.getEventDate());
        eventDto.setLocation(event.getLocation());
        eventDto.setCapacity(event.getCapacity());

        return eventDto;
    }

    public List<EventDto> convert(List<Event> events) {

        return events.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

}
