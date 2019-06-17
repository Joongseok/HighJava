package basic.animation;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane login;
    @FXML
    private Button btnMain;

    @FXML
    void initialize() {
    	
    	assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnMain != null : "fx:id=\"btnMain\" was not injected: check your FXML file 'Login.fxml'.";

        // 로그인 화면에서
        btnMain.setOnAction( e-> {
        	
        	try {
				
        		StackPane root = (StackPane) btnMain.getScene().getRoot();
        		
        		//root.getChildren().remove(login);
			/*
				 login.setTranslateX(0); // 시작 값
				 
				 KeyValue keyValue = new KeyValue(login.translateXProperty(), 350);
			 */	
        		
        		login.setOpacity(1); // 투명
        		KeyValue keyValue = new KeyValue(login.opacityProperty(), 0);
        		
        		login.setRotate(0); // 회전
        		KeyValue keyValue2 = new KeyValue(login.rotateProperty(), 180);
        		
        		login.setScaleX(1); // 확대
        		KeyValue keyValue3 = new KeyValue(login.scaleXProperty(), 0);
        		login.setScaleY(1);
        		KeyValue keyValue4 = new KeyValue(login.scaleYProperty(), 0);
        		
        		
        		
        		KeyFrame keyFrame = new KeyFrame(
        				Duration.millis(800),
        				new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								// 애니메이션이 끝난 다음에 처리할 내용을 기술한다.
								root.getChildren().remove(login);
							}
						},
        				keyValue,keyValue2,keyValue3, keyValue4);
        		
        		Timeline timeline = new Timeline();
        		
        		timeline.getKeyFrames().add(keyFrame);
        		
        		timeline.play();
        		
        		
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        	
        });
        
        
    }
}
