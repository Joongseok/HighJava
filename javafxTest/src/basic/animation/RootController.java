package basic.animation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
  

    @FXML
    private Button btnLogin;

    @FXML
    void initialize() {
    	
        assert btnLogin != null : "fx:id=\"btnLogin\" was not injected: check your FXML file 'Root.fxml'.";

        btnLogin.setOnAction(e-> btnLoginClicked(e));
        	
        
        
    }
    
    
    // 메인 화면에서 Login버튼을 클릭했을 때.
    public void btnLoginClicked(ActionEvent e) {
    	
    	try {
    		Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
    		
    		
    		// 루트컨트롤러 구하기
    		// 형식 ) 현재화면에 있는 아무 컨트롤러객체.getScene().getRoot();
    		StackPane root = (StackPane) btnLogin.getScene().getRoot();
    		root.getChildren().add(login);
    		
    		// 이동 애니메이션
//    		login.setTranslateX(350); 	// x축으로 평행이동할 양 설정
    									// (애니메이션을 시작할 위치로 설정한다.)
    		
    		// KeyFrame에 설정된 내용대로 애니메이션을 진행시키는 객체
    		Timeline timeLine = new Timeline();
    		
		/*
    		
    		// 타겟속성과 종료값을 설정하는 객체 생성
    		// 형식 ) new KeyValue( 변경 될 대상 속성, 종료 값 )
    		KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
			
			
		*/
    		
    	
    		// Fade효과 (불투명도를 이용하고 값의 범위는 0.0(투명) ~ 1.0(불투명)
    		login.setOpacity(0); 	// 시작 불투명도 설정
    		KeyValue keyValue = new KeyValue(login.opacityProperty(), 1); 	// 최종 목적값
    		
    		
    		// 회전 효과
    		login.setRotate(180); 	// 회전 시작 각도
    		KeyValue keyValue2 = new KeyValue(login.rotateProperty(), 0); 	// 최종 목적값
    		
    		// 확대, 축소 효과
    		login.setScaleX(0); 	// 확대 축소 배율지정(값이 2이면 두배 크기라는 의미)
    		login.setScaleY(0); 	
    		KeyValue keyValue3 = new KeyValue(login.scaleXProperty(), 1);
    		KeyValue keyValue4 = new KeyValue(login.scaleYProperty(), 1);
    		
    		
    		// 애니메이션의 지속시간과 KeyValue를 설정하는 객체 ==> KeyFrame
    		// 형식1 ) new KeyFrame( 지속시간, keyValue객체 );
    		// 형식2 ) new KeyFrame( 지속시간, 애니메이션 종료 후 처리할 이벤트, KeyValue객체 );
    		//KeyFrame keyframe = new KeyFrame(Duration.millis(800), keyValue);
    		
    		KeyFrame keyframe = new KeyFrame(Duration.millis(800), keyValue, keyValue2, keyValue3, keyValue4);
    		
    		// Timeline에 KeyFrame 추가
    		timeLine.getKeyFrames().add(keyframe);
    		
    		// 애니메이션 실행
    		timeLine.play();
    		
		} catch (IOException e2) {
			e2.printStackTrace();
		}
    	
    }
    
}
