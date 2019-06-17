package basic.student;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;

public class BarChartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> bc;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button btnClose;

    @FXML
    void btnCloseClicked(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
    	
    	bc = new BarChart<String, Number>(xAxis, yAxis);
    	
        assert bc != null : "fx:id=\"bc\" was not injected: check your FXML file 'BarChart.fxml'.";
        assert xAxis != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'BarChart.fxml'.";
        assert yAxis != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'BarChart.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'BarChart.fxml'.";

    }
}
