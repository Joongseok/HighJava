package board.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxBoardMain extends Application {
	static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		stg = primaryStage;
		try {
			Parent root = FXMLLoader.load(getClass().getResource("FxBoardMain.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("게시판관리");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
