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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class UserRegistration implements Initializable
{
    private ArrayList<String > list = new ArrayList<>();
    private String gmail;
    private final String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User List.txt";

    @FXML
    private Label fn, ln, un, mn, pass, l1, l2, reg, warning;
    @FXML
    private Button logB;
    @FXML
    private TextField txt1, txt2, txt3, txt4;
    @FXML
    private PasswordField txt5;

    @FXML
    private void logIn(ActionEvent e) throws IOException
    {
        if(txt1.getText().length()==0 || txt2.getText().length()==0 || txt3.getText().length()==0|| txt4.getText().length()==0 || txt5.getText().length()==0)
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
                txt4.setPromptText("Enter Your Mobile Number");
            }
            if(txt4.getText().length()!=0)
            {
                txt4.setStyle("-fx-border-color: White");
                txt4.setPromptText("");
            }

            if(txt5.getText().length()==0)
            {
                txt5.setStyle("-fx-border-color: Red");
                txt5.setPromptText("Enter password");
            }
            if(txt5.getText().length()!=0)
            {
                txt5.setStyle("-fx-border-color: White");
                txt5.setPromptText("");
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
                this.createFile();
                this.createChatFile();

                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("User-SignIn.fxml"));
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


    // Check username available or not:
    private void fileWrite()
    {
        try
        {
            String  info1[] = txt1.getText().split(" ");
            String info2[] = txt2.getText().split(" ");
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));

            gmail = txt3.getText();
            list.add(info1[0]+" "+info2[0]+" "+txt3.getText()+" "+txt4.getText()+" "+txt5.getText());

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String info1[] = o1.split(" ");
                    String info2[] = o2.split(" ");
                    return info1[2].compareTo(info2[2]);
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

    // create new file by his gmail:
    // D:\Team Falcon (AOOP Project)\Project\src\main\resources\com\example\All File\UserProfile\Demo.txt
    private void createFile()
    {
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\UserProfile\\"+gmail+".txt";
        try
        {
            Path path = Paths.get(filePath);
            Files.createFile(path);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void createChatFile()
    {
        String userChatPath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User Chat Server\\"+gmail+" chat server.txt";
        try
        {
            Path path2 = Paths.get(userChatPath);
            Files.createFile(path2);
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    // Animation:
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition f1 = new FadeTransition(Duration.millis(1000));
        f1.setNode(reg);
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        FadeTransition f2 = new FadeTransition(Duration.millis(1000));
        f2.setNode(l1);
        f2.setFromValue(0);
        f2.setToValue(1);
        f2.play();

        FadeTransition f3 = new FadeTransition(Duration.millis(1000));
        f3.setNode(l2);
        f3.setFromValue(0);
        f3.setToValue(1);
        f3.play();

        FadeTransition f4 = new FadeTransition(Duration.millis(1000));
        f4.setNode(fn);
        f4.setFromValue(0);
        f4.setToValue(1);
        f4.play();

        FadeTransition f5 = new FadeTransition(Duration.millis(1000));
        f5.setNode(ln);
        f5.setFromValue(0);
        f5.setToValue(1);
        f5.play();

        FadeTransition f6 = new FadeTransition(Duration.millis(1000));
        f6.setNode(un);
        f6.setFromValue(0);
        f6.setToValue(1);
        f6.play();

        FadeTransition f7 = new FadeTransition(Duration.millis(1000));
        f7.setNode(mn);
        f7.setFromValue(0);
        f7.setToValue(1);
        f7.play();

        FadeTransition f8 = new FadeTransition(Duration.millis(1000));
        f8.setNode(pass);
        f8.setFromValue(0);
        f8.setToValue(1);
        f8.play();

        FadeTransition f9 = new FadeTransition(Duration.millis(1000));
        f9.setNode(logB);
        f9.setFromValue(0);
        f9.setToValue(1);
        f9.play();

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
}
