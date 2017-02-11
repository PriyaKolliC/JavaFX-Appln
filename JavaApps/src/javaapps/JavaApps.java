package javaapps;

import java.awt.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 *
 * @author Personal
 */
public class JavaApps extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button ntpd_btn = new Button();
        ntpd_btn.setLayoutX(10);
        ntpd_btn.setLayoutY(80);
        Label l=new Label("JavaFX Guide for beginners");
        l.setLayoutX(140);
        l.setLayoutY(20);
        Image image_ntpd=new Image(getClass().getResourceAsStream("/images/note.jpg"));
        ImageView iv_ntpd = new ImageView(image_ntpd);
	iv_ntpd.setFitWidth(110);
	iv_ntpd.setFitHeight(110); 
        ntpd_btn.setGraphic(iv_ntpd);
        ntpd_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Notepad.main(new String[]{});
            }
        });
        Label ntpd=new Label("Write Notes");
        ntpd.setLayoutX(10);
        ntpd.setLayoutY(210);
        Label quiz=new Label("Take a Quiz");
        Label ip_lbl=new Label("Find Ip");
        
        
        Button ip_btn = new Button();
        ip_btn.setLayoutX(310);
        ip_btn.setLayoutY(80); 
        Image image_ip=new Image(getClass().getResourceAsStream("/images/ip.jpg"));
        ImageView iv_ip = new ImageView(image_ip);
	iv_ip.setFitWidth(110);
	iv_ip.setFitHeight(110); 
        ip_btn.setGraphic(iv_ip);
        ip_lbl.setLayoutX(310);
        ip_lbl.setLayoutY(210);
       
       ip_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Ip.main(new String[]{});
            }
        });

        Button quiz_btn = new Button();
        quiz_btn.setLayoutX(160);
        quiz_btn.setLayoutY(80); 
        Image image_quiz=new Image(getClass().getResourceAsStream("/images/quiz.png"));
        ImageView iv_quiz = new ImageView(image_quiz);
	iv_quiz.setFitWidth(110);
	iv_quiz.setFitHeight(110); 
        quiz_btn.setGraphic(iv_quiz);
        quiz.setLayoutX(160);
        quiz.setLayoutY(210);
       quiz_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Quiz.main(new String[]{});
            }
        });

                
        
        Pane mainpane = new Pane();
        mainpane.getChildren().add(ntpd_btn);
        mainpane.getChildren().add(ip_btn);
        mainpane.getChildren().add(quiz_btn);
        mainpane.getChildren().addAll(l,ntpd,quiz,ip_lbl);
         Scene scene = new Scene(mainpane, 500, 350);
        primaryStage.setTitle("JavaWorld");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
