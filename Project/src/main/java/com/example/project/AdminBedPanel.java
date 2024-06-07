package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AdminBedPanel implements Initializable
{
    private ArrayList<Label> labelList = new ArrayList<>();
    private ArrayList<Label> rentList = new ArrayList<>();
    private ArrayList<String > list = new ArrayList<>();

    @FXML
    private Label l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    @FXML
    private Label r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    @FXML
    private TextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    @FXML
    private Button b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.addLabelList();
        this.addRentList();
        AdminSignIn ob = new AdminSignIn();
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\BedList\\"+ob.getHospitalName()+".txt";

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            reader.close();

            this.show();

        }
        catch (IOException e)
        {
            e.getMessage();
        }

    }

    private void show()
    {
        for(int i=0; i<list.size(); i++)
        {
            String info[] = list.get(i).split(" ");
            labelList.get(i).setText(info[0]);
            rentList.get(i).setText(info[1]);
        }
    }

    private void addLabelList()
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
    }

    private void addRentList()
    {
        rentList.add(r1);
        rentList.add(r2);
        rentList.add(r3);
        rentList.add(r4);
        rentList.add(r5);
        rentList.add(r6);
        rentList.add(r7);
        rentList.add(r8);
        rentList.add(r9);
        rentList.add(r10);

    }

    @FXML
    private void back(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-notification.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb1()
    {
        list.set(0, labelList.get(0).getText()+" "+t1.getText()+"BDT");
        r1.setText(t1.getText()+"BDT");
        t1.clear();
        this.fileWrite();
    }

    @FXML
    private void bb2()
    {
        list.set(1, labelList.get(1).getText()+" "+t2.getText()+"BDT");
        r2.setText(t2.getText()+"BDT");
        t2.clear();
        this.fileWrite();
    }

    @FXML
    private void bb3()
    {
        list.set(2, labelList.get(2).getText()+" "+t3.getText()+"BDT");
        r3.setText(t3.getText()+"BDT");
        t3.clear();
        this.fileWrite();
    }

    @FXML
    private void bb4()
    {
        list.set(3, labelList.get(3).getText()+" "+t4.getText()+"BDT");
        r4.setText(t4.getText()+"BDT");
        t4.clear();
        this.fileWrite();
    }

    @FXML
    private void bb5()
    {
        list.set(4, labelList.get(4).getText()+" "+t5.getText()+"BDT");
        r5.setText(t5.getText()+"BDT");
        t5.clear();
        this.fileWrite();
    }

    @FXML
    private void bb6()
    {
        list.set(5, labelList.get(5).getText()+" "+t6.getText()+"BDT");
        r6.setText(t6.getText()+"BDT");
        t6.clear();
        this.fileWrite();
    }

    @FXML
    private void bb7()
    {
        list.set(6, labelList.get(6).getText()+" "+t7.getText()+"BDT");
        r7.setText(t7.getText()+"BDT");
        t7.clear();
        this.fileWrite();
    }

    @FXML
    private void bb8()
    {
        list.set(7, labelList.get(7).getText()+" "+t8.getText()+"BDT");
        r8.setText(t8.getText()+"BDT");
        t8.clear();
        this.fileWrite();
    }

    @FXML
    private void bb9()
    {
        list.set(8, labelList.get(8).getText()+" "+t9.getText()+"BDT");
        r9.setText(t9.getText()+"BDT");
        t9.clear();
        this.fileWrite();
    }

    @FXML
    private void bb10()
    {
        list.set(9, labelList.get(9).getText()+" "+t10.getText()+"BDT");
        r10.setText(t10.getText()+"BDT");
        t10.clear();
        this.fileWrite();
    }

    private void fileWrite()
    {
        AdminSignIn ob = new AdminSignIn();
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\BedList\\"+ob.getHospitalName()+".txt";

        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(int i=0; i<list.size(); i++)
            {
                writer.write(list.get(i)+"\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }
}
