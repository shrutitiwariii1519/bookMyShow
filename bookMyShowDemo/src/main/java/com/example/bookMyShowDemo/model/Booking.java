package com.example.bookMyShowDemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Customer customer;
    private int seats;
    private double price;
    private String status; // CONFIRMED / CANCELLED
}
