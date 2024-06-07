package com.example.project;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserForgetPass implements Initializable
{
    private static ArrayList<String > list = new ArrayList<>();
    private final String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User List.txt";
    private static int a;


    @FXML
    private Pane p1, p2;
    @FXML
    private Label warning, warning1, fl, ml, ul;
    @FXML
    private Button submitB;
    @FXML
    private TextField mt, ut, ut1;
    @FXML
    private PasswordField newPass;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition f1 = new FadeTransition(Duration.millis(1000));
        f1.setNode(fl);
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        FadeTransition f2 = new FadeTransition(Duration.millis(1000));
        f2.setNode(ml);
        f2.setFromValue(0);
        f2.setToValue(1);
        f2.play();

        FadeTransition f3 = new FadeTransition(Duration.millis(1000));
        f3.setNode(ul);
        f3.setFromValue(0);
        f3.setToValue(1);
        f3.play();

        FadeTransition f4 = new FadeTransition(Duration.millis(1000));
        f4.setNode(submitB);
        f4.setFromValue(0);
        f4.setToValue(1);
        f4.play();

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
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("User-SignIn.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 600);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }
    @FXML
    private void done(ActionEvent e) throws IOException
    {
        warning1.setText("");

        String info[] = list.get(a).split(" ");
        info[4] = newPass.getText();
        list.set(a, info[0]+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]);

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for(int i=0; i<list.size(); i++)
        {
            writer.write(list.get(i)+"\n");
        }
        writer.close();

        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("User-SignIn.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void submit() throws IOException
    {
        boolean flag = false;
        for(int i=0; i<list.size(); i++)
        {
            String info[] = list.get(i).split(" ");
            if(mt.getText().equals(info[3]) && ut.getText().equals(info[2]))
            {
                flag = true;
                a = i;
                System.out.println(1000);
                TranslateTransition t1 = new TranslateTransition(Duration.millis(1000));
                t1.setNode(p1);
                t1.setByY(400);
                t1.play();
                warning.setText("");
                break;
            }
        }
        if(flag==false)
        {
            warning.setText("* Invalid !");
        }
    }

    @FXML
    private void verify()
    {
        if(ut1.getText().equals("1000"))
        {
            TranslateTransition t1 = new TranslateTransition(Duration.millis(1000));
            t1.setNode(p1);
            t1.setByY(400);
            t1.play();

            TranslateTransition t2 = new TranslateTransition(Duration.millis(1000));
            t2.setNode(p2);
            t2.setByY(475);
            t2.play();
            warning1.setText("");
        }
        else
            warning1.setText("* Invalid !");
    }

}
