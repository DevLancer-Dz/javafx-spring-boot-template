package com.damine.javafxspringboottemplate;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.URL;

public class JavaFxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/fxml/home.fxml");
            loader.setLocation(xmlUrl);
            loader.setControllerFactory(this::createControllerForType);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object createControllerForType(Class<?> type) {
        return this.applicationContext.getBean(type);
    }

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpringMain.class)
                .run(args);
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}
