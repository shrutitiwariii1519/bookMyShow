package com.example.bookMyShowDemo.service;

import com.example.bookMyShowDemo.exceptions.ShowNotFoundException;
import com.example.bookMyShowDemo.model.Show;
import com.example.bookMyShowDemo.repository.SeatRepository;
import com.example.bookMyShowDemo.repository.ShowRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public Show createShow(Show show) {
        return showRepository.save(show);
    }

    public Show updateShow(Long id, Show updated) {
        Show show = this.findById(id);
        show.setTime(updated.getTime());
        show.setTotalSeats(updated.getTotalSeats());
        return showRepository.save(show);
    }

    public void deleteShow(Long id) {
        showRepository.deleteById(id);
    }

    public Show findById(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new ShowNotFoundException("Show not found with id " + id));
    }
}
