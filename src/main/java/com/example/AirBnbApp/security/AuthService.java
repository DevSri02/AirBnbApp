package com.example.AirBnbApp.security;


import com.example.AirBnbApp.dto.LoginDto;
import com.example.AirBnbApp.dto.SignUpRequestDto;
import com.example.AirBnbApp.dto.UserDto;
import com.example.AirBnbApp.entity.User;
import com.example.AirBnbApp.entity.enums.Role;
import com.example.AirBnbApp.exception.ResourceNotFoundException;
import com.example.AirBnbApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.ScopedValue;
import java.net.Authenticator;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserDto  signUp(SignUpRequestDto signUpRequestDto){
        User user=userRepository.findByEmail(signUpRequestDto.getEmail()).orElse(null);

        if(user!=null){
            throw new RuntimeException("User is already present with same email ID");
        }

        User newUser=modelMapper.map(signUpRequestDto,User.class);
        newUser.setRoles(Set.of(Role.GUEST));
        newUser.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        newUser=userRepository.save(newUser);

        return modelMapper.map(newUser,UserDto.class);
    }


    public String[] login(LoginDto loginDto){

        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()
        ));

          User user=(User) authentication.getPrincipal();
//       Retrieve the authentication user
//        User user = (User) authentication.getPrincipal();
//        If authentication succeeds, the authenticated user is available as the principal.
//        It's cast here to your custom User class.
        String[] arr=new String[2];
          arr[0]=jwtService.generateAccessToken(user);
          arr[1]=jwtService.generateRefreshToken(user);

          return arr;

    }

    public String refreshToken(String refreshToken){
        Long id=jwtService.getUserIdFromToken(refreshToken);
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found with Id:{}"+id));

        return jwtService.generateAccessToken(user);
       //if user exist generate new JWT token

    }


}
