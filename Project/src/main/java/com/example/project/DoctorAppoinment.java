package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DoctorAppoinment implements Initializable
{
    @FXML
    private Pane p, p1, p2, p3, p4;
    @FXML
    private Button b2;
    @FXML
    private Label l1, l2, l3, l4, l5;
    @FXML
    private TextField t1, t2, t3;
    @FXML
    private TextArea T;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> hospitalMsgList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            this.userFileReader();
            this.hospitalFileReader();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void userFileReader() throws IOException
    {
        UserSignIn ob = new UserSignIn();
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\UserProfile\\"+ob.getGmail()+".txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String  line;
        while((line = reader.readLine()) != null)
        {
            list.add(line);
        }
        reader.close();
    }

    private void hospitalFileReader() throws IOException
    {
        HospitalSearch ob2 = new HospitalSearch();
        String adminPath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospitals\\"+ob2.getHospitalName()+".txt";

        BufferedReader hospitalReader = new BufferedReader(new FileReader(adminPath));
        String line2;
        while((line2 = hospitalReader.readLine()) != null)
        {
            hospitalMsgList.add(line2);
        }
        hospitalReader.close();
    }

    @FXML
    private void back(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("doctors-list.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void submit(ActionEvent e) throws IOException
    {
        list.add(l1.getText()+" "+l2.getText()+" "+l3.getText()+" "+l4.getText());
        hospitalMsgList.add(l1.getText()+" "+l2.getText()+" "+l3.getText()+" "+l4.getText());
        fileWrite();
        Write();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("UserNotification.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 600);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void done()
    {
        if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0 || T.getText().length()==0)
        {
            if(t1.getText().length()==0)
            {
                t1.setStyle("-fx-border-radius: 5; -fx-border-color: Red");
            }
            if(t1.getText().length() != 0) { t1.setStyle("-fx-border-radius: 5; -fx-border-color: White"); }

            if(t2.getText().length()==0)
            {
                t2.setStyle("-fx-border-radius: 5; -fx-border-color: Red");
            }
            if(t2.getText().length() != 0) { t2.setStyle("-fx-border-radius: 5; -fx-border-color: White"); }

            if(t3.getText().length()==0)
            {
                t3.setStyle("-fx-border-radius: 5; -fx-border-color: Red");
            }
            if(t3.getText().length() != 0) { t3.setStyle("-fx-border-radius: 5; -fx-border-color: White"); }

            if(T.getText().length()==0)
            {
                T.setStyle("-fx-border-radius: 5; -fx-border-color: Red");
            }
            if(T.getText().length() != 0) { T.setStyle("-fx-border-radius: 5; -fx-border-color: White"); }
        }
        else
        {
            t1.setStyle("-fx-border-radius: 5; -fx-border-color: White");
            t2.setStyle("-fx-border-radius: 5; -fx-border-color: White");
            t3.setStyle("-fx-border-radius: 5; -fx-border-color: White");
            T.setStyle("-fx-border-radius: 5; -fx-border-color: White");

            DoctorsList ob = new DoctorsList();
            b2.setDisable(true);

            l1.setText(t1.getText());
            l2.setText(t2.getText());
            l3.setText(t3.getText());
            l4.setText(ob.getDoctorName());
            l5.setText("700");

            TranslateTransition t1 = new TranslateTransition(Duration.millis(1000));
            t1.setNode(p3);
            t1.setByY(373);
            t1.play();
        }
    }

    private void fileWrite()
    {
        UserSignIn ob = new UserSignIn();
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\UserProfile\\"+ob.getGmail()+".txt";
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
            e.printStackTrace();
        }
    }

    private void Write()
    {
        try
        {
            HospitalSearch ob = new HospitalSearch();
            String adminPath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospitals\\"+ob.getHospitalName()+".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(adminPath));
            for(int i=0; i<hospitalMsgList.size(); i++)
            {
                writer.write(hospitalMsgList.get(i)+"\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
