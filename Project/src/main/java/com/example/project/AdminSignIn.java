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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminSignIn implements Initializable
{
    private ArrayList<String> list = new ArrayList<>();
    private final String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Admin List.txt";
    private static String hospitalName, gmail, name, line;

    @FXML
    private Button b2, b3;
    @FXML
    private Label l1, l2, ul, pl, warning;
    @FXML
    private TextField pass1;
    @FXML
    private PasswordField pass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition f1 = new FadeTransition(Duration.millis(1000));
        f1.setNode(l1);
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        FadeTransition f2 = new FadeTransition(Duration.millis(1000));
        f2.setNode(l2);
        f2.setFromValue(0);
        f2.setToValue(1);
        f2.play();

        FadeTransition f3 = new FadeTransition(Duration.millis(1000));
        f3.setNode(ul);
        f3.setFromValue(0);
        f3.setToValue(1);
        f3.play();

        FadeTransition f4 = new FadeTransition(Duration.millis(1000));
        f4.setNode(pl);
        f4.setFromValue(0);
        f4.setToValue(1);
        f4.play();

        FadeTransition f5 = new FadeTransition(Duration.millis(1000));
        f5.setNode(b2);
        f5.setFromValue(0);
        f5.setToValue(1);
        f5.play();

        FadeTransition f6 = new FadeTransition(Duration.millis(1000));
        f6.setNode(b3);
        f6.setFromValue(0);
        f6.setToValue(1);
        f6.play();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void back(ActionEvent e) throws IOException
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
    private void forget(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-forget-pass.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void done(ActionEvent e) throws IOException
    {
        boolean flag = false;
        for(int i=0; i<list.size(); i++)
        {
            String info[] = list.get(i).split(" ");
            if(pass1.getText().equals(info[2]) && pass.getText().equals(info[5]))
            {
                name = info[0]+" "+info[1];
                gmail = info[2];
                hospitalName = "";
                for(int j=6; j< info.length-1; j++)
                {
                    hospitalName+=info[j]+" ";
                }
                hospitalName+=info[info.length-1];

                line = "";
                for(int j=0; j<info.length; j++)
                {
                    line += info[j]+" ";
                }

                flag = true;
                break;
            }
        }
        if(flag==true)
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
        else
        {
            warning.setText("* Invalid  !");
        }
    }

    public String getName()
    {
        return name;
    }

    public String getHospitalName()
    {
        return hospitalName;
    }

    public String getGmail()
    {
        return gmail;
    }

    public String getLine()
    {
        return line;
    }
}
