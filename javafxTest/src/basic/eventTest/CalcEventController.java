package basic.eventTest;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CalcEventController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfMsg;

    @FXML
    private Button btn;

    @FXML
    private TextArea txtArea;

    @FXML
    void btnClick(ActionEvent event) {
    	txtArea.clear();
    	tfMsg.requestFocus();
    	String txtDan = tfMsg.getText();
    	
    	if (txtDan.isEmpty()) {
    		txtArea.setText("출력할 단을 입력하세요.");
    		tfMsg.requestFocus(); // 단을 입력할 TextField에 포커스 추가
    		return;
    	}
    	
    	// 입력한 값이 정수인지 여부 검사 (정규식으로 검사)
    	if (!Pattern.matches("^[0-9]+$", txtDan)) {
			txtArea.setText("숫자를 입력하세요.");
			//tfMsg.setText(""); // 내용지우기1
			tfMsg.clear(); // 내용지우기2
			tfMsg.requestFocus();
			return;
		}
    	
    	int dan =Integer.parseInt(txtDan);
    	txtArea.setText("\t\t" + dan +"단 \n\n");
    	for (int i = 1; i <10; i++) {
			txtArea.appendText("\t\t"+dan + "*" + i + "=" +dan*i +"\n" );
		}
    	
    }

    @FXML
    void initialize() {
        assert tfMsg != null : "fx:id=\"tfMsg\" was not injected: check your FXML file 'CalcEvent.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'CalcEvent.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'CalcEvent.fxml'.";

    }
}
