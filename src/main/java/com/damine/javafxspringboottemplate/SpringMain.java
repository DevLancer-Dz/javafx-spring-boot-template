package com.damine.javafxspringboottemplate;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMain {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }

}
