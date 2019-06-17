package basic.animation;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnimationMain extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Animation 연습");
			primaryStage.setScene(scene);
			primaryStage.setWidth(350);
			primaryStage.setHeight(500);
			primaryStage.setResizable(false); 	// 윈도우의 크기 조절 불가
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
