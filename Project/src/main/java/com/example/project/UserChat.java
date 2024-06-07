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
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserChat implements Initializable
{
    @FXML
    private Label name;
    @FXML
    private TextField t1;
    @FXML
    private TextArea T;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserSignIn ob = new UserSignIn();
        name.setText(ob.getFullName());

        this.connectThread();

    }

    private void connectThread()
    {
        UserSignIn ob2 = new UserSignIn();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User Chat Server\\"+ob2.getGmail()+" chat server.txt";

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
    private void send()
    {
        if(t1.getText().length()==0)
        {
            t1.setPromptText("Please Enter Your Message !");
        }
        else
        {
            this.fileRead();
            this.hospitalChatRead();
            t1.clear();
        }

    }

    private void fileRead()
    {
        ArrayList<String> list = new ArrayList<>();
        UserSignIn ob2 = new UserSignIn();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User Chat Server\\"+ob2.getGmail()+" chat server.txt";

        try
        {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            list.add(ob2.getGmail()+": "+t1.getText());

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

    private void hospitalChatRead()
    {
        ArrayList<String> list = new ArrayList<>();
        UserSignIn ob2 = new UserSignIn();
        HospitalSearch ob = new HospitalSearch();
        String filePath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospital Chat Server\\"+ob.getHospitalName()+" Chat Server.txt";

        try
        {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
            list.add(ob2.getGmail()+": "+t1.getText());

            this.fileWrite(filePath, list);
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }
}
