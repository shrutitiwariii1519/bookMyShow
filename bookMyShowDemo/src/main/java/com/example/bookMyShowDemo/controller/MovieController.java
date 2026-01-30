package com.example.bookMyShowDemo.controller;

import com.example.bookMyShowDemo.DTO.BookingRequest;
import com.example.bookMyShowDemo.model.Movie;
import com.example.bookMyShowDemo.model.Show;
import com.example.bookMyShowDemo.repository.MovieRepository;
import com.example.bookMyShowDemo.service.MovieService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/shows")
    public List<Show> getShows(@RequestParam String movie, @RequestParam String city,  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {


        return movieService.getShows(movie,city,date);

    }

}
