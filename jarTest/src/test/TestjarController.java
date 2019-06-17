package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.AnchorPane;

public class TestjarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchor;

    @FXML
    private ButtonBar btnBar;

    @FXML
    private Button btn;
    
    @FXML
    void initialize() {
        assert anchor != null : "fx:id=\"anchor\" was not injected: check your FXML file 'Testjar.fxml'.";
        assert btnBar != null : "fx:id=\"btnBar\" was not injected: check your FXML file 'Testjar.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Testjar.fxml'.";

    }
}
