package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BedRent implements Initializable
{
    @FXML
    private TextField t1, t2, t3, t4;
    @FXML
    private Label l1, l2, l3, l4, l5, l6;

    @FXML
    private Pane p1, p2;
    private static String number;
    private static String line;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BedList ob = new BedList();
        t2.setText(ob.getBedName());
    }

    @FXML
    private void back(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("bed-list.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 692, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void done()
    {
        if(t1.getText().length()==0 || t3.getText().length()==0 || t4.getText().length()==0)
        {
            if(t1.getText().length()==0) { t1.setPromptText("Enter Your Name");}
            if(t3.getText().length()==0) { t3.setPromptText("Enter Your Mobile Number !");}
            if(t4.getText().length()==0) { t4.setPromptText("Enter Date !");}
        }
        else
        {
            BedList ob = new BedList();
            UserSignIn ob2 = new UserSignIn();
            number = t3.getText();

            line = t1.getText()+" "+ob.getBedAmount()+" "+t3.getText()+" "+ob2.getGmail()+" "+ob.getBedName()+" "+t4.getText();

            l1.setText(t1.getText());
            l2.setText(ob.getBedAmount());
            l3.setText(t3.getText());
            l4.setText(ob2.getGmail());
            l5.setText(ob.getBedName());
            l6.setText(t4.getText());


            TranslateTransition t1 = new TranslateTransition(Duration.millis(1000));
            t1.setNode(p1);
            t1.setByX(550);
            t1.play();

            TranslateTransition t2 = new TranslateTransition(Duration.millis(1000));
            t2.setNode(p2);
            t2.setByY(495);
            t2.play();
        }
    }

    @FXML
    private void pay(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Payment.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 520, 575);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    public String getNumber()
    {
        return number;
    }

    public String getLine()
    {
        return line;
    }
}