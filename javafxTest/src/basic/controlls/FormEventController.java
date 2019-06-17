package basic.controlls;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import util.AlertUtil;

public class FormEventController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfMsg;

    @FXML
    private RadioButton man;

    @FXML
    private ToggleGroup gend;

    @FXML
    private RadioButton woman;

    @FXML
    private CheckBox trip;

    @FXML
    private CheckBox read;

    @FXML
    private CheckBox movie;

    @FXML
    private CheckBox baduk;

    @FXML
    private CheckBox janggi;

    @FXML
    private CheckBox travle;

    @FXML
    private CheckBox fish;

    @FXML
    private Button btn;

    @FXML
    private TextArea txtArea;

    @FXML
    void btnClick(ActionEvent event) {
    	
    	String name = tfMsg.getText();
    	if (name.isEmpty()) {
			//txtArea.setText("이름을 입력하세요");
//			Alert warning =  new Alert(AlertType.WARNING);
//			warning.setTitle("경고창");
//			warning.setHeaderText("입력값 누락");
//			warning.setContentText("이름을 입력하세요");
//			warning.showAndWait();
    		AlertUtil.warning("<<경고창>>", "<<입력값 누락...>>", "이름을 입력하세요");
			tfMsg.requestFocus();
			return;
		}
    	
    	String sung = "";
    	if (man.isSelected()) {
			sung = "남자";
		}else {
			sung = "여자";
		}
    	
    	String hobbys = "";
    	for (int i = 0; i < checks.length; i++) {
    		if (checks[i].isSelected()) {
    			if (!hobbys.equals("")) {
					hobbys += ", ";
				}
				hobbys += checks[i].getText() ;
			}
		}
    	
    	txtArea.setText(name + "씨!\n");
    	txtArea.appendText("당신은 " + sung + "이고,\n");
    	txtArea.appendText("취미는 " + ( hobbys.equals("") ? "없군요" : hobbys + "이군요.\n"));
    	
    }
    
    CheckBox[] checks;

    @FXML
    void initialize() {
        assert tfMsg != null : "fx:id=\"tfMsg\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert man != null : "fx:id=\"man\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert gend != null : "fx:id=\"gend\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert woman != null : "fx:id=\"woman\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert trip != null : "fx:id=\"trip\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert read != null : "fx:id=\"read\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert movie != null : "fx:id=\"movie\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert baduk != null : "fx:id=\"baduk\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert janggi != null : "fx:id=\"janggi\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert travle != null : "fx:id=\"travle\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert fish != null : "fx:id=\"fish\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'FormEvent.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'FormEvent.fxml'.";

        checks = new CheckBox[] {trip,read,movie,baduk,janggi,travle,fish};
    }
}
