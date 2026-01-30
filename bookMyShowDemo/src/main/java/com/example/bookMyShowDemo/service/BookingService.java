package com.example.bookMyShowDemo.service;

import com.example.bookMyShowDemo.exceptions.SeatUnavailableException;
import com.example.bookMyShowDemo.model.Booking;
import com.example.bookMyShowDemo.model.Customer;
import com.example.bookMyShowDemo.model.Seat;
import com.example.bookMyShowDemo.model.Show;
import com.example.bookMyShowDemo.repository.BookingRepository;
import com.example.bookMyShowDemo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Booking bookTickets(Show show, Customer customer, List<String> seatNumbers) {
        List<Seat> seats = seatRepository.findByShowAndSeatNumberIn(show, seatNumbers);
        for (Seat seat : seats) {
            if (seat.isBooked() || (seat.isLocked() && seat.getLockedUntil().isAfter(LocalDateTime.now()))) {
                throw new SeatUnavailableException("Seat " + seat.getSeatNumber() + " is already booked or locked");
            }
            seat.setLocked(true);
            seat.setLockedUntil(LocalDateTime.now().plusMinutes(10));
        }
        seatRepository.saveAll(seats);

        double basePrice = 200.0;
        double totalPrice = basePrice * seats.size();

        if (seats.size() >= 3) totalPrice -= basePrice * 0.5; // 50% off third ticket
        else if (show.getTime().isAfter(LocalTime.of(12, 0)) && show.getTime().isBefore(LocalTime.of(17, 0))) {
            totalPrice *= 0.8; // 20% off afternoon show
        }
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setCustomer(customer);
        booking.setSeats(seats.size());
        booking.setPrice(totalPrice);
        booking.setStatus("CONFIRMED");
        for (Seat seat : seats) {
            seat.setBooked(true);
            seat.setLocked(false);
            seat.setLockedUntil(null);
        }
        seatRepository.saveAll(seats);
        return bookingRepository.save(booking);
    }
}
