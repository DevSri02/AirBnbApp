package com.example.AirBnbApp.service;

import com.example.AirBnbApp.entity.Booking;

public interface CheckoutService {
      String getCheckoutSession(Booking booking, String successUrl, String failureUrl);

}

