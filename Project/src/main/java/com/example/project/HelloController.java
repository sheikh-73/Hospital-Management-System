package com.example.project;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button aboutB, helpB, regB, logB, adminB;
    @FXML
    private Label l1, l2, l3, l4;

    @FXML
    private void registration(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("User-Registration.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void logIn(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("User-SignIn.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void admin(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-front.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void help()
    {

    }

    @FXML
    private void about()
    {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition f1 = new FadeTransition(Duration.millis(1000));
        f1.setNode(aboutB);
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        FadeTransition f2 = new FadeTransition(Duration.millis(1000));
        f2.setNode(helpB);
        f2.setFromValue(0);
        f2.setToValue(1);
        f2.play();

        FadeTransition f3 = new FadeTransition(Duration.millis(1000));
        f3.setNode(adminB);
        f3.setFromValue(0);
        f3.setToValue(1);
        f3.play();

        FadeTransition f4 = new FadeTransition(Duration.millis(1000));
        f4.setNode(logB);
        f4.setFromValue(0);
        f4.setToValue(1);
        f4.play();

        FadeTransition f5 = new FadeTransition(Duration.millis(1000));
        f5.setNode(regB);
        f5.setFromValue(0);
        f5.setToValue(1);
        f5.play();

        FadeTransition f6 = new FadeTransition(Duration.millis(1000));
        f6.setNode(l1);
        f6.setFromValue(0);
        f6.setToValue(1);
        f6.play();

        FadeTransition f7 = new FadeTransition(Duration.millis(1000));
        f7.setNode(l2);
        f7.setFromValue(0);
        f7.setToValue(1);
        f7.play();

        FadeTransition f8 = new FadeTransition(Duration.millis(1000));
        f8.setNode(l3);
        f8.setFromValue(0);
        f8.setToValue(1);
        f8.play();

        FadeTransition f9 = new FadeTransition(Duration.millis(1000));
        f9.setNode(l4);
        f9.setFromValue(0);
        f9.setToValue(1);
        f9.play();
    }
}