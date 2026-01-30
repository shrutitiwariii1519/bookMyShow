package com.example.bookMyShowDemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class BookingRequest{

    private Long showId;
    private Long customerId;
    private List<String> seatNumbers;

}
