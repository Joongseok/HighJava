package mvc.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mvc.service.IMemberService;
import mvc.service.MemberServiceImpl;
import mvc.vo.MemberVO;
import util.AlertUtil;

public class FxMemSem {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField memId;

    @FXML
    private TextField memName;

    @FXML
    private TextField memTel;

    @FXML
    private TextField memAddr;

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button delete;

    @FXML
    private Button ok;

    @FXML
    private Button cancle;

    @FXML
    static TableView<MemberVO> table;

    @FXML
    private TableColumn<MemberVO, String> idCol;

    @FXML
    private TableColumn<MemberVO, String> nameCol;

    @FXML
    private TableColumn<MemberVO, String> telCol;

    @FXML
    private TableColumn<MemberVO, String> addrCol;

    private boolean okcheck;
    
    //추가버튼
    @FXML
    void addMem(ActionEvent event) {
    	
    	memId.setEditable(true);	//편집 가능 상태
    	memName.setEditable(true);
    	memTel.setEditable(true);
    	memAddr.setEditable(true);
    	
    	ok.setDisable(false); // 확인, 취소버튼 활성화
    	cancle.setDisable(false);
    	
    	add.setDisable(true);	 // 추가, 수정,삭제 버튼, 테이블 뷰 비활성화
    	edit.setDisable(true);
    	delete.setDisable(true);
    	table.setDisable(true);
    	
    	memId.clear(); 	//TextField들의 내용 지우기
    	memName.clear(); 	//TextField들의 내용 지우기
    	memTel.clear(); 	//TextField들의 내용 지우기
    	memAddr.clear(); 	//TextField들의 내용 지우기
    	
    	memId.requestFocus(); 	// id입력할 곳에 포커스 주기
    	
    	strWork = "insert";
    }

    
    // 취소 버튼
    @FXML
    void cancleMenu(ActionEvent event) {
    	
    	memId.setEditable(false);	//편집 불가능 상태
    	memName.setEditable(false);
    	memTel.setEditable(false);
    	memAddr.setEditable(false);
    	
    	ok.setDisable(true); // 확인, 취소버튼 비활성화
    	cancle.setDisable(true);
    	
    	add.setDisable(false);	 // 추가, 수정,삭제 버튼, 테이블 뷰 활성화
    	edit.setDisable(false);
    	delete.setDisable(false);
    	table.setDisable(false);
    	
    		
		MemberVO memVo = table.getSelectionModel().getSelectedItem();
    	
    	if (memVo!= null) {
			memId.setText(memVo.getMem_id());
			memName.setText(memVo.getMem_name());
			memTel.setText(memVo.getMem_tel());
			memAddr.setText(memVo.getMem_addr());
		}
    	
    	strWork = "";
    	
    }

    @FXML
    void delMem(ActionEvent event) {
    	int index = table.getSelectionModel().getSelectedIndex();
    	
    	if (index == -1) {
			AlertUtil.warning("경고", "삭제오류", "식제할 데이터를 선택하세요");
			return;
		}
    	ButtonType btnType = AlertUtil.confirm("확인 ", "삭제여부확인", "정말로 삭제하시겠습니까?");
    	
    	if (btnType == ButtonType.OK) {
    		// 선택한 줄에서 mem_id값 구하기
//			String memId = table.getSelectionModel().getSelectedItem().getMem_id();
    		String memId1 = memId.getText();
    		
    		int cnt = service.deleteMember(memId1);
    		if (cnt > 0) { // DB 자료의 삭제 성공
				data.remove(index);	 	//tableView에서 삭제하기
				
				// 삭제 성공 후에 각 TextField값들을 삭제한다.
				memId.clear();
				memName.clear();
				memTel.clear();
				memAddr.clear();
			}else {
				AlertUtil.warning("오류", "삭제작업오류", "삭제작업에 실패했습니다.");
			}
		}
    	
    }

    @FXML
    void editMem(ActionEvent event) {
    	
    	if (table.getSelectionModel().getSelectedIndex() ==-1) {
			util.AlertUtil.warning("경고", "수정작업 오류", "수정작업을 진행할 데이터를 선택한 후 사용하세요.");
			return;
		}
    	
    	memName.setEditable(true); // 이름, 전화번호, 주소만 편집가능 상태
    	memTel.setEditable(true);
    	memAddr.setEditable(true);
    	
    	ok.setDisable(false); // 확인, 취소버튼 활성화
    	cancle.setDisable(false);
    	
    	add.setDisable(true);	 // 추가, 수정,삭제 버튼, 테이블 뷰 비활성화
    	edit.setDisable(true);
    	delete.setDisable(true);
    	table.setDisable(true);
    	
    	strWork = "update";
    	memName.requestFocus();
    	
   
		
    }
    
