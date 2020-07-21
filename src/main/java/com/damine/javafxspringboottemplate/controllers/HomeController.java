package com.damine.javafxspringboottemplate.controllers;

import com.damine.javafxspringboottemplate.services.WelcomeService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class HomeController implements Initializable {
    @FXML
    private Label label;

    private final WelcomeService welcomeService;

    @Autowired
    public HomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(welcomeService.welcome());
    }
}
