package org.javaacademy.webintro.repository;

import org.javaacademy.webintro.entity.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventRepository {
    private List<Event> events = new ArrayList<>();

    public void add(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void deleteEvents(String descr) {
        events = new ArrayList<>(events.stream()
                .filter(e -> !e.getDescr().equals(descr))
                .toList());
    }

    public void deleteAll() {
        events.clear();
    }

    public Event getByNumber(Integer number) {
        return events.get(number);
    }
}
