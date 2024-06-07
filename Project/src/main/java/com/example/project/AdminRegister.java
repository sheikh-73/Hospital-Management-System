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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class AdminRegister implements Initializable
{
    private ArrayList<String> list = new ArrayList<>();
    private final String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Admin List.txt";

    @FXML
    private Label rl, fl, ll, ul, hl, ml, yl, pl, l1, l2, l3, l4, l5, warning;
    @FXML
    private Button b1, bck;
    @FXML
    private TextField txt1, txt2, txt3, txt4, txt5, txt6;
    @FXML
    private PasswordField txt7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition f1 = new FadeTransition(Duration.millis(1000));
        f1.setNode(rl);
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        FadeTransition f2 = new FadeTransition(Duration.millis(1000));
        f2.setNode(fl);
        f2.setFromValue(0);
        f2.setToValue(1);
        f2.play();

        FadeTransition f3 = new FadeTransition(Duration.millis(1000));
        f3.setNode(ll);
        f3.setFromValue(0);
        f3.setToValue(1);
        f3.play();

        FadeTransition f4 = new FadeTransition(Duration.millis(1000));
        f4.setNode(ul);
        f4.setFromValue(0);
        f4.setToValue(1);
        f4.play();

        FadeTransition f5 = new FadeTransition(Duration.millis(1000));
        f5.setNode(hl);
        f5.setFromValue(0);
        f5.setToValue(1);
        f5.play();

        FadeTransition f6 = new FadeTransition(Duration.millis(1000));
        f6.setNode(yl);
        f6.setFromValue(0);
        f6.setToValue(1);
        f6.play();

        FadeTransition f7 = new FadeTransition(Duration.millis(1000));
        f7.setNode(ml);
        f7.setFromValue(0);
        f7.setToValue(1);
        f7.play();

        FadeTransition f8 = new FadeTransition(Duration.millis(1000));
        f8.setNode(pl);
        f8.setFromValue(0);
        f8.setToValue(1);
        f8.play();

        FadeTransition f9 = new FadeTransition(Duration.millis(1000));
        f9.setNode(l1);
        f9.setFromValue(0);
        f9.setToValue(1);
        f9.play();

        FadeTransition f10 = new FadeTransition(Duration.millis(1000));
        f10.setNode(l2);
        f10.setFromValue(0);
        f10.setToValue(1);
        f10.play();

        FadeTransition f11 = new FadeTransition(Duration.millis(1000));
        f11.setNode(l3);
        f11.setFromValue(0);
        f11.setToValue(1);
        f11.play();

        FadeTransition f12 = new FadeTransition(Duration.millis(1000));
        f12.setNode(l4);
        f12.setFromValue(0);
        f12.setToValue(1);
        f12.play();

        FadeTransition f13 = new FadeTransition(Duration.millis(1000));
        f13.setNode(l5);
        f13.setFromValue(0);
        f13.setToValue(1);
        f13.play();

        FadeTransition f14 = new FadeTransition(Duration.millis(1000));
        f14.setNode(b1);
        f14.setFromValue(0);
        f14.setToValue(1);
        f14.play();

        FadeTransition f15 = new FadeTransition(Duration.millis(1000));
        f15.setNode(bck);
        f15.setFromValue(0);
        f15.setToValue(1);
        f15.play();

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
    private void done(ActionEvent e) throws IOException
    {
        if(txt1.getText().length()==0 || txt2.getText().length()==0 || txt3.getText().length()==0|| txt4.getText().length()==0 || txt5.getText().length()==0 || txt6.getText().length()==0 || txt7.getText().length()==0)
        {
            if(txt1.getText().length()==0)
            {
                txt1.setStyle("-fx-border-color: Red");
                txt1.setPromptText("Enter Your First Name");
            }
            if(txt1.getText().length()!=0)
            {
                txt1.setStyle("-fx-border-color: White");
                txt1.setPromptText("");
            }

            if(txt2.getText().length()==0)
            {
                txt2.setStyle("-fx-border-color: Red");
                txt2.setPromptText("Enter Your Last Name");
            }
            if(txt2.getText().length()!=0)
            {
                txt2.setStyle("-fx-border-color: White");
                txt2.setPromptText("");
            }

            if(txt3.getText().length()==0)
            {
                txt3.setStyle("-fx-border-color: Red");
                txt3.setPromptText("Enter Your username");
            }
            if(txt3.getText().length()!=0)
            {
                txt3.setStyle("-fx-border-color: White");
                txt3.setPromptText("");
            }

            if(txt4.getText().length()==0)
            {
                txt4.setStyle("-fx-border-color: Red");
                txt4.setPromptText("Enter Hospital Name where you work");
            }
            if(txt4.getText().length()!=0)
            {
                txt4.setStyle("-fx-border-color: White");
                txt4.setPromptText("");
            }

            if(txt5.getText().length()==0)
            {
                txt5.setStyle("-fx-border-color: Red");
                txt5.setPromptText("Enter Mobile Number");
            }
            if(txt5.getText().length()!=0)
            {
                txt5.setStyle("-fx-border-color: White");
                txt5.setPromptText("");
            }
            if(txt6.getText().length()==0)
            {
                txt6.setStyle("-fx-border-color: Red");
                txt6.setPromptText("Enter Your Position");
            }
            if(txt6.getText().length()!=0)
            {
                txt6.setStyle("-fx-border-color: White");
                txt6.setPromptText("");
            }
            if(txt7.getText().length()==0)
            {
                txt7.setStyle("-fx-border-color: Red");
                txt7.setPromptText("Enter Your Email");
            }
            if(txt7.getText().length()!=0)
            {
                txt7.setStyle("-fx-border-color: White");
                txt7.setPromptText("");
            }
        }
        else
        {
            boolean flag = false;

            for(int i=0; i<list.size(); i++)
            {
                String info[] = list.get(i).split(" ");
                if(txt3.getText().equals(info[2]))
                {
                    flag = true;
                    break;
                }
            }
            if(flag==false)
            {
                this.fileWrite();

                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("admin-login.fxml"));
                Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 800, 500);
                window.setTitle("E-Hospital Service");
                //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
                //window.getIcons().add(icon);

                window.setScene(scene);
                window.show();
            }
            else
            {
                warning.setText("*Available this username !");
            }
        }
    }

    private void fileWrite()
    {
        try
        {
            String  info1[] = txt1.getText().split(" ");
            String info2[] = txt2.getText().split(" ");
            String info6[] = txt6.getText().split(" ");
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            list.add(info1[0]+" "+info2[0]+" "+txt3.getText()+" "+txt5.getText()+" "+info6[0]+" "+txt7.getText()+" "+txt4.getText());

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String info1[] = o1.split(" ");
                    String info2[] = o2.split(" ");
                    return info1[5].compareTo(info2[5]);
                }
            });

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
}
