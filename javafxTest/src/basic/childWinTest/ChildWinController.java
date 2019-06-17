package basic.childWinTest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChildWinController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAddr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCancle;

    
    // MainWin창의 '데이터 추가' 버튼 클륵 이벤트 처리
    @FXML
    void btnAddClicked(ActionEvent event) {
    	
    	
    	
    }

    @FXML
    void btnCancleClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert tfId != null : "fx:id=\"tfId\" was not injected: check your FXML file 'ChildWin.fxml'.";
        assert tfName != null : "fx:id=\"tfName\" was not injected: check your FXML file 'ChildWin.fxml'.";
        assert tfAddr != null : "fx:id=\"tfAddr\" was not injected: check your FXML file 'ChildWin.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'ChildWin.fxml'.";
        assert btnCancle != null : "fx:id=\"btnCancle\" was not injected: check your FXML file 'ChildWin.fxml'.";

    }
}
