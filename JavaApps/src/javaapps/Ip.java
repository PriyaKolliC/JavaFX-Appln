package javaapps;

import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Ip extends Application{
    
    @Override
    public void start(Stage primaryStage) {
        
        }

    public static void main(String[] args) {
    //    launch(args);
    Ip();
    }
    private static void Ip()
    {
        Label one=new Label("Know the Ip Address!!!");
        Label two=new Label("For example: www.google.com");
        one.setLayoutX(20);
        one.setLayoutY(40);
        two.setLayoutX(20);
        two.setLayoutY(55);
        
        
        Label la=new Label("Enter Url");
        la.setLayoutX(20);
        la.setLayoutY(120);
        TextField tf=new TextField();
        Label ip=new Label("");
        ip.setLayoutX(80);
        ip.setLayoutY(175);
        tf.setLayoutX(80);
        tf.setLayoutY(120);
        
        Button bt=new Button("Find Ip");
        bt.setLayoutX(250);
        bt.setLayoutY(120);
        Stage primaryStage=new Stage();
        Pane root = new Pane();
        root.getChildren().addAll(la,tf,bt,ip,one,two);
        Scene scene = new Scene(root, 400, 350);
        primaryStage.setTitle("Ip address");
        primaryStage.setScene(scene);
        primaryStage.show();
    bt.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        String url=tf.getText();  
    try {  
        InetAddress ia=InetAddress.getByName(url);  
        String ipa=ia.getHostAddress();  
        ip.setText("The Ip Address of given URL is "+ipa);        
    } catch (UnknownHostException e1) {  
        ip.setText("Enter Valid URL");
    }
        
        
    }
});
    }
}
