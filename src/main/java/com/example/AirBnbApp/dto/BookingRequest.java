package com.example.AirBnbApp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {  // SENDING Request
    private Long hotelId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;
}
