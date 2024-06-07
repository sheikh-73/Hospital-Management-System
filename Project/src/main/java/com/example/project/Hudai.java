package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Hudai implements Initializable
{
    @FXML
    private Label l1, l2;
    @FXML
    private Button b1;
    ArrayList<Label> l = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l.add(l1);
        l.add(l2);
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Mohammad Rafi.txt";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }

            for(int i=0; i<2; i++)
            {
                l.get(i).setText(list.get(i));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
