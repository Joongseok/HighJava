package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// GridPane ==> 표(table) 형태의 좌표 체계를 이용하여 객체를 배치한다.
		
		GridPane grid =  new GridPane();
		grid.setPrefSize(300, 200);
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(20);
		
		Label lblId = new Label("아 이 디 : "); 
		Label lblPass = new Label("패스워드 : ");
		
		TextField tfId = new TextField();
		PasswordField pfPass = new PasswordField();
		
		Button btnLogin = new Button("로그인");
		Button btnCancel = new Button("취 소 ");
		
		// GridPane에 객체 추가하기 
		// 형식) grid.add(추가할 객체, 칸번호, 행번호, colspan, rowspan)
		grid.add(lblId, 1, 1, 2, 1);
		grid.add(lblPass, 1, 2, 2, 1);
		grid.add(tfId, 3, 1, 3, 1);
		grid.add(pfPass, 3, 2, 3, 1);
		grid.add(btnLogin, 3, 4);
		grid.add(btnCancel, 5, 4);
		
		// 컨테이너객체 및 컨트롤객체에 Style을 적용하는 방법
		// 형식) 객체변수.setStyle("-fx-스타일속성명1:값1;....");
		grid.setStyle("-fx-background-color:yellow;");
		tfId.setStyle("-fx-background-color:green; -fx-text-fill:red;");
		
		Scene scene = new Scene(grid);
		primaryStage.setTitle("GridPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