    // 확인 버튼
    @FXML
    void okMenu(ActionEvent event) {
    	
    	if ("insert".equals(strWork)) { // 추가버튼 후 확인
    		
			if (memId.getText().isEmpty() || memName.getText().isEmpty() ||
					memTel.getText().isEmpty() || memAddr.getText().isEmpty()) {
				AlertUtil.warning("오류", "추가작업오류", "빈 항목이 있습니다.");
				return;
			}
			
			// 입력한 데이터 VO에 담기
			MemberVO memVo = new MemberVO();
			memVo.setMem_id(memId.getText());
			memVo.setMem_name(memName.getText());
			memVo.setMem_tel(memTel.getText());
			memVo.setMem_addr(memAddr.getText());
			
			boolean chk = service.getMember(memId.getText());

			if (chk) {
				AlertUtil.warning("결과", "추가실패", "ID가 중복되었습니다. 다시 입력하세요.");
				
				memId.requestFocus();
				
				return;
			}
			
			int cnt = service.insertMember(memVo);
			
			if (cnt > 0) {  // DB에 insert 성공
				data.add(memVo);
				data = FXCollections.observableArrayList(
					service.getAllMember()
				);
				table.setItems(data);
				memId.clear();
				memName.clear();
				memTel.clear();
				memAddr.clear();
				AlertUtil.warning("결과", "작업성공", "추가 작업에 성공했습니다.");
			}else {
				AlertUtil.warning("결과", "작업실패", "추가 작업에 실패했습니다.");
			}
		}else if("update".equals(strWork)) {
			
			if (memId.getText().isEmpty() || memName.getText().isEmpty() ||
					memTel.getText().isEmpty() || memAddr.getText().isEmpty()) {
				AlertUtil.warning("오류", "수정작업오류", "빈 항목이 있습니다.");
				return;
			}
			
			// 입력한 데이터 VO에 담기
			MemberVO memVo = new MemberVO();
			memVo.setMem_id(memId.getText());
			memVo.setMem_name(memName.getText());
			memVo.setMem_tel(memTel.getText());
			memVo.setMem_addr(memAddr.getText());
			
			int cnt = service.updateMember(memVo);
			
			if (cnt > 0) {  // DB에 insert 성공
				data.add(memVo);
				data = FXCollections.observableArrayList(
					service.getAllMember()
				);
				table.setItems(data);
				memId.clear();
				memName.clear();
				memTel.clear();
				memAddr.clear();
				AlertUtil.warning("결과", "작업성공", "수정 작업에 성공했습니다.");
			}else {
				AlertUtil.warning("결과", "작업실패", "수정 작업에 실패했습니다.");
			}
		}
    	
    	// 추가, 수정작업이 완료되면 원래의 화면 상태로 되돌아 간다.
    	
    	memId.setEditable(false);	//편집 불가능 상태
    	memName.setEditable(false);
    	memTel.setEditable(false);
    	memAddr.setEditable(false);
    	
    	ok.setDisable(true); // 확인, 취소버튼 비활성화
    	cancle.setDisable(true);
    	
    	add.setDisable(false);	 // 추가, 수정,삭제 버튼, 테이블 뷰 활성화
    	edit.setDisable(false);
    	delete.setDisable(false);
    	table.setDisable(false);
    	
    	// 작업이 취소되면 이전에 선택했던 자료를 다시 셋팅한다.
    	MemberVO memVo = table.getSelectionModel().getSelectedItem();
    	
    	if (memVo!= null) {
			memId.setText(memVo.getMem_id());
			memName.setText(memVo.getMem_name());
			memTel.setText(memVo.getMem_tel());
			memAddr.setText(memVo.getMem_addr());
		}
    	strWork = "";
    }
    
    void tableClick(MouseEvent event) {
    	
    	MemberVO memVo = table.getSelectionModel().getSelectedItem();
    	
    	if (memVo!= null) {
			memId.setText(memVo.getMem_id());
			memName.setText(memVo.getMem_name());
			memTel.setText(memVo.getMem_tel());
			memAddr.setText(memVo.getMem_addr());
		}
    	
    }
    
    
    
    private IMemberService service; // 인터페이스인 IMemberService의 객체인 service를 선언한다.
    private ObservableList<MemberVO> data;
    private String strWork = ""; // 추가버튼 또는 수정버튼을 눌렀는지
    							// 여부를 나타내는 값이 저장될 변수
    
    @FXML
    void initialize() {
    	
    	service = MemberServiceImpl.getInstance();
    	
    	idCol.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
    	telCol.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
    	addrCol.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
    	
    	ArrayList<MemberVO> memList = (ArrayList<MemberVO>) service.getAllMember();
    	
    	data = FXCollections.observableArrayList(memList);
    	table.setItems(data);
    	
    	table.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				// 현재 선택한 줄(row)의 데이터 가져오기
				MemberVO m = table.getSelectionModel().getSelectedItem();
				if (m!=null) {
					memId.setText(m.getMem_id());
					memTel.setText(m.getMem_tel());
					memAddr.setText(m.getMem_addr());
					memName.setText(m.getMem_name());
				}
			}
		});
    	
        assert memId != null : "fx:id=\"memId\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert memName != null : "fx:id=\"memName\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert memTel != null : "fx:id=\"memTel\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert memAddr != null : "fx:id=\"memAddr\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert edit != null : "fx:id=\"edit\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert ok != null : "fx:id=\"ok\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert cancle != null : "fx:id=\"cancle\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert idCol != null : "fx:id=\"idCol\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert telCol != null : "fx:id=\"telCol\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";
        assert addrCol != null : "fx:id=\"addrCol\" was not injected: check your FXML file 'FxMemberMVC.fxml'.";

    }
}
