package com.example.project;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminFront implements Initializable
{
    @FXML
    private Button reg, log;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition f1 = new FadeTransition(Duration.millis(1000));
        f1.setNode(reg);
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        FadeTransition f2 = new FadeTransition(Duration.millis(1000));
        f2.setNode(log);
        f2.setFromValue(0);
        f2.setToValue(1);
        f2.play();
    }

    @FXML
    private void logIn(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-login.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void register(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-registration.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }
}
