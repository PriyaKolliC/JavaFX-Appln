package javaapps;

import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;

public class Quiz extends Application {
        static ToggleGroup group = new ToggleGroup();
        static Label l=new Label();
	static RadioButton jb[]=new RadioButton[5];
	static Button b1,b2;
	static ButtonGroup bg=new ButtonGroup();
	static int count=0,current=0,x=1,y=1,now=0;
	static int m[]=new int[10];	
    
    @Override
    public void start(Stage primaryStage) {
        }

    public static void main(String[] args) {
        Quiz();
    }
    public static void Quiz()
    {
        Pane root = new Pane();
        Stage primaryStage=new Stage();
        Scene scene;
                for(int i=0;i<5;i++)
		{
                    jb[i]=new RadioButton();	
                        jb[i].setToggleGroup(group);
		}
		b1=new Button("Next");
		b2=new Button("Previous");
                l.setLayoutX(30);
                l.setLayoutY(40);
                l.minWidth(450);
                l.minHeight(20);
                
                jb[0].setLayoutX(50);
                jb[0].setLayoutY(80);
                jb[0].minWidth(100);
                jb[0].minHeight(20);
                jb[1].minWidth(100);
                jb[1].minHeight(20);
                jb[2].minWidth(100);
                jb[2].minHeight(20);
                jb[3].minWidth(100);
                jb[3].minHeight(20);
                jb[1].setLayoutX(50);
                jb[1].setLayoutY(110);
                jb[2].setLayoutX(50);
                jb[2].setLayoutY(140);
                jb[3].setLayoutX(50);
                jb[3].setLayoutY(170);
                
                b1.setLayoutX(100);b2.setLayoutX(270);
                b1.setLayoutY(240);b2.setLayoutY(240);
                b1.minWidth(100);b2.minWidth(100);
                b1.minHeight(30);b2.minHeight(30);
		set();
                b1.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
                        if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setDisable(true);   
				b2.setText("Result");
			}
 
    }
});
                b2.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        if(!b2.getText().equals("Result")){
        		if(current>0)
                        {
			current--;
			set();	
			if(current==9)
                        {
                            b2.setDisable(true);
                            b1.setText("Result");
                        }
                        }
                        else
                        {
                        }
        }
        else
        {
                        if(check())
				count=count+1;
			current++;
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Result");
                        alert.setHeaderText("Here's Your Result");
                        alert.setContentText("Correct Answers: "+count);
                        alert.showAndWait();
                        current=0;
                        count=0;
                        primaryStage.close();
        }
}
});          
        root.getChildren().addAll(l,jb[0],jb[1],jb[2],jb[3],b1,b2);
        scene = new Scene(root, 500, 450);
        primaryStage.setTitle("Java Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Which one among these is not a primitive datatype?");
			jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");	
		}
		if(current==1)
		{
			l.setText("Que2: Which class is the parent class of all classes in java?");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
		}
		if(current==2)
		{
			l.setText("Que3: Which package is directly available to our classes?");
			jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in ___ package.");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Que5: Modulus operator, %, can be applied to which of these?");
			jb[0].setText("Integers");jb[1].setText("Floating point numbers");jb[2].setText("Both");jb[3].setText("None");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword?");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which one among these is not a class?");
			jb[0].setText("Applet");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
		}
		if(current==7)
		{
			l.setText("Que8: Which among these is not a function of Object class?");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que9: Which function is not found in Applet class?");
			jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not a valid component?");
			jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
		}
                l.setLayoutX(30);
                l.setLayoutY(40);
                l.minHeight(20);
                l.minWidth(450);
		for(int i=0,j=0;i<=90;i+=30,j++)
                {
                    jb[j].setLayoutX(50);
                    jb[j].setLayoutY(80+i);
                    jb[j].minWidth(200);
                    jb[j].minHeight(20);
                }
	}
	public static boolean check()
        {
                if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[3].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
        }
}
