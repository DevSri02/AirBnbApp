package com.example.AirBnbApp.service;

import com.example.AirBnbApp.dto.BookingDto;
import com.example.AirBnbApp.dto.BookingRequest;
import com.example.AirBnbApp.dto.GuestDto;
import com.example.AirBnbApp.dto.HotelReportDto;
import com.example.AirBnbApp.entity.enums.BookingStatus;
import com.stripe.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    // Consistent naming: initializeBooking (not initialise)
    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    BookingStatus getBookingStatus(Long bookingId);

    // Fix method name: singular "Booking" to match implementation
    List<BookingDto> getAllBookingByHotelId(Long hotelId);

    HotelReportDto getHotelReport(Long hotelId, LocalDate startDate, LocalDate endDate);

    List<BookingDto> getMyBookings();
}
