package org.javaacademy.webintro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.time.LocalDate;

@Value
public class EventDto {
   LocalDate date;
   String descr;
   @JsonProperty("full_name")
   String name;
}
