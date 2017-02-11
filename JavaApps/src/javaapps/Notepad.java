package javaapps;

import com.sun.glass.ui.Window.Level;
import com.sun.media.jfxmedia.logging.Logger;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import static javaapps.Quiz.count;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.JMenu;


public class Notepad extends Application {
    static Notepad npd;
          static FileChooser chooser=new FileChooser();
    static boolean opened_file=false;
    static boolean saved_file=false;
    static String file_name;
        static String file_path;
    @Override
    public void start(Stage primaryStage) {
        //Notepad();
        }
    public static void main(String[] args) {
        //launch(args);
        Notepad();
    }
public static void Notepad()
{
     Pane nt_root=new Pane();              
           Stage primaryStage=new Stage();
           File file;
     
     MenuBar mb = new MenuBar();
    mb.setLayoutX(10);
    mb.setLayoutY(10);
    Menu menuFile = new Menu("File");
        mb.getMenus().addAll(menuFile);
         MenuItem new_page = new MenuItem("New");
         MenuItem open = new MenuItem("Open");
         MenuItem save = new MenuItem("Save");
         MenuItem saveas = new MenuItem("Save As");
         MenuItem close = new MenuItem("Close");
         menuFile.getItems().addAll(new_page,open,save,saveas,close);
         
    TextArea ta=new TextArea();
    ta.setLayoutX(10);
    ta.setLayoutY(33);
    ta.setPrefWidth(480);
    ta.setPrefHeight(310);
        nt_root.getChildren().addAll(mb);
        nt_root.getChildren().add(ta);
        Scene scene = new Scene(nt_root, 500, 350);
        primaryStage.setTitle("Notepad");
        primaryStage.setScene(scene);
        primaryStage.show();
     primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent t) {
    if(opened_file==true)
    {
            String content=ta.getText();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setContentText("Do you want to save changes?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
            try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file_path);
            fileWriter.write(content);
            fileWriter.close();
            }
            catch (IOException ex) {
            }
            primaryStage.close();
            }
            else {
            
            }
        }
    else
    {
        File file;
        Stage stage = (Stage) nt_root.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
              fileChooser.getExtensionFilters().add(extFilter);
              file = fileChooser.showSaveDialog(stage);
                       if(file != null){
                 SaveFile(ta.getText(), file);
              }
    }
    }
});   
    new_page.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        new_page(nt_root,ta);
 
    }
});
    close.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
    close(nt_root);    
    }
});
    save.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        save(nt_root,ta);
    }
});
    saveas.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        saveas(nt_root,ta);
    }
});
    open.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        open(nt_root,ta);
    }
});
}    
public static void new_page(Pane pane,TextArea ta)
{
    Stage stage = (Stage) pane.getScene().getWindow();
    stage.setTitle("Untitled - Notepad");  
    ta.setText("");
}
public static void close(Pane pane)
{
    Stage stage = (Stage) pane.getScene().getWindow();
    stage.close();
}
public static void saveas(Pane pane,TextArea tax)
{
    File file;
        Stage stage = (Stage) pane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
              fileChooser.getExtensionFilters().add(extFilter);
              file = fileChooser.showSaveDialog(stage);
                       if(file != null){
                 SaveFile(tax.getText(), file);
              }
}
public static void save(Pane pane,TextArea tax)
{
    if(opened_file==true)
    {
        String content=tax.getText();
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file_path);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            }
    }
    else
    {
        File file;
        Stage stage = (Stage) pane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
              fileChooser.getExtensionFilters().add(extFilter);
              file = fileChooser.showSaveDialog(stage);
                       if(file != null){
                 SaveFile(tax.getText(), file);
              }
    }
}
public static void open(Pane pane,TextArea ta)
{
        Stage stage = (Stage) pane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(stage);
                file_name=file.getName();
                file_path=file.getPath();
                if(file != null){
                    ta.setText(readFile(file));
                    opened_file=true;
                }
}
private static void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            }
          
    }
private static String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text+"\n");
            }
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
            //    Logger.getLogger(JavaFX_OpenFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return stringBuffer.toString();
    }
}
