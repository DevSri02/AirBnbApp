package com.example.AirBnbApp.dto;

import com.example.AirBnbApp.entity.User;
import com.example.AirBnbApp.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;


@Data
public class GuestDto {

        private Long id;

        private User user;

        private String name;

        private Gender gender;

        private Integer age;
    }
