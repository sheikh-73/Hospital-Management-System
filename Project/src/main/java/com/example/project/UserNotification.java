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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserNotification implements Initializable
{
    private ArrayList<Pane> paneList = new ArrayList<>();
    private ArrayList<Label> labelList = new ArrayList<>();
    private int i=0;

    @FXML
    private Pane p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15;
    @FXML
    private Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.getPaneList();
            this.getLabelList();
            this.connectThread();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private void connectThread() throws IOException
    {
        UserSignIn ob = new UserSignIn();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\UserProfile\\"+ob.getGmail()+".txt";
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
                Platform.runLater(() -> labelList.get(i++).setText(finalLine+""));
            }
        }
    }

    @FXML
    private void back(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");

        window.setScene(scene);
        window.show();
    }

    public void getPaneList()
    {
        paneList.add(p1);
        paneList.add(p2);
        paneList.add(p3);
        paneList.add(p4);
        paneList.add(p5);
        paneList.add(p6);
        paneList.add(p7);
        paneList.add(p8);
        paneList.add(p9);
        paneList.add(p10);
        paneList.add(p11);
        paneList.add(p12);
        paneList.add(p13);
        paneList.add(p14);
        paneList.add(p15);
    }

    public void getLabelList()
    {
        labelList.add(l1);
        labelList.add(l2);
        labelList.add(l3);
        labelList.add(l4);
        labelList.add(l5);
        labelList.add(l6);
        labelList.add(l7);
        labelList.add(l8);
        labelList.add(l9);
        labelList.add(l10);
        labelList.add(l11);
        labelList.add(l12);
        labelList.add(l13);
        labelList.add(l14);
        labelList.add(l15);
    }

}
