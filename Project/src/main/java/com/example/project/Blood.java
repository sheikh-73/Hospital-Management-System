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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Blood implements Initializable
{
    @FXML
    private Label l1, l2, l3, l4, l5, l6, l7, l8;
    @FXML
    private Pane p, p3;
    @FXML
    private Button b1, b2;
    @FXML
    private TextField t1, t2, t3, t4;
    @FXML
    private TextArea T;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Label> lList = new ArrayList<>();
    private ArrayList<String> hospitalMsgList = new ArrayList<>();
    private ArrayList<String > gmailList = new ArrayList<>();
    private ArrayList<String > pathList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lList.add(l1);
        lList.add(l2);
        lList.add(l3);
        lList.add(l4);
        lList.add(l5);
        lList.add(l6);
        lList.add(l7);
        lList.add(l8);

        try
        {
            this.hospitalFileReader();
            this.availableBlood();
            this.allUserRead();
            this.allPathList();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
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

    private void availableBlood()
    {
        HospitalSearch ob = new HospitalSearch();
        String bloodBankPath = "D:\\Team Falcon (AOOP Project)\\Project\\src\\main\\resources\\com\\example\\All File\\Blood Bank\\"+ob.getHospitalName()+".txt";
        try
        {
            BufferedReader bloodBankReader = new BufferedReader(new FileReader(bloodBankPath));
            int i=0;
            String line;

            while((line = bloodBankReader.readLine()) != null)
            {
                String info[] = line.split(" ");
                lList.get(i).setText(info[1]);
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
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
    private void form()
    {
        b2.setDisable(true);

        TranslateTransition t1 = new TranslateTransition();
        t1.setNode(p);
        t1.setDuration(Duration.millis(800));
        t1.setByX(635);
        t1.play();

        FadeTransition f1 = new FadeTransition();
        f1.setNode(p);
        f1.setDuration(Duration.millis(800));
        f1.setFromValue(0);
        f1.setToValue(1);
        f1.play();

        TranslateTransition t = new TranslateTransition();
        t.setNode(p3);
        t.setDuration(Duration.millis(800));
        t.setByY(385);
        t.play();

        FadeTransition f = new FadeTransition();
        f.setNode(p3);
        f.setDuration(Duration.millis(800));
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
    }

    @FXML
    private void home()
    {
//        p.setLayoutX(164);
//        p.setLayoutY(88);
//
//        p3.setLayoutX(295);
//        p3.setLayoutY(-280);
//
//        b2.setDisable(false);
    }

    @FXML
    private void donor(ActionEvent e) throws IOException
    {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Donor.fxml"));
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 400, 500);
        window.setTitle("E-Hospital Service");
        //Image icon = new Image("C:\\Users\\USER\\Downloads\\Project K\\E-Health-Service\\src\\main\\resources\\com\\example\\project\\create-a-formal-logo-for-e-hospital-service-removebg-preview.png");
        //window.getIcons().add(icon);

        window.setScene(scene);
        window.show();
    }

    @FXML
    private void submit(ActionEvent e) throws IOException
    {
        if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0 || t4.getText().length()==0 || T.getText().length()==0)
        {
            if(t1.getText().length()==0) { t1.setStyle("-fx-border-color: Red");}
            if(t1.getText().length()!=0) { t1.setStyle("-fx-border-color: White");}

            if(t2.getText().length()==0) { t2.setStyle("-fx-border-color: Red");}
            if(t2.getText().length()!=0) { t2.setStyle("-fx-border-color: White");}

            if(t3.getText().length()==0) { t3.setStyle("-fx-border-color: Red");}
            if(t3.getText().length()!=0) { t3.setStyle("-fx-border-color: White");}

            if(t4.getText().length()==0) { t4.setStyle("-fx-border-color: Red");}
            if(t4.getText().length()!=0) { t4.setStyle("-fx-border-color: White");}

            if(T.getText().length()==0) { T.setStyle("-fx-border-color: Red");}
            if(T.getText().length()!=0) { T.setStyle("-fx-border-color: White");}
        }
        else
        {
            list.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText()+" "+T.getText());
            hospitalMsgList.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText()+" "+T.getText());

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
            //String line;

//            BufferedReader reader = new BufferedReader(new FileReader(pathList.get(i)));
//            while((line = reader.readLine()) != null)
//            {
//                List.add(line);
//            }

            List.add(t1.getText()+" "+t2.getText()+" "+t3.getText()+" "+t4.getText()+" "+T.getText());
            this.write(pathList.get(i), List);
//            BufferedWriter writer = new BufferedWriter(new FileWriter(pathList.get(i)));
//
//            for(int j=0; j<List.size(); j++)
//            {
//                writer.write(List.get(j)+"\n");
//            }
//            writer.close();
        }
    }

    private void read(String path, ArrayList<String > list)
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

    private void write(String path, ArrayList<String > list)
    {
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
