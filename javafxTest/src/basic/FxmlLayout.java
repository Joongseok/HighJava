package basic;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxmlLayout extends Application {

	@Override
	public void start (Stage primaryStage)throws IOException  {
		// fxml파일을 읽어와 현재의 Stage에 적용하는 방법
		
		// Fxml문서를 읽어오는 방법1
//		VBox root = FXMLLoader.load(getClass().getResource("../application/FxmlLayout.fxml")); // 다른패키지에 존재할때
//		VBox root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml")); // 현재 패키지에 있을때
//		Parent root = FXMLLoader.load(getClass().getResource("FxmlLayout.fxml"));
		//VBox root = FXMLLoader.load(FxmlLayout.class.getResource("FxmlLayout.fxml"));
		
		// Fxml문서를 읽어오는 방법2
		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlLayout.fxml"));
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Fxml문서를 이용한 레이아웃");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
