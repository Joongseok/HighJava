package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StackPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();
		
		// StackPane은 객체를 한 곳에 계속 쌓는 형식으로 배치한다.
		
		StackPane stack = new StackPane(); // StackPane객체 생성
		
		ImageView imgView = new ImageView(); // 이미지를 보여주는 ImageView객체 생성
		
		// 화면에 나타날 Image객체 생성
		Image img = new Image(getClass().getResourceAsStream("../images/test.jpg")); 
		
		imgView.setImage(img); // ImageView에 Image객체 넣기
		
		Button btnTest = new Button("연 습 용 버 튼");
		
		// StackPane에 이미지뷰와 버튼 배치
		stack.getChildren().addAll(imgView,btnTest);
		
		root.getChildren().add(stack);
		root.setPadding(new Insets(15));
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 400, 300);
		
		primaryStage.setTitle("StackPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
