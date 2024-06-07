package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class HospitalSearch implements Initializable
{
    protected ArrayList<String> list = new ArrayList<>();
    protected static String labelName;
    private final String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospital List.txt";

    @FXML
    private Button srb1, srb2, srb3, srb4, srb5, srb6, srb7, srb8, srb9, srb10, srb11, srb12, srb13, srb14, srb15, srb16, srb17, b1;
    @FXML
    private TextField txt;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            reader.close();

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            srb1.setText("Your searching result will show here.");
            srb2.setText(list.get(0));
            srb3.setText(list.get(1));
            srb4.setText(list.get(2));
            srb5.setText(list.get(3));
            srb6.setText(list.get(4));
            srb7.setText(list.get(5));
            srb8.setText(list.get(6));
            srb9.setText(list.get(7));
            srb10.setText(list.get(8));
            srb11.setText(list.get(9));
            srb12.setText(list.get(10));
            srb13.setText(list.get(11));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    @FXML
    private void search()
    {
        if(txt.getText().length()==0)
        {
            srb1.setText("Your searching result will show here.");
            srb2.setText(list.get(0));
            srb3.setText(list.get(1));
            srb4.setText(list.get(2));
            srb5.setText(list.get(3));
            srb6.setText(list.get(4));
            srb7.setText(list.get(5));
            srb8.setText(list.get(6));
            srb9.setText(list.get(7));
            srb10.setText(list.get(8));
            srb11.setText(list.get(9));
            srb12.setText(list.get(10));
            srb13.setText(list.get(11));
        }
        else if(txt.getText().equals("BIRDEM") || txt.getText().equals("birdem") || txt.getText().equals("BIRDEM Hospital") || txt.getText().equals("birdem hospital"))
        {
            srb1.setText("BIRDEM General Hospital");
        }
        else if(txt.getText().equals("PG") || txt.getText().equals("pg") || txt.getText().equals("Bangabandhu Medical") || txt.getText().equals("Bangabandhu Sheikh Mujib Medical"))
        {
            srb1.setText("Bangabandhu Sheikh Mujib Medical University");
        }
        else if(txt.getText().equals("Dhaka Medical") || txt.getText().equals("Dhaka Medical Hospital") || txt.getText().equals("DMC") || txt.getText().equals("dmc"))
        {
            srb1.setText("Dhaka Medical College And Hospital");
        }
        else if(txt.getText().equals("Evercare") || txt.getText().equals("evercare") || txt.getText().equals("evercare hospital") || txt.getText().equals("evercare Hospital"))
        {
            srb1.setText("Evercare Hospital");
        }
        else if(txt.getText().equals("green") || txt.getText().equals("Green") || txt.getText().equals("green life") || txt.getText().equals("green life hospital") || txt.getText().equals("Green Life") || txt.getText().equals("Green Life Hospital"))
        {
            srb1.setText("Green Life Medical College Hospital");
        }
        else if(txt.getText().equals("Ibn Sina") || txt.getText().equals("ibn sina") || txt.getText().equals("Ibn Sina Hospital"))
        {
            srb1.setText("Ibn Sina Specialized Hospital");
        }
        else if(txt.getText().equals("Kurmitola") || txt.getText().equals("kurmitola") || txt.getText().equals("Kurmitola Hospital") || txt.getText().equals("kurmitola hospital"))
        {
            srb1.setText("Kurmitola General Hospital");
        }
        else if(txt.getText().equals("Labaid") || txt.getText().equals("Labaid") || txt.getText().equals("labaid hospital") || txt.getText().equals("Labaid Hospital"))
        {
            srb1.setText("Labaid Specialized Hospital");
        }
        else if(txt.getText().equals("Metropoliton") || txt.getText().equals("metropoliton") || txt.getText().equals("Metropoliton Medical") || txt.getText().equals("metropoliton medical"))
        {
            srb1.setText("Metropolitan Medical Centre");
        }
        else if(txt.getText().equals("NHF"))
        {
            srb1.setText("National Heart Foundation");
        }
        else if(txt.getText().equals("Square") || txt.getText().equals("square") || txt.getText().equals("Square Hospital") || txt.getText().equals("square hospital"))
        {
            srb1.setText("Square Hospital");
        }
        else if(txt.getText().equals("United") || txt.getText().equals("united") || txt.getText().equals("United Hospital") || txt.getText().equals("united hospital"))
        {
            srb1.setText("United Hospital Limited");
        }
        else
        {
            boolean flag = false;
            for(int i=0; i<list.size(); i++)
            {
                if(txt.getText().equals(list.get(i)))
                {
                    flag = true;
                    break;
                }
            }
            if(flag==true)
            {
                srb1.setText(txt.getText());
            }
            else
                srb1.setText("Sorry, this hospital is not available in our service !");
        }
    }

    @FXML
    private void done()
    {

    }

    @FXML
    private void b1(ActionEvent e) throws IOException
    {

        for(int i=0; i<list.size(); i++)
        {
            if(srb1.getText().equals(list.get(i)))
            {
                labelName = list.get(i);

                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("hospital-front.fxml"));
                Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 800, 500);
                window.setTitle("E-Hospital Service");
                //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
                //window.getIcons().add(icon);

                window.setScene(scene);
                window.show();
                break;
            }
        }
    }

    @FXML
    private void b2(ActionEvent e) throws IOException
    {
        labelName = list.get(0);

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
    private void b3(ActionEvent e) throws IOException
    {
        labelName = list.get(1);

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
    private void b4(ActionEvent e) throws IOException
    {
        labelName = list.get(2);

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
    private void b5(ActionEvent e) throws IOException
    {
        labelName = list.get(3);

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
    private void b6(ActionEvent e) throws IOException
    {
        labelName = list.get(4);

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
    private void b7(ActionEvent e) throws IOException
    {
        labelName = list.get(5);

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
    private void b8(ActionEvent e) throws IOException
    {
        labelName = list.get(6);

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
    private void b9(ActionEvent e) throws IOException
    {
        labelName = list.get(7);

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
    private void b10(ActionEvent e) throws IOException
    {
        labelName = list.get(8);

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
    private void b11(ActionEvent e) throws IOException
    {
        labelName = list.get(9);

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
    private void b12(ActionEvent e) throws IOException
    {
        labelName = list.get(10);

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
    private void b13(ActionEvent e) throws IOException
    {
        labelName = list.get(11);

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("hospital-front.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    public String getHospitalName()
    {
        return labelName;
    }
}
