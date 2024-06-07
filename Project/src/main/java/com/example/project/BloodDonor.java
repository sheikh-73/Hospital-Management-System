package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BloodDonor implements Initializable
{
    @FXML
    private TextField t1, t2, t3, t4;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String > gmailList = new ArrayList<>();
    private ArrayList<String > pathList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try
        {
            this.hospitalFileReader();
            this.allUserRead();
            this.allPathList();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void hospitalFileReader() throws IOException
    {
        HospitalSearch ob = new HospitalSearch();
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospitals\\"+ob.getHospitalName()+".txt";

        BufferedReader hospitalReader = new BufferedReader(new FileReader(path));
        String line2;
        while((line2 = hospitalReader.readLine()) != null)
        {
            list.add(line2);
        }
        hospitalReader.close();
    }

    private void allUserRead() throws IOException
    {
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\User List.txt";
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(path));

        while((line = reader.readLine()) != null)
        {
            String info[] = line.split(" ");
            gmailList.add(info[2]);
        }
        reader.close();
    }

    private void allPathList() throws IOException
    {
        String path = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\rafi@gmail.com.txt";
        for(int i=0; i<gmailList.size(); i++)
        {
            pathList.add("D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\UserProfile\\"+gmailList.get(i)+".txt");
        }
    }

    @FXML
    private void back(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("blood.fxml"));
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
        if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0 || t4.getText().length()==0)
        {
            if(t1.getText().length()==0) { t1.setPromptText("Enter Your Name");}
            if(t2.getText().length()==0) {t2.setPromptText("Enter Your Email");}
            if(t3.getText().length()==0) {t3.setPromptText("Enter Your Phone Number");}
            if(t4.getText().length()==0) {t4.setPromptText("Enter Your Blood Group");}
        }

        else
        {
            list.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText());
            this.hospitalFileWrite();
            this.sendAllUser();

            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("UserNotification.fxml"));
            Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 400, 600);
            window.setTitle("E-Hospital Service");
            //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
            //window.getIcons().add(icon);

            window.setScene(scene);
            window.show();
        }
    }

    private void sendAllUser() throws IOException
    {
        for(int i=0; i<pathList.size(); i++)
        {
            ArrayList<String> List = new ArrayList<>();

            this.read(pathList.get(i), List);

//            BufferedReader reader = new BufferedReader(new FileReader(pathList.get(i)));
//            while((line = reader.readLine()) != null)
//            {
//                List.add(line);
//            }

            List.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText());
            this.write(pathList.get(i), List);

//            for(int j=0; j<List.size(); j++)
//            {
//                writer.write(List.get(j)+"\n");
//            }
//            writer.close();
        }
    }

    private void read(String path, ArrayList<String> list)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;

            while((line = reader.readLine()) != null)
            {
                list.add(line);
            }
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    private void write(String path, ArrayList<String> list)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(int i=0; i<list.size(); i++)
            {
                writer.write(list.get(i)+"\n");
            }
            writer.close();;
        }
        catch (IOException e)
        {
            e.getMessage();
        }
    }

    private void hospitalFileWrite()
    {
        try
        {
            HospitalSearch ob = new HospitalSearch();
            String adminPath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Hospitals\\"+ob.getHospitalName()+".txt";

            BufferedWriter writer = new BufferedWriter(new FileWriter(adminPath));
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
