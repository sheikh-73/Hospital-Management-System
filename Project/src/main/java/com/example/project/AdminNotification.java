package com.example.project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.SplittableRandom;

public class AdminNotification implements Initializable
{
    @FXML
    private Pane p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
    @FXML
    private Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;

    private ArrayList<Pane> p = new ArrayList<>();
    private ArrayList<Label> l = new ArrayList<>();
    private int i=0;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.pane();
            this.label();
            this.connectThread();
        }
        catch(IOException e)
        {
                e.printStackTrace();
        }
    }

    private void connectThread() throws IOException
    {
        AdminSignIn ob = new AdminSignIn();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospitals\\"+ob.getHospitalName()+".txt";
        Thread connect = new Thread(() -> {
            try
            {
                this.read(filePath);
            }
            catch (IOException e)
            {
                e.getMessage();
            }
        });
        connect.start();
    }

    private void read(String filePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while(true)
        {
            while((line = reader.readLine()) != null)
            {
                String finalLine = line;
                Platform.runLater(() -> l.get(i++).setText(finalLine+""));
                System.out.println(line);
            }
        }
    }

    private void pane()
    {
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        p.add(p6);
        p.add(p7);
        p.add(p8);
        p.add(p9);
        p.add(p10);
        p.add(p11);
        p.add(p12);
        p.add(p13);
        p.add(p14);
        p.add(p15);
    }

    public void label()
    {
        l.add(l1);
        l.add(l2);
        l.add(l3);
        l.add(l4);
        l.add(l5);
        l.add(l6);
        l.add(l7);
        l.add(l8);
        l.add(l9);
        l.add(l10);
        l.add(l11);
        l.add(l12);
        l.add(l13);
        l.add(l14);
        l.add(l15);
    }

    @FXML
    private void bed(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminBedPanel.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 450);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bloodBank(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AdminBloodPanel.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 450);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void chat(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-chat.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void profile(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-profile.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }
}
