package com.example.bookMyShowDemo.scheduler;

import com.example.bookMyShowDemo.model.Seat;
import com.example.bookMyShowDemo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SeatLockScheduler {
    @Autowired
    private SeatRepository seatRepository;

    @Scheduled(fixedRate = 60000)
    public void releaseExpiredLocks() {
        List<Seat> expiredLocks = seatRepository.findLockedSeatsExpired(LocalDateTime.now());
        for (Seat seat : expiredLocks) {
            seat.setLocked(false);
            seat.setLockedUntil(null);
        }
        seatRepository.saveAll(expiredLocks);
    }
}