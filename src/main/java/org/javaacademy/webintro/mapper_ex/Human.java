package org.javaacademy.webintro.mapper_ex;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Human {
    private String name;
    private String surname;
    private List<Object> clothes;
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());


    public List<Object> getClothes() {
        return clothes;
    }

    @Data
    public static class Phone {
        private String model;
        private double price;
        private boolean used;
    }
}
