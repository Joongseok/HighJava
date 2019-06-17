package student.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import student.service.IStudentService;
import student.service.StudentServiceImpl;
import student.vo.StudentVO;
import util.AlertUtil;

public class StudentAddFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtKor;

    @FXML
    private TextField txtEng;

    @FXML
    private TextField txtMat;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    private IStudentService service;
    private StudentMainController stdMainController;
    
    
    public StudentMainController getStdMainController() {
		return stdMainController;
	}

	public void setStdMainController(StudentMainController stdMainController) {
		this.stdMainController = stdMainController;
	}

	
	@FXML
    void btnCancelClick(ActionEvent event) {
		// 현재 창을 닫으려면 현재 Stage 객체를 얻어야한다.
		// 현재 창의 Stage객체는 컨트롤러 객체를 이용하여 얻을 수 있다.
		Stage thisForm =(Stage) btnCancel.getScene().getWindow();
		thisForm.close();
    }

	// 저장버튼
    @FXML
    void btnSaveClick(ActionEvent event) {	
    	String name = txtName.getText().trim();
    	String strKor = txtKor.getText();
    	String strMat = txtMat.getText();
    	String strEng = txtEng.getText();
    	
    	if (name.isEmpty()) {
			AlertUtil.warning("경고", "입력오류", "이름을 입력하세요");
			txtName.requestFocus();
			return;
		}
    	if (!Pattern.matches("^[0-9]+$", strKor)) {
    		AlertUtil.warning("경고", "입력오류", "국어 점수를 입력하세요");
    		txtKor.requestFocus();
    		return;
    	}
    	if (!Pattern.matches("^[0-9]+$", strEng)) {
    		AlertUtil.warning("경고", "입력오류", "영어 점수를 입력하세요");
    		txtEng.requestFocus();
    		return;
    	}
    	if (!Pattern.matches("^[0-9]+$", strMat)) {
    		AlertUtil.warning("경고", "입력오류", "수학 점수를 입력하세요");
    		txtMat.requestFocus();
    		return;
    	}
    	
    	// StudentVO객체에 입력한 값 저장하기
    	StudentVO stdVo = new StudentVO();
    	stdVo.setStd_name(name);
    	stdVo.setStd_kor(Integer.parseInt(strKor));
    	stdVo.setStd_mat(Integer.parseInt(strMat));
    	stdVo.setStd_eng(Integer.parseInt(strEng));
    	
    	// DB에 저장하기
    	int cnt = service.insertStudent(stdVo);
    	if (cnt>0) { 	// DB에 추가 성공일 경우
    		//StudentMainController객체에 있는
    		// setStudentData()메서드 호출
			stdMainController.setStudentData();
			AlertUtil.warning("정보", "작업결과", name + " 학생 성적을 추가했습니다.");
		}else {
			AlertUtil.warning("오류", "작업결과", name + " 학생 성적 추가실패");
		}
    	
    	// TextField 초기화
    	txtName.clear();
    	txtKor.clear();
    	txtMat.clear();
    	txtEng.clear();
    	
    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert txtKor != null : "fx:id=\"txtKor\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert txtEng != null : "fx:id=\"txtEng\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert txtMat != null : "fx:id=\"txtMat\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'StudentAddForm.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'StudentAddForm.fxml'.";

        service = StudentServiceImpl.getInstance();
        
    }
}
