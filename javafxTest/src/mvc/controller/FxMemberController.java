package mvc.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import basic.controlls.TableViewTest.Member;
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
import mvc.service.IMemberService;
import mvc.service.MemberServiceImpl;
import mvc.vo.MemberVO;
import util.AlertUtil;

public class FxMemberController {

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
    private TableView<MemberVO> table;

    @FXML
    private TableColumn<MemberVO, String> idCol;

    @FXML
    private TableColumn<MemberVO, String> nameCol;

    @FXML
    private TableColumn<MemberVO, String> telCol;

    @FXML
    private TableColumn<MemberVO, String> addrCol;

    private boolean okcheck;
    @FXML
    void addMem(ActionEvent event) {
    	
    	memId.setText("");
    	memName.setText("");
    	memTel.setText("");
    	memAddr.setText("");
    	
		okcheck = true;
		cancle.setDisable(false);
		ok.setDisable(false);
		
		delete.setDisable(true);
		add.setDisable(true);
		edit.setDisable(true);
		table.setDisable(true);
    	
    }

    @FXML
    void cancleMenu(ActionEvent event) {
    	cancle.setDisable(true);
		ok.setDisable(true);
		memId.setDisable(false);
		delete.setDisable(false);
		add.setDisable(false);
		edit.setDisable(false);
		table.setDisable(false);
		
		memId.setText("");
    	memName.setText("");
    	memTel.setText("");
    	memAddr.setText("");
    	
    	MemberVO memVo = table.getSelectionModel().getSelectedItem();
    	
    	if (memVo!= null) {
			memId.setText(memVo.getMem_id());
			memName.setText(memVo.getMem_name());
			memTel.setText(memVo.getMem_tel());
			memAddr.setText(memVo.getMem_addr());
		}
    	
    	
    }

    @FXML
    void delMem(ActionEvent event) {
    	
    	if (table.getSelectionModel().isEmpty()) {
			AlertUtil.warning("경고", "자료선택오류", "삭제할 데이터를 선택하세요.");
			return;
		}
    	ButtonType check = AlertUtil.confirm("삭제확인", "삭제하시겠습니까?", "정말 삭제하시겠습니까?");
		
		// Alert창을 보여주고 사용자가 누른 버튼 종류를 읽어온다.
		
    	if (check == ButtonType.CANCEL) {
    		memId.setText("");
        	memName.setText("");
        	memTel.setText("");
        	memAddr.setText("");
			return;
		}
    	
    	int index = table.getSelectionModel().getSelectedIndex();
    	
    	String name = table.getSelectionModel().getSelectedItem().getMem_name();
		
		data.remove(index);
		
		int cnt = service.deleteMember(memId.getText());
		
		if (cnt > 0) {
			AlertUtil.warning("확인", "삭제작업성공", name+"씨의 정보가 삭제되었습니다.");
			memId.setText("");
	    	memName.setText("");
	    	memTel.setText("");
	    	memAddr.setText("");
		}else{
			AlertUtil.warning("실패", "삭제작업실패", name+"씨의 정보가 삭제되지않았습니다..");
			return;
		}
    }

    @FXML
    void editMem(ActionEvent event) {
    	if (table.getSelectionModel().isEmpty() ||memId.getText().isEmpty() ) {
			AlertUtil.warning("경고", "자료선택오류", "수정할 데이터를 선택하세요.");
			return;
		}
    	okcheck = false;
    	cancle.setDisable(false);
		ok.setDisable(false);
		memId.setDisable(true);
		delete.setDisable(true);
		add.setDisable(true);
		edit.setDisable(true);
		table.setDisable(true);
		
		
    }

    @FXML
    void okMenu(ActionEvent event) {
    	boolean chk = false;
    	if (okcheck==true) {
    		if (memId.getText().isEmpty() || memName.getText().isEmpty() || 
    				memTel.getText().isEmpty() || memAddr.getText().isEmpty()) {
    			AlertUtil.warning("경고", "입력오류", "누락된 데이터가 있습니다.");
    			return;
    		}
    		chk = service.getMember(memId.getText());
			if(chk==true){
				AlertUtil.warning("경고", "입력오류", memId.getText()+"는 중복된 아이디입니다.");
				return;
			}
    		data.add(new MemberVO(memId.getText(), memName.getText(), memTel.getText(), memAddr.getText()));
    		MemberVO memvo = new MemberVO();
    		memvo.setMem_id(memId.getText());
    		memvo.setMem_name(memName.getText());
    		memvo.setMem_tel(memTel.getText());
    		memvo.setMem_addr(memAddr.getText());
    		
    		int cnt = service.insertMember(memvo);
    		
    		if (cnt > 0) {
    			AlertUtil.warning("확인", "작업성공", memName.getText()+"씨의 정보가 추가되었습니다.");
    			cancle.setDisable(true);
    			ok.setDisable(true);
    			
    			delete.setDisable(false);
    			add.setDisable(false);
    			edit.setDisable(false);
    			table.setDisable(false);
    			memId.setText("");
    	    	memName.setText("");
    	    	memTel.setText("");
    	    	memAddr.setText("");
    		}
		}else if(okcheck==false) {
			if (table.getSelectionModel().isEmpty()) {
				AlertUtil.warning("경고", "자료선택오류", "수정할 데이터를 선택해주세요.");
				return;
			}
			MemberVO m = table.getSelectionModel().getSelectedItem();
			if (m!=null) {
				memId.setText(m.getMem_id());
				memTel.setText(m.getMem_tel());
				memAddr.setText(m.getMem_addr());
				memName.setText(m.getMem_name());
			}
			
	    	if (memId.getText().isEmpty() || memName.getText().isEmpty() || 
	    			memTel.getText().isEmpty() || memAddr.getText().isEmpty()) {
	    		AlertUtil.warning("경고", "입력오류", "누락된 데이터가 있습니다.");
	    		return;
	    	}
	    	
	    	int index = table.getSelectionModel().getSelectedIndex();
			data.set(index, new MemberVO(memId.getText(), memName.getText(), 
					memTel.getText(), memAddr.getText()));
			
			MemberVO memvo = new MemberVO();
			memvo.setMem_id(memId.getText());
			memvo.setMem_name(memName.getText());
			memvo.setMem_tel(memTel.getText());
			memvo.setMem_addr(memAddr.getText());
			
			int cnt =service.updateMember(memvo);
			
			if(cnt>0){
				AlertUtil.warning("확인", "수정작업성공", memName.getText()+"씨의 정보가 수정되었습니다.");
				cancle.setDisable(true);
				ok.setDisable(true);
				memId.setDisable(false);
				delete.setDisable(false);
				add.setDisable(false);
				edit.setDisable(false);
				table.setDisable(false);
				memId.setText("");
		    	memName.setText("");
		    	memTel.setText("");
		    	memAddr.setText("");
			}else{
				System.out.println("수정작업 실패!!");
			}
		}
		
    }
    
    private IMemberService service; // 인터페이스인 IMemberService의 객체인 service를 선언한다.
    private ObservableList<MemberVO> data;
    
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
