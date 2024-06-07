package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class BedList extends HospitalFront implements Initializable
{
    // United Hospital Limited
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Button> buttonList = new ArrayList<>();
    private BufferedReader reader;
    private String path;
    private static String bedName;

    @FXML
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    @FXML
    private ScrollPane s1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HospitalSearch ob = new HospitalSearch();
        path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\BedList\\"+ob.getHospitalName()+".txt";
        try
        {
            reader = new BufferedReader(new FileReader(path));
            String line;

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            reader.close();

            buttonList.add(b1);
            buttonList.add(b2);
            buttonList.add(b3);
            buttonList.add(b4);
            buttonList.add(b5);
            buttonList.add(b6);
            buttonList.add(b7);
            buttonList.add(b8);
            buttonList.add(b9);
            buttonList.add(b10);

            for(int i=0; i<buttonList.size(); i++)
            {
                buttonList.get(i).setDisable(false);
                buttonList.get(i).setText(list.get(i));
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void back(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("hospital-front.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void all()
    {
        for(int i=0; i<buttonList.size(); i++)
        {
            buttonList.get(i).setDisable(false);
            buttonList.get(i).setText(list.get(i));
        }
    }

    @FXML
    private void vip()
    {
        for(int i=0; i<4; i++)
        {
            buttonList.get(i).setDisable(false);
            buttonList.get(i).setText(list.get(i));
        }

        for(int i=4; i<buttonList.size(); i++)
        {
            buttonList.get(i).setDisable(true);
        }
    }

    @FXML
    private void mid()
    {
        for(int i=0; i<4; i++)
        {
            buttonList.get(i).setDisable(false);
            buttonList.get(i).setText(list.get(i+4));
        }

        for(int i=4; i<buttonList.size(); i++)
        {
            buttonList.get(i).setDisable(true);
        }
    }

    @FXML
    private void low()
    {
        for(int i=0; i<4; i++)
        {
            buttonList.get(i).setDisable(false);
            buttonList.get(i).setText(list.get(i+6));
        }

        for(int i=4; i<buttonList.size(); i++)
        {
            buttonList.get(i).setDisable(true);
        }

    }

    @FXML
    private void bb1(ActionEvent e) throws IOException
    {
        //System.out.println(b1.getText());
        bedName = b1.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb2(ActionEvent e) throws IOException
    {
        //System.out.println(b2.getText());
        bedName = b2.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb3(ActionEvent e) throws IOException
    {
        //System.out.println(b3.getText());
        bedName = b3.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb4(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b4.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb5(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b5.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb6(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b6.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb7(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b7.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb8(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b8.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb9(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b9.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void bb10(ActionEvent e) throws IOException
    {
        //System.out.println(b4.getText());
        bedName = b10.getText();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    public String getBedName()
    {
        String info[] = bedName.split(" ");
        return info[0];
    }

    public String getBedAmount()
    {
        String info[] = bedName.split(" ");
        return info[1];
    }

}
