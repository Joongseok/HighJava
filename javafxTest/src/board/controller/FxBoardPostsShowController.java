package board.controller;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import util.AlertUtil;

public class FxBoardPostsShowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vBox;

    @FXML
    private TextField tfWriter;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextArea txtContents;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReturn;

    @FXML
    void btnEditAction(ActionEvent event) {
    	try {
    		Parent write = FXMLLoader.load(getClass().getResource("FxBoardPostsEdit.fxml"));
    		
    		// 루트컨트롤러 구하기
    		// 형식 ) 현재화면에 있는 아무 컨트롤러객체.getScene().getRoot();
    		StackPane root = (StackPane) btnEdit.getScene().getRoot();
    		root.getChildren().add(write);
    		
    		// 이동 애니메이션
//    		write.setTranslateX(728); 	// x축으로 평행이동할 양 설정
    									// (애니메이션을 시작할 위치로 설정한다.)
    		
    		// KeyFrame에 설정된 내용대로 애니메이션을 진행시키는 객체
    		Timeline timeLine = new Timeline();
    		
    		
    	
    		// Fade효과 (불투명도를 이용하고 값의 범위는 0.0(투명) ~ 1.0(불투명)
    		write.setOpacity(0); 	// 시작 불투명도 설정
    		KeyValue keyValue = new KeyValue(write.opacityProperty(), 1); 	// 최종 목적값
//    		KeyValue keyValue = new KeyValue(write.translateXProperty(), 0);
    		
    		
    		
    		// 애니메이션의 지속시간과 KeyValue를 설정하는 객체 ==> KeyFrame
    		// 형식1 ) new KeyFrame( 지속시간, keyValue객체 );
    		// 형식2 ) new KeyFrame( 지속시간, 애니메이션 종료 후 처리할 이벤트, KeyValue객체 );
    		//KeyFrame keyframe = new KeyFrame(Duration.millis(800), keyValue);
    		
    		KeyFrame keyframe = new KeyFrame(Duration.millis(500), keyValue);
    		
    		// Timeline에 KeyFrame 추가
    		timeLine.getKeyFrames().add(keyframe);
    		
    		// 애니메이션 실행
    		timeLine.play();
    		
		} catch (IOException e2) {
			e2.printStackTrace();
		}
    }
    
    @FXML
    void btnDeleteAction(ActionEvent event) {
    	try {
    	ButtonType btnType = AlertUtil.confirm("확인 ", "삭제여부확인", "정말로 삭제하시겠습니까?");
    	
    	if (btnType == ButtonType.OK) {
    		int board_no = FxBoardMainController.jbvv.getBoard_no();
    		int cnt = FxBoardMainController.service.deleteBoard(board_no);
    		if (cnt > 0) { // DB 자료의 삭제 성공
				FxBoardMainController.data.remove(FxBoardMainController.index);	 	//tableView에서 삭제하기
				
			}else {
				AlertUtil.warning("오류", "삭제작업오류", "삭제작업에 실패했습니다.");
			}
		}
    	
    	Parent write = FXMLLoader.load(getClass().getResource("FxBoardMain.fxml"));
		
		// 루트컨트롤러 구하기
		// 형식 ) 현재화면에 있는 아무 컨트롤러객체.getScene().getRoot();
		StackPane root = (StackPane) btnEdit.getScene().getRoot();
		root.getChildren().add(write);
		
		// 이동 애니메이션
//		write.setTranslateX(728); 	// x축으로 평행이동할 양 설정
									// (애니메이션을 시작할 위치로 설정한다.)
		
		// KeyFrame에 설정된 내용대로 애니메이션을 진행시키는 객체
		Timeline timeLine = new Timeline();
		
		
	
		// Fade효과 (불투명도를 이용하고 값의 범위는 0.0(투명) ~ 1.0(불투명)
		write.setOpacity(0); 	// 시작 불투명도 설정
		KeyValue keyValue = new KeyValue(write.opacityProperty(), 1); 	// 최종 목적값
//		KeyValue keyValue = new KeyValue(write.translateXProperty(), 0);
		
		
		
		// 애니메이션의 지속시간과 KeyValue를 설정하는 객체 ==> KeyFrame
		// 형식1 ) new KeyFrame( 지속시간, keyValue객체 );
		// 형식2 ) new KeyFrame( 지속시간, 애니메이션 종료 후 처리할 이벤트, KeyValue객체 );
		//KeyFrame keyframe = new KeyFrame(Duration.millis(800), keyValue);
		
		KeyFrame keyframe = new KeyFrame(Duration.millis(500), keyValue);
		
		// Timeline에 KeyFrame 추가
		timeLine.getKeyFrames().add(keyframe);
		
		// 애니메이션 실행
		timeLine.play();
		
	} catch (IOException e2) {
		e2.printStackTrace();
	}
    }


    @FXML
    void btnReturnAction(ActionEvent event) {
    	try {
	    	StackPane root = (StackPane) btnReturn.getScene().getRoot();
			
			vBox.setOpacity(1); // 투명
			KeyValue keyValue = new KeyValue(vBox.opacityProperty(), 0);
			
			
			
			
			KeyFrame keyFrame = new KeyFrame(
					Duration.millis(800),
					new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							// 애니메이션이 끝난 다음에 처리할 내용을 기술한다.
							root.getChildren().remove(vBox);
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
    	
        assert vBox != null : "fx:id=\"vBox\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert tfWriter != null : "fx:id=\"tfWriter\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert tfDate != null : "fx:id=\"tfDate\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert tfTitle != null : "fx:id=\"tfTitle\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert txtContents != null : "fx:id=\"txtContents\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        assert btnReturn != null : "fx:id=\"btnReturn\" was not injected: check your FXML file 'FxBoardPostsShow.fxml'.";
        
//        JdbcBoardVO jbv = FxBoardMainController.boardList.get(FxBoardMainController.index);
        JdbcBoardVO jbv =  FxBoardMainController.service.getBoard(FxBoardMainController.jbvv.getBoard_no());
        
        tfWriter.setText(jbv.getBoard_writer());
        tfDate.setText(jbv.getBoard_date());
        tfTitle.setText(jbv.getBoard_title());
        txtContents.setText(jbv.getBoard_content());
        
    }
}
