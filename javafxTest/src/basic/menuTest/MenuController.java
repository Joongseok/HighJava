package basic.menuTest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane root;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu fileMenu;

    @FXML
    private MenuItem newFileMenuItem;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    private MenuItem changeNameSaveMenuItem;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private TextArea txtArea;

    @FXML
    void changeNameSaveAction(ActionEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) {

    }

    @FXML
    void newFIleAction(ActionEvent event) {

    }

    @FXML
    void openMenuAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'Menu.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'Menu.fxml'.";
        assert fileMenu != null : "fx:id=\"fileMenu\" was not injected: check your FXML file 'Menu.fxml'.";
        assert newFileMenuItem != null : "fx:id=\"newFileMenuItem\" was not injected: check your FXML file 'Menu.fxml'.";
        assert openMenuItem != null : "fx:id=\"openMenuItem\" was not injected: check your FXML file 'Menu.fxml'.";
        assert changeNameSaveMenuItem != null : "fx:id=\"changeNameSaveMenuItem\" was not injected: check your FXML file 'Menu.fxml'.";
        assert exitMenuItem != null : "fx:id=\"exitMenuItem\" was not injected: check your FXML file 'Menu.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Menu.fxml'.";

    }
}
