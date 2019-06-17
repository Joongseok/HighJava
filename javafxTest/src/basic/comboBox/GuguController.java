package basic.comboBox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

public class GuguController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> gugu;

    @FXML
    private Button btn;

    @FXML
    private TextArea result;

    
    @FXML
    void btnClick(ActionEvent event) {
    	
    	if (gugu.getValue()!=null) {
    		int dan = gugu.getValue();
    		result.setText("\t\t   "+dan + "단\n\n");
    		for (int i = 1; i <= 9; i++) {
    			result.appendText("\t\t   "+dan + " * " + i + " = " + dan*i + "\n");
    		}
		}
    	
    	
    }

    @FXML
    void initialize() {
        assert gugu != null : "fx:id=\"gugu\" was not injected: check your FXML file 'Gugudan.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'Gugudan.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'Gugudan.fxml'.";
        
        gugu.getItems().addAll(1,2,3,4,5,6,7,8,9);
        
        gugu.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {
			
			@Override
			public ListCell<Integer> call(ListView<Integer> param) {
				return new ListCell<Integer>() {
					@Override
					protected void updateItem(Integer item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setText(null);
						}else {
							setText(item + "단");
						}
					}
				};
			}
		});
        
        gugu.setButtonCell(new ListCell<Integer>() {
        	@Override
        	protected void updateItem(Integer item, boolean empty) {
        		if (empty) {
					setText(null);
				}else {
					setText(item + "단");
				}
        		super.updateItem(item, empty);
        	}
        });
        
    }
}
