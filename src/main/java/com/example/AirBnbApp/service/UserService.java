package com.example.AirBnbApp.service;

import com.example.AirBnbApp.dto.ProfileUpdateRequestDto;
import com.example.AirBnbApp.dto.UserDto;
import com.example.AirBnbApp.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
