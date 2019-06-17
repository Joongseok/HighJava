package board.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import board.service.IJdbcBoardService;
import board.service.JdbcBoardServiceImpl;
import board.vo.JdbcBoardVO;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import util.AlertUtil;

public class FxBoardMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnWrite;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField tfSelect;

    @FXML
    private Button btnSelect;

    @FXML
    private TableView<JdbcBoardVO> table;

    @FXML
    private TableColumn<?, ?> noCol;

    @FXML
    private TableColumn<?, ?> titleCol;

    @FXML
    private TableColumn<?, ?> writerCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> cntCol1;

    @FXML
    private Pagination pagination;

    @FXML
    void btnWriteAction(ActionEvent event) {
    	
    	try {
    		
    		Parent write = FXMLLoader.load(getClass().getResource("FxBoardWrite.fxml"));
    		
    		// 루트컨트롤러 구하기
    		// 형식 ) 현재화면에 있는 아무 컨트롤러객체.getScene().getRoot();
    		StackPane root = (StackPane) btnWrite.getScene().getRoot();
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
    	
    	boardList = (ArrayList<JdbcBoardVO>) service.getAllBoardList();
        data = FXCollections.observableArrayList(boardList);
    	table.setItems(data);
    	
    }
    
    @FXML
    void comboBoxAction(ActionEvent event) {
    	
    	
    }
    List<JdbcBoardVO> boardList1;
    @FXML
    void btnSelectAction(ActionEvent event) {
    	if ( !(comboName.equals("board_writer")|| comboName.equals("board_content") || comboName.equals("board_title")) ) {
    		AlertUtil.warning("항목", "항목 선택", "항목을 선택해 주세요.");
    		return;
    	}
    		boardList1 = (ArrayList<JdbcBoardVO>) service.getSearchBoard(comboName, tfSelect.getText());
    		data = FXCollections.observableArrayList(boardList1);
    		table.setItems(data);
    	
    }
    static JdbcBoardVO jbvv;
    
    
    
    @FXML
    void tableViewClicked(MouseEvent event) {
    	jbvv = table.getSelectionModel().getSelectedItem();
    	if (jbvv!=null) {
			
    	try {
    		
    		
    		index = table.getSelectionModel().getSelectedIndex();
    		Parent write = FXMLLoader.load(getClass().getResource("FxBoardPostsShow.fxml"));
    		
    		// 루트컨트롤러 구하기
    		// 형식 ) 현재화면에 있는 아무 컨트롤러객체.getScene().getRoot();
    		StackPane root = (StackPane) btnWrite.getScene().getRoot();
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
    		
    		boardList = (ArrayList<JdbcBoardVO>) service.getAllBoardList();
	        
	        data = FXCollections.observableArrayList(boardList);
	        table.setItems(data);
    		changeTableView(pagination.currentPageIndexProperty().get());
	        
		} catch (IOException e2) {
			e2.printStackTrace();
		}
    	
    	}
    	
    }
    
    public void changeTableView(int index) {
		// subList(시작, 종료)
		// 0 ~ 9 ==> 0 
		// 10 ~ 19 ==> 1
		// 20 ~ 29 ==> 2 	123 30
		//...
		// 110~119 ==> 11 	123 120
		// 120~122 ==> 12 	123 130
		int fromIndex = index * rowsPerPage; // 시작 위치
		int toIndex = Math.min(fromIndex + rowsPerPage, data.size()); // 종료위치
		
		// 시작위치부터 종료위치 이전깢의 데이터를 가져와
		// TableView에 셋팅한다.
		table.setItems(FXCollections.observableArrayList(
			data.subList(fromIndex, toIndex)
		));
		
	}
    
    int rowsPerPage = 18;
    static int index;
    static IJdbcBoardService service;
    static ObservableList<JdbcBoardVO> data;
    static ArrayList<JdbcBoardVO> boardList;
    static String comboName = "";
    @FXML
    void initialize() {
        assert btnWrite != null : "fx:id=\"btnWrite\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert tfSelect != null : "fx:id=\"tfSelect\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert btnSelect != null : "fx:id=\"btnSelect\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert noCol != null : "fx:id=\"noCol\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert titleCol != null : "fx:id=\"titleCol\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert writerCol != null : "fx:id=\"writerCol\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert dateCol != null : "fx:id=\"dateCol\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert cntCol1 != null : "fx:id=\"cntCol1\" was not injected: check your FXML file 'FxBoardMain.fxml'.";
        assert pagination != null : "fx:id=\"pagination\" was not injected: check your FXML file 'FxBoardMain.fxml'.";

     // 콤보 박스에 보여질 내용
        comboBox.getItems().addAll( "이름", "제목", "내용" );
        jbvv = table.getSelectionModel().getSelectedItem();
        // 컨트롤러에 서비스를 연결한다.
        service = JdbcBoardServiceImpl.getInstance();
        
        noCol.setCellValueFactory(new PropertyValueFactory<>("board_no"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("board_title"));
        writerCol.setCellValueFactory(new PropertyValueFactory<>("board_writer"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("board_date"));
        cntCol1.setCellValueFactory(new PropertyValueFactory<>("board_cnt"));
        
        boardList = (ArrayList<JdbcBoardVO>) service.getAllBoardList();
        
        data = FXCollections.observableArrayList(boardList);
        table.setItems(data);
        
        pagination.setMaxPageIndicatorCount(rowsPerPage);
        pagination.setPageCount( (int) Math.ceil( (double) data.size() / rowsPerPage) );
        changeTableView(0);
        
        
        // Pagination의 페이지 번호를 변경했을때 이벤트 처리
        pagination.currentPageIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				changeTableView(newValue.intValue());
				
			}
		});
      
        

    	comboBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				comboName = newValue;
				
				switch(comboName){
				case "이름" :
					comboName = "board_writer";
					break;
				case "제목" :
					comboName = "board_title";
					break;
				case "내용" :
					comboName = "board_content";
					break;
				default :
					System.out.println("항목번호를 잘못 선택했습니다.");
					return;
				}
			}
		});
    }
    
}

