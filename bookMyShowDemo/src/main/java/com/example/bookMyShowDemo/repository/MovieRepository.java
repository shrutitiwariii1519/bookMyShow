package com.example.bookMyShowDemo.repository;

import com.example.bookMyShowDemo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
