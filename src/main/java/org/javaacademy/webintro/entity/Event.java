package org.javaacademy.webintro.entity;


import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class Event {
    @NonNull
    private LocalDate date;
    @NonNull
    private String descr;
    @NonNull
    private String name;
}
