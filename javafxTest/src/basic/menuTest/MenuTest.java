package basic.menuTest;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		//화면의 가로크기와 메뉴바의 너비를 같게 한다.
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());;
		root.setTop(menuBar);
		
		// File menu --> new, save, exit
		Menu fileMenu = new Menu("File"); 	// 주메뉴 만들기
		
		MenuItem newMenuItem = new MenuItem("New");  	// 부메뉴 만들기
		MenuItem saveMenuItem = new MenuItem("save");
		MenuItem exitMenuItem = new MenuItem("exit");
		
		// 메뉴를 선택했을 때의 이벤트 처리
		exitMenuItem.setOnAction(e->{
			Platform.exit();
		});
		
		// 주메뉴에 부메뉴 포함시키기
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
				new SeparatorMenuItem(), exitMenuItem);
		// SeparatorMenuItem() ==> 메뉴들 사이의 경계선 그리기는 menuItem
		
		//---------------------------------------
		
		Menu webMenu = new Menu("Web");
		CheckMenuItem htmlItem = new CheckMenuItem("HTML");
		CheckMenuItem cssItem = new CheckMenuItem("CSS");
		cssItem.setSelected(true); 	// 처음부터 선택된 상태로..
		
		CheckMenuItem scriptItem = new CheckMenuItem("JAVASCRIPT");
		
		webMenu.getItems().addAll(htmlItem, cssItem, scriptItem);
		
		//---------------------------------------------------
		Menu sqlMenu = new Menu("SQL");
		ToggleGroup menuTg = new ToggleGroup();
		
		RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
		mysqlItem.setToggleGroup(menuTg);
		
		RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
		oracleItem.setToggleGroup(menuTg);
		oracleItem.setSelected(true);
		
		RadioMenuItem mssqlItem = new RadioMenuItem("MS-SQL");
		mssqlItem.setToggleGroup(menuTg);
		
		// 부메뉴에 속해있는 메뉴 
		Menu tutorialMenu = new Menu("Tutorial");
		// 부메뉴의 메뉴들 구성
		tutorialMenu.getItems().addAll(
			new CheckMenuItem("JAVA Basic"),
			new CheckMenuItem("JAVA High"),
			new CheckMenuItem("JAVA FX")
		);
		
		sqlMenu.getItems().addAll(mysqlItem, oracleItem, mssqlItem,
				new SeparatorMenuItem(), tutorialMenu);
		
		
		// 주메뉴를 MenuBar에 추가하기
		menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("메뉴연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
