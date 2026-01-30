package com.example.bookMyShowDemo.repository;

import com.example.bookMyShowDemo.model.Seat;
import com.example.bookMyShowDemo.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByShowAndSeatNumberIn(Show show, List<String> seatNumbers);

    @Query("SELECT s FROM Seat s WHERE s.isLocked = true AND s.lockedUntil < :now")
    List<Seat> findLockedSeatsExpired(@Param("now") LocalDateTime now);
}
