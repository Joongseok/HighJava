package basic.childWinTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWin extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			// 이 방법으로는 Controller객체를 구할수 없다.
			//Parent root = FXMLLoader.load(getClass().getResource("MainWin.fxml"));
			
			//Fxml문서에 설정된 Controller객체 구하는 방법
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWin.fxml"));
			
			Parent root  = loader.load();
			
			// 위의 loader객체 변수를 이용하여 Controller객체를 구한다.
			MainWinController mainController = loader.getController();
			mainController.setMainStage(primaryStage); 	// 현재의 Stage정보를 Controller에게 전달한다.
			
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("ChildWin 연습");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
