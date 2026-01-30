package com.example.bookMyShowDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Show show;

    private String seatNumber;
    private boolean isBooked;
    private boolean isLocked;
    private LocalDateTime lockedUntil;
}
