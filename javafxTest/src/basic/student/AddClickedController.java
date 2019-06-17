package basic.student;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import basic.controlls.TableViewTest.Member;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.AlertUtil;

public class AddClickedController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfGuk;

    @FXML
    private TextField tfSu;

    @FXML
    private TextField tfEng;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancle;

    @FXML
    void btnAddClicked(ActionEvent event) {
    	
    	if (tfName.getText().isEmpty() || tfGuk.getText().isEmpty() ||
    			tfSu.getText().isEmpty() || tfEng.getText().isEmpty()) {
    		AlertUtil.warning("경고", "입력오류", "누락된 데이터가 있습니다.");
			return;
		}
    	
    	List<StudentVO> stdList = new ArrayList<StudentVO>();
    	
    	stdList.add(new StudentVO(tfName.getText(), Integer.parseInt(tfGuk.getText()),
    			Integer.parseInt(tfSu.getText()), Integer.parseInt(tfEng.getText())));
    	
    	StudentVO std = new StudentVO();
    	std.setStuname(tfName.getText());
    	std.setGuk(Integer.parseInt(tfGuk.getText()));
    	std.setSu(Integer.parseInt(tfSu.getText()));
    	std.setEng( Integer.parseInt(tfEng.getText()));
    	
    	StudentMainController.dataList.add(std);
    	
    	AlertUtil.warning("확인", "작업성공", tfName.getText()+"씨의 정보가 추가되었습니다.");
    	
    }

    @FXML
    void btnCancleClicked(ActionEvent event) {
    	StudentMainController.addStage.close();
    }

    @FXML
    void initialize() {
    	
    	
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'AddClicked.fxml'.";
        assert tfGuk != null : "fx:id=\"tfGuk\" was not injected: check your FXML file 'AddClicked.fxml'.";
        assert tfSu != null : "fx:id=\"tfSu\" was not injected: check your FXML file 'AddClicked.fxml'.";
        assert tfEng != null : "fx:id=\"tfEng\" was not injected: check your FXML file 'AddClicked.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'AddClicked.fxml'.";
        assert btnCancle != null : "fx:id=\"btnCancle\" was not injected: check your FXML file 'AddClicked.fxml'.";

        
        
    }
}
