package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Payment implements Initializable
{
    @FXML
    private Label l1, l2;
    @FXML
    private PasswordField t1;
    @FXML
    private Pane p1;
    private ArrayList<String > list = new ArrayList<>();
    private static String path;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BedList ob = new BedList();
        BedRent ob2 = new BedRent();
        l1.setText(ob.getBedAmount());
        String info[] = ob2.getNumber().split("");
        String number = "";
        for(int i=0; i<3; i++)
        {
            number += info[i];
        }
        number+="******";
        for(int i=info.length-3; i< info.length; i++)
        {
            number+=info[i];
        }

        l2.setText(number);

        UserSignIn ob3 = new UserSignIn();
        path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\UserProfile\\"+ob3.getGmail()+".txt";
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while ((line = reader.readLine()) != null)
            {
                list.add(line);
            }
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    @FXML
    private void confirm(ActionEvent e) throws IOException
    {
        if(t1.getText().length()==0)
        {
            t1.setPromptText("Enter Your Valid Pin");
        }
        else
        {
            TranslateTransition t = new TranslateTransition(Duration.millis(1000));
            t.setNode(p1);
            t.setByX(345);
            t.play();

            BedRent ob = new BedRent();
            list.add(ob.getLine());
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                for(int i=0; i<list.size(); i++)
                {
                    writer.write(list.get(i)+"\n");
                }
                writer.close();
            }
            catch (IOException e2)
            {
                e2.getMessage();
            }


        }
    }

    @FXML
    private void close(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("BedRent.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 550, 550);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }
}
