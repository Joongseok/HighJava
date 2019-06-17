package basic.menuTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import util.AlertUtil;

public class MenuExam extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		
		TextArea txtArea = new TextArea();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		root.setTop(menuBar);
		root.setCenter(txtArea);
		
		// File menu --> new, save, exit
		Menu fileMenu = new Menu("File");	// 주메뉴 만들기
		
		MenuItem newMenuItem = new MenuItem("새로만들기");  	// 부메뉴 만들기
		MenuItem openMenuItem = new MenuItem("열기");
		MenuItem changeSaveNameMenuItem = new MenuItem("다른이름으로 저장");
		MenuItem exitMenuItem = new MenuItem("끝내기");
		
		fileMenu.getItems().addAll(newMenuItem, openMenuItem, changeSaveNameMenuItem,
				new SeparatorMenuItem(), exitMenuItem);
		
		
		
		// 다른이름으로 저장
	    changeSaveNameMenuItem.setOnAction(e->{
	    	
		FileChooser fileChooser = new FileChooser();
		
		fileChooser.getExtensionFilters().addAll(
			new ExtensionFilter("Text Files", "*.txt")
		); 
		fileChooser.setInitialDirectory(new File("d:/D_Other"));
		fileChooser.setInitialFileName("NoName.txt");
		File selectedFile = fileChooser.showSaveDialog(primaryStage);
		
		// 저장하지 않고 취소눌렀을때 nullPinterException을 막기위한 조건식
		if(selectedFile==null) {
			return;
		}
		try {
		
			FileWriter f =new FileWriter(selectedFile.getPath());
			BufferedWriter ff = new BufferedWriter(f);
			
			ff.write(txtArea.getText());
			
			ff.flush();
	
			ff.close();
			AlertUtil.warning("저장", "저장완료", "저장이 완료되었습니다.");
		} catch (IOException e2) {

		}
			
		});
	    
	    
		
		
		newMenuItem.setOnAction(e->{
			
			if (!txtArea.getText().equals("")) {
	    		// txtArea에 내용이남아있으면 수행하는 메서드
				ButtonType newFile = AlertUtil.confirm("저장", "저장하시겠습니까?", "새로 만들기 전에 저장하세요.");
				if (newFile==ButtonType.OK) {
					// OK버튼을 눌렀을때 다른이름 저장을 불러오는 메서드
					changeSaveNameMenuItem.getOnAction().handle(e);
				}else {
					txtArea.clear();
					primaryStage.setTitle("NoName.txt");
					return;
				}
			}
			
		});
		
		
		 openMenuItem.setOnAction(e->{
			
			if (!txtArea.getText().equals("")) {
	    		// txtArea에 내용이남아있으면 수행하는 메서드
				ButtonType newFile = AlertUtil.confirm("저장", "저장하시겠습니까?", "새로 만들기 전에 저장하세요.");
				if (newFile==ButtonType.OK) {
					changeSaveNameMenuItem.getOnAction().handle(e);
				}else {
					
				}
			}
			
			FileChooser fileChooser = new FileChooser();
			
	    	// 열기할 파일 종류 설정 
	    	fileChooser.getExtensionFilters().addAll(
	    			new ExtensionFilter("Text Files",  "*.txt")
	    	);
	    	
	    	// 창을 열었을 때 보여줄 폴더(디렉토리) 설정
	    	fileChooser.setInitialDirectory(new File("d:/D_Other"));
	    	
	    	File selectedFile = fileChooser.showOpenDialog(primaryStage); 	// 부모창 객체를 매개변수로 넘겨준다.
			if (selectedFile!=null) {
				try {
					
					FileInputStream fin = new FileInputStream(selectedFile.getPath());
					
					InputStreamReader isr = new InputStreamReader(fin, "utf-8");
					// 캐릭터형 파일을 읽어서 스트링에 담을 변수
					String read = "";
					
					int c;
					while((c=isr.read()) != -1){
						read += (char)c;
					}
					txtArea.setText(read);
					primaryStage.setTitle(selectedFile.getPath());
					isr.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
	    	
		});
		
		
		
		
		
		// 메뉴를 선택했을 때의 이벤트 처리
		exitMenuItem.setOnAction(e->{
			if (!txtArea.getText().equals("")) {
	    		// txtArea에 내용이남아있으면 수행하는 메서드
				ButtonType newFile = AlertUtil.confirm("저장", "저장하시겠습니까?", "새로 만들기 전에 저장하세요.");
				if (newFile==ButtonType.OK) {
					changeSaveNameMenuItem.getOnAction().handle(e);
				}else {
					Platform.exit();
				}
			}
		});
		
		
		menuBar.getMenus().add(fileMenu);
		
		Scene scene = new Scene(root,500,450);
		primaryStage.setTitle("NoName.txt");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
