package com.example.bookMyShowDemo.repository;

import com.example.bookMyShowDemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
