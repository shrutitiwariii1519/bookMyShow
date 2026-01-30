package com.example.bookMyShowDemo.repository;

import com.example.bookMyShowDemo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
