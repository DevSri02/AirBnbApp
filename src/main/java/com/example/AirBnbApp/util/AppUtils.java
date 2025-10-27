package com.example.AirBnbApp.util;

import com.example.AirBnbApp.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Security;

public class AppUtils {

             public static User getCurrentUser(){
                 return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
             }
}

