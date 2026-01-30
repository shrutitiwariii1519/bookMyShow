package com.example.bookMyShowDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private int totalSeats;

    @ManyToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @ManyToOne(cascade = CascadeType.ALL)
    private Theatre theatre;
}
