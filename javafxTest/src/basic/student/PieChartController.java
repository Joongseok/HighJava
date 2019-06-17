package basic.student;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;

public class PieChartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button btnClose;

    @FXML
    void btnCloseClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert pieChart != null : "fx:id=\"pieChart\" was not injected: check your FXML file 'PieChart.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'PieChart.fxml'.";

    }
}
