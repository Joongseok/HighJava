package board.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import board.vo.JdbcBoardVO;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import util.AlertUtil;

public class FxBoardWriteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private VBox writeVBox;
    @FXML
    private URL location;

    @FXML
    private TextField tfWriter;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea txtContents;

    @FXML
    private Button btnWrite;

    @FXML
    private Button btnCancle;

    
    @FXML
    void btnCancleAction(ActionEvent event) {
    	try {
    		StackPane root = (StackPane) btnWrite.getScene().getRoot();
    		
    		writeVBox.setOpacity(1); // 투명
    		KeyValue keyValue = new KeyValue(writeVBox.opacityProperty(), 0);
    		
    		
    		
    		
    		
    		KeyFrame keyFrame = new KeyFrame(
    				Duration.millis(800),
    				new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							// 애니메이션이 끝난 다음에 처리할 내용을 기술한다.
							root.getChildren().remove(writeVBox);
						}
					},
    				keyValue);
    		
    		Timeline timeline = new Timeline();
    		
    		timeline.getKeyFrames().add(keyFrame);
    		timeline.play();
    		
    		
		} catch (Exception e2) {
			e2.printStackTrace();
		}
    }
    
    @FXML
    void btnWriteAction(ActionEvent event) {
    	FxBoardMainController e = new FxBoardMainController();
    	
    	
    	try {
    		if (txtContents.getText().isEmpty()||tfWriter.getText().isEmpty() || tfTitle.getText().isEmpty()) {
    			AlertUtil.warning("오류", "추가작업오류", "빈 항목이 있습니다.");
    			return;
    		}
    		JdbcBoardVO boardVo = new JdbcBoardVO();
    		boardVo.setBoard_writer(tfWriter.getText());
    		boardVo.setBoard_content(txtContents.getText());
    		boardVo.setBoard_title(tfTitle.getText());
    		
    		int cnt = FxBoardMainController.service.insertBoard(boardVo);
    		if (cnt > 0) {  // DB에 insert 성공
    			ArrayList<JdbcBoardVO>boardList = (ArrayList<JdbcBoardVO>) FxBoardMainController.service.getAllBoardList();
    	        
    			FxBoardMainController.data.setAll(boardList);
    			AlertUtil.warning("결과", "작업성공", "추가 작업에 성공했습니다.");
    		}else {
    			AlertUtil.warning("결과", "작업실패", "추가 작업에 실패했습니다.");
    		}
    		
    		StackPane root = (StackPane) btnWrite.getScene().getRoot();
    		
    		writeVBox.setOpacity(1); // 투명
    		KeyValue keyValue = new KeyValue(writeVBox.opacityProperty(), 0);
    		
    		
    		
    		KeyFrame keyFrame = new KeyFrame(
    				Duration.millis(800),
    				new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							// 애니메이션이 끝난 다음에 처리할 내용을 기술한다.
							root.getChildren().remove(writeVBox);
						}
					},
    				keyValue);
    		
    		Timeline timeline = new Timeline();
    		
    		timeline.getKeyFrames().add(keyFrame);
    		
    		timeline.play();
    		
		} catch (Exception e2) {
			e2.printStackTrace();
		}
    }
    
    @FXML
    void initialize() {
    	assert writeVBox != null : "fx:id=\"writeVBox\" was not injected: check your FXML file 'FxBoardWrite.fxml'.";
        assert tfWriter != null : "fx:id=\"tfWriter\" was not injected: check your FXML file 'FxBoardWrite.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'FxBoardWrite.fxml'.";
        assert txtContents != null : "fx:id=\"txtContents\" was not injected: check your FXML file 'FxBoardWrite.fxml'.";
        assert btnWrite != null : "fx:id=\"btnWrite\" was not injected: check your FXML file 'FxBoardWrite.fxml'.";
        assert btnCancle != null : "fx:id=\"btnCancle\" was not injected: check your FXML file 'FxBoardWrite.fxml'.";

    }
}
