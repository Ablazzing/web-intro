package org.javaacademy.webintro.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.webintro.dto.EventDto;
import org.javaacademy.webintro.entity.Event;
import org.javaacademy.webintro.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final EventService eventService;

    //GET http://localhost:8080/calendar
    @GetMapping
    public List<Event> getEvent() {
        return eventService.getEvents();
    }

    @PostMapping
    public ResponseEntity createEvent(@RequestBody EventDto body) {
        eventService.createEvent(body);
        return ResponseEntity.status(201).body("ура создалось");
    }

    @DeleteMapping
    public void deleteEvent(@RequestParam(required = false) String descr,
                            @RequestParam(required = false) String date) {
        System.out.println(descr);
        System.out.println(date);
        if (descr == null) {
            eventService.deleteEvents();
        }
        eventService.deleteEvents(descr);
    }

    @GetMapping("/{number}")
    public Event getEventByNumber(@PathVariable Integer number) {
        return eventService.getByNumber(number);
    }
}
