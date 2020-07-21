package com.damine.javafxspringboottemplate.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String welcome(){
        return "hello world";
    }
}
