package basic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 200);
		
		ToolBar toolbar = new ToolBar(
			new Button("첫번째"), 
			new Button("두번째")
		);
		
		TextArea taMsg = new TextArea();
		
		BorderPane bottom = new BorderPane();
		TextField tfTest = new TextField();
		Button btn1 = new Button("확인");
		bottom.setCenter(tfTest);
		bottom.setRight(btn1);
		
		root.setTop(toolbar);
		root.setCenter(taMsg);
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("BorderPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
