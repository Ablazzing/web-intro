package org.javaacademy.webintro.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.webintro.dto.EventDto;
import org.javaacademy.webintro.entity.Event;
import org.javaacademy.webintro.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void createEvent(EventDto dto) {
        LocalDate date = dto.getDate() == null ? LocalDate.now() : dto.getDate();
        Event event = new Event(date, dto.getDescr(), dto.getName());
        eventRepository.add(event);
    }

    public List<Event> getEvents() {
        return eventRepository.getEvents();
    }

    public void deleteEvents(String descr) {
        eventRepository.deleteEvents(descr);
    }

    public void deleteEvents() {
        eventRepository.deleteAll();
    }

    public Event getByNumber(Integer number) {
        return eventRepository.getByNumber(number);
    }
}
