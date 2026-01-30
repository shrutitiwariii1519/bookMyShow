package com.example.bookMyShowDemo.service;

import com.example.bookMyShowDemo.model.Customer;
import com.example.bookMyShowDemo.model.Show;
import com.example.bookMyShowDemo.repository.CustomerRepository;
import com.example.bookMyShowDemo.repository.ShowRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    private final ShowRepository showRepository;
    private final CustomerRepository customerRepository;

    public MovieService(ShowRepository showRepository, CustomerRepository customerRepository) {
        this.showRepository = showRepository;
        this.customerRepository = customerRepository;
    }

    public List<Show> getShows(String movie, String city, LocalDate date) {
        return showRepository.findByTheatreCityAndMovieNameAndDate(city, movie, date);
    }

    public Show findShowById(Long id) {
        return showRepository.findById(id).orElseThrow();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }


}
