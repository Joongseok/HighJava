package basic.alertTest;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		/*
		Alert alertInfo = new Alert(AlertType.INFORMATION);
		
		alertInfo.setTitle("Information창");
		alertInfo.setHeaderText("Information의 Header영역");
		alertInfo.setContentText("Information Alert창입니다.");
		
		//alertInfo.show();
		
		alertInfo.showAndWait();
		
		//--------------------------------------------
		
		Alert alertError = new Alert(AlertType.ERROR);
		alertError.setTitle("Error창");
		alertError.setHeaderText("Error의 Header영역");
		alertError.setContentText("오류 발생 메세지를 나타낸다. ");
		
		alertError.showAndWait();
		
		System.out.println("show 이후의 처리 내용들...");
		
		Alert alertWarning = new Alert(AlertType.WARNING);
		alertWarning.setTitle("경고창");
		alertWarning.setHeaderText("경고창의 Header영역");
		alertWarning.setContentText("경고메세지를 출력한다.");
		
		alertWarning.showAndWait();
		/-------------------------------------------
		
		
		 */
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertConfirm.setTitle("Confirmation창");
		alertConfirm.setHeaderText("둘 중 하나를 선택하게 하는 창");
		alertConfirm.setContentText("Confirm창의 메세지 출력");
		
		// Alert창을 보여주고 사용자가 누른 버튼 종류를 읽어온다.
		
		ButtonType confirmResult = alertConfirm.showAndWait().get();
		if (confirmResult == ButtonType.OK) {	// OK버튼을 누른 경우
			System.out.println("OK버튼을 눌렀습니다.");
		}else if(confirmResult == ButtonType.CANCEL) {
			System.out.println("취소버튼을 눌렀습니다.");
		}else {
			System.out.println(".....");
		}
		//----------------------------------
		
		// 자바스크립트의 prompt창과 같은 기능
		TextInputDialog prompt = new TextInputDialog("기본값"); // '기본값'은 생략 가능
		prompt.setTitle("prompt창의 title");
		prompt.setHeaderText("prompt창의 Header영역");
		prompt.setContentText("입력 : ");
		
		// 입력한 값 읽어오기
		Optional<String> result = prompt.showAndWait();
		
//		result.ifPresent(str ->{
//			System.out.println("=> " + str + " <==");
//		});
		
		String strTemp = "undefined";
		if (result.isPresent()) { // 입력한 값이 있으면
			strTemp = result.get(); //값 가져오기
		}
		System.out.println("입력값 strTemp =>" + strTemp);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
