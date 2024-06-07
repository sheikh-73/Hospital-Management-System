package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminChat implements Initializable
{
    @FXML
    private Label name;
    @FXML
    private TextField t1;
    @FXML
    private TextArea T;
    private String userGmail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AdminSignIn ob = new AdminSignIn();
        name.setText(ob.getHospitalName());

        this.connectThread();
    }

    private void connectThread()
    {
        AdminSignIn ob2 = new AdminSignIn();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospital Chat Server\\"+ob2.getHospitalName()+" chat server.txt";

        Thread connect = new Thread(() -> {
            try
            {
                this.chat(filePath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });
        connect.start();
    }

    private void chat(String filePath) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while(true)
        {
            while ((line = reader.readLine()) != null)
            {
                T.appendText(line+"\n");
            }
        }
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
    private void send(ActionEvent e) throws IOException
    {
        if(t1.getText().length()==0)
        {
            t1.setPromptText("Please Enter Your Message !");
        }
        else
        {
            this.fileRead();
            this.userChatRead();
            t1.clear();
        }
    }

    private void fileRead()
    {
        ArrayList<String> list = new ArrayList<>();
        AdminSignIn ob2 = new AdminSignIn();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospital Chat Server\\"+ob2.getHospitalName()+" chat server.txt";

        try
        {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            list.add(ob2.getHospitalName()+": "+t1.getText());

            this.fileWrite(filePath, list);
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    private void fileWrite(String filePath, ArrayList<String> list) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for(int i=0; i<list.size(); i++)
        {
            writer.write(list.get(i)+"\n");
        }
        writer.close();
    }

    private void userChatRead()
    {
        ArrayList<String> list = new ArrayList<>();
        AdminSignIn ob2 = new AdminSignIn();

        String msg = "";
        String info[] = t1.getText().split(" ");
        userGmail = info[0];
        for(int i=1; i< info.length; i++)
        {
            msg += info[i]+" ";
        }

        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User Chat Server\\"+userGmail+" Chat Server.txt";

        try
        {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            list.add(ob2.getHospitalName()+": "+msg);

            this.fileWrite(filePath, list);
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }
}
