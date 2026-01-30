package com.example.bookMyShowDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookMyShowDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowDemoApplication.class, args);
	}

}
