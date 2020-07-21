package com.damine.javafxspringboottemplate.controllers;

import com.damine.javafxspringboottemplate.services.WelcomeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class HomeController implements Initializable {
    @FXML
    private Label label;

    private final WelcomeService welcomeService;
    private final ApplicationContext applicationContext ;

    @Autowired
    public HomeController(WelcomeService welcomeService,ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.welcomeService = welcomeService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(welcomeService.welcome());
    }

    @FXML
    void go(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/fxml/second.fxml");
            loader.setLocation(xmlUrl);
            loader.setControllerFactory(applicationContext::getBean);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
