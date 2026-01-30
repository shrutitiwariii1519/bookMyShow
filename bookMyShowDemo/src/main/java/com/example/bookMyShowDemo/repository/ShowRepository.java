package com.example.bookMyShowDemo.repository;

import com.example.bookMyShowDemo.model.Movie;
import com.example.bookMyShowDemo.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Long> {

    //@Query("select * from show s where s.movie = ? and s.city = ? and s.date = ?")
    public List<Show> findByTheatreCityAndMovieNameAndDate(String city, String movieName, LocalDate date);

}
