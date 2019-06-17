package basic.student;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StudentMainController {
	
	private Stage mainStage;
	
	public void SetMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<StudentVO> table;

    @FXML
    private TableColumn<StudentVO, String> nameCol;

    @FXML
    private TableColumn<StudentVO, Integer> gukCol;

    @FXML
    private TableColumn<StudentVO, Integer> suCol;

    @FXML
    private TableColumn<StudentVO, Integer> engCol;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBarChart;

    static Stage addStage = new Stage(StageStyle.DECORATED);
    static Stage barChartStage = new Stage(StageStyle.DECORATED);
    
    
    @FXML
    void btnAddClicked(ActionEvent event) {
    	
		try {
			
			addStage.initModality(Modality.WINDOW_MODAL);
			addStage.initOwner(mainStage);
			
			Parent addRoot;
			
			addRoot = FXMLLoader.load(getClass().getResource("AddClicked.fxml"));
			
			Scene scene = new Scene(addRoot);
			
			addStage.setTitle("추가");
			addStage.setScene(scene);
			addStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btnBarChartClicked(ActionEvent event) {
    	
    	try {
    		
    		barChartStage.initModality(Modality.WINDOW_MODAL);
    		barChartStage.initOwner(mainStage);
    		
    		Parent barChartRoot;
    		
    		barChartRoot = FXMLLoader.load(getClass().getResource("BarChart.fxml"));
    		
    		Scene scene = new Scene(barChartRoot);
    		
    		barChartStage.setTitle("막대 그래프");
    		barChartStage.setScene(scene);
    		barChartStage.show();
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void tableClicked(MouseEvent event) {

    }
    
    static ObservableList<StudentVO> dataList;

    @FXML
    void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert gukCol != null : "fx:id=\"gukCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert suCol != null : "fx:id=\"suCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert engCol != null : "fx:id=\"engCol\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'StudentMain.fxml'.";
        assert btnBarChart != null : "fx:id=\"btnBarChart\" was not injected: check your FXML file 'StudentMain.fxml'.";
        
        ArrayList<StudentVO> stdList = new ArrayList<StudentVO>();
    	
        stdList.add(new StudentVO("1", 1, 1, 1));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        gukCol.setCellValueFactory(new PropertyValueFactory<>("guk"));
        suCol.setCellValueFactory(new PropertyValueFactory<>("su"));
        engCol.setCellValueFactory(new PropertyValueFactory<>("eng"));
        
        dataList = FXCollections.observableArrayList(stdList);
//        
        table.setItems(dataList);
        

    }
}
