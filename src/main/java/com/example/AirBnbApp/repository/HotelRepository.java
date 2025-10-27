package com.example.AirBnbApp.repository;

import com.example.AirBnbApp.entity.Hotel;
import com.example.AirBnbApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HotelRepository extends JpaRepository<Hotel, Long > {
    List<Hotel> findByOwner(User user);
}
