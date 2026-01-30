package com.example.bookMyShowDemo.controller;

import com.example.bookMyShowDemo.DTO.BookingRequest;
import com.example.bookMyShowDemo.model.Booking;
import com.example.bookMyShowDemo.model.Customer;
import com.example.bookMyShowDemo.model.Show;
import com.example.bookMyShowDemo.service.BookingService;
import com.example.bookMyShowDemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private MovieService movieService;

    @PostMapping("/book")
    public Booking book(@RequestBody BookingRequest request) {
        Show show = movieService.findShowById(request.getShowId());
        Customer customer = movieService.findCustomerById(request.getCustomerId());
        return bookingService.bookTickets(show, customer, request.getSeatNumbers());
    }
}
