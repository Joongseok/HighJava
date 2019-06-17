package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class examPane extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
		HBox hbox = new HBox();
		
		TextField tf = new TextField();
		tf.setPrefHeight(45);
		
		grid.setPadding(new Insets(10));
		root.setPrefSize(510, 300);
		hbox.setSpacing(2);
		grid.setHgap(5);
		grid.setVgap(5);
		
		RadioButton radio = new RadioButton("Degrees");
		RadioButton radio1 = new RadioButton("Radians");
		RadioButton radio2 = new RadioButton("Grads");
		
		hbox.getChildren().addAll(radio,radio1,radio2);
//		grid.setPrefSize(prefWidth, prefHeight);
		
		//====================================== 첫번째 줄
		Button btn1 = new Button("");
		Button btn4 = new Button("MC");
		Button btn5 = new Button("MR");
		Button btn6 = new Button("Ms");
		Button btn7 = new Button("M+");
		Button btn8 = new Button("M-");
		//====================================== 두번째 줄
		Button btn9 = new Button("");
		Button btn10 = new Button("Inv");
		Button btn11 = new Button("In");
		Button btn12 = new Button("(");
		Button btn13 = new Button(")");
		Button btn14 = new Button("<=");
		Button btn15 = new Button("CE");
		Button btn16 = new Button("C");
		Button btn17 = new Button("±");
		Button btn18 = new Button("√");
		//====================================== 세번째 줄
		Button btn19 = new Button("Int");
		Button btn20 = new Button("sinh");
		Button btn21 = new Button("sin");
		Button btn22 = new Button("x²");
		Button btn23 = new Button("n!");
		Button btn24 = new Button("7");
		Button btn25 = new Button("8");
		Button btn26 = new Button("9");
		Button btn27 = new Button("/");
		Button btn28 = new Button("%");
		//====================================== 네번째 줄
		Button btn29 = new Button("dms");
		Button btn30 = new Button("cosh");
		Button btn31 = new Button("cos");
		Button btn32 = new Button("xⁿ");
		Button btn33 = new Button("y√x");
		Button btn34 = new Button("4");
		Button btn35 = new Button("5");
		Button btn36 = new Button("6");
		Button btn37 = new Button("*");
		Button btn38 = new Button("1/x");
		//====================================== 다섯번째 줄
		Button btn39 = new Button("π");
		Button btn40 = new Button("tanh");
		Button btn41 = new Button("tan");
		Button btn42 = new Button("x³");
		Button btn43 = new Button("√x");
		Button btn44 = new Button("1");
		Button btn45 = new Button("2");
		Button btn46 = new Button("3");
		Button btn47 = new Button("-");
		Button btn48 = new Button("=");
		Button btn49 = new Button("F-E");
		Button btn50 = new Button("Exp");
		Button btn51 = new Button("Mod");
		Button btn52 = new Button("log");
		Button btn53 = new Button("10x");
		Button btn54 = new Button("0");
		Button btn55 = new Button(".");
		Button btn56 = new Button("+");
		
		//====================================== 첫번째 줄
		grid.add(hbox, 0, 0,5,1);
		grid.add(btn4, 5, 0);
		grid.add(btn5, 6, 0);
		grid.add(btn6, 7, 0);
		grid.add(btn7, 8, 0);
		grid.add(btn8, 9, 0);
		grid.add(btn9, 0, 1);
		//====================================== 두번째 줄
		grid.add(btn10, 1, 1);
		grid.add(btn11, 2, 1);
		grid.add(btn12, 3, 1);
		grid.add(btn13, 4, 1);
		grid.add(btn14, 5, 1);
		grid.add(btn15, 6, 1);
		grid.add(btn16, 7, 1);
		grid.add(btn17, 8, 1);
		grid.add(btn18, 9, 1);
		//====================================== 세번째 줄
		grid.add(btn19, 0, 2);
		grid.add(btn20, 1, 2);
		grid.add(btn21, 2, 2);
		grid.add(btn22, 3, 2);
		grid.add(btn23, 4, 2);
		grid.add(btn24, 5, 2);
		grid.add(btn25, 6, 2);
		grid.add(btn26, 7, 2);
		grid.add(btn27, 8, 2);
		grid.add(btn28, 9, 2);
		//====================================== 네번째 줄
		grid.add(btn29, 0, 3);
		grid.add(btn30, 1, 3);
		grid.add(btn31, 2, 3);
		grid.add(btn32, 3, 3);
		grid.add(btn33, 4, 3);
		grid.add(btn34, 5, 3);
		grid.add(btn35, 6, 3);
		grid.add(btn36, 7, 3);
		grid.add(btn37, 8, 3);
		grid.add(btn38, 9, 3);
		//====================================== 다섯번째 줄
		grid.add(btn39, 0, 4);
		grid.add(btn40, 1, 4);
		grid.add(btn41, 2, 4);
		grid.add(btn42, 3, 4);
		grid.add(btn43, 4, 4);
		grid.add(btn44, 5, 4);
		grid.add(btn45, 6, 4);
		grid.add(btn46, 7, 4);
		grid.add(btn47, 8, 4);
		grid.add(btn48, 9, 4,1,2);
		grid.add(btn49, 0, 5);
		grid.add(btn50, 1, 5);
		grid.add(btn51, 2, 5);
		grid.add(btn52, 3, 5);
		grid.add(btn53, 4, 5);
		grid.add(btn54, 5, 5,2,1);
		grid.add(btn55, 7, 5);
		grid.add(btn56, 8, 5);
		
		//====================================== 첫번째 줄
		radio.setPrefSize(80, 30);
		radio1.setPrefSize(80, 30);
		radio2.setPrefSize(80, 30);
		btn1.setPrefSize(240, 30); 
		btn4.setPrefSize(45, 30); 
		btn5.setPrefSize(45, 30); 
		btn6.setPrefSize(45, 30); 
		btn7.setPrefSize(45, 30); 
		btn8.setPrefSize(45, 30); 
		btn9.setPrefSize(45, 30); 
		//====================================== 두번째 줄
		btn10.setPrefSize(45, 30); 
		btn11.setPrefSize(45, 30); 
		btn12.setPrefSize(45, 30); 
		btn13.setPrefSize(45, 30); 
		btn14.setPrefSize(45, 30); 
		btn15.setPrefSize(45, 30); 
		btn16.setPrefSize(45, 30); 
		btn17.setPrefSize(45, 30); 
		btn18.setPrefSize(45, 30); 
		//====================================== 세번째 줄
		btn19.setPrefSize(45, 30); 
		btn20.setPrefSize(45, 30); 
		btn21.setPrefSize(45, 30); 
		btn22.setPrefSize(45, 30); 
		btn23.setPrefSize(45, 30); 
		btn24.setPrefSize(45, 30); 
		btn25.setPrefSize(45, 30); 
		btn26.setPrefSize(45, 30); 
		btn27.setPrefSize(45, 30); 
		btn28.setPrefSize(45, 30); 
		//====================================== 네번째 줄
		btn29.setPrefSize(45, 30); 
		btn33.setPrefSize(45, 30); 
		btn31.setPrefSize(45, 30); 
		btn32.setPrefSize(45, 30); 
		btn33.setPrefSize(45, 30); 
		btn34.setPrefSize(45, 30); 
		btn35.setPrefSize(45, 30); 
		btn36.setPrefSize(45, 30); 
		btn37.setPrefSize(45, 30); 
		btn38.setPrefSize(45, 30); 
		//====================================== 다섯번째 줄
		btn39.setPrefSize(45, 30); 
		btn40.setPrefSize(45, 30); 
		btn41.setPrefSize(45, 30); 
		btn42.setPrefSize(45, 30); 
		btn43.setPrefSize(45, 30); 
		btn44.setPrefSize(45, 30); 
		btn45.setPrefSize(45, 30); 
		btn46.setPrefSize(45, 30); 
		btn47.setPrefSize(45, 30); 
		btn48.setPrefSize(45, 70); 
		btn49.setPrefSize(45, 30); 
		btn50.setPrefSize(45, 30); 
		btn51.setPrefSize(45, 30); 
		btn52.setPrefSize(45, 30); 
		btn53.setPrefSize(45, 30); 
		btn54.setPrefSize(100, 30); 
		btn55.setPrefSize(45, 30); 
		btn56.setPrefSize(45, 30); 
		
		
		root.setTop(tf);
		root.setCenter(grid);
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("계산기");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
