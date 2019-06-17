package util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {
	
	public static void warning(String title, String header, String msg) {
		Alert warning = new Alert(AlertType.WARNING);
		warning.setTitle(title);
		warning.setHeaderText(header);
		warning.setContentText(msg);
		
		warning.showAndWait();
	}
	
	public static void information(String title, String header, String msg) {
		Alert information = new Alert(AlertType.INFORMATION);
		information.setTitle(title);
		information.setHeaderText(header);
		information.setContentText(msg);
		
		information.showAndWait();
	}
	
	public static void error(String title, String header, String msg) {
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle(title);
		error.setHeaderText(header);
		error.setContentText(msg);
		error.showAndWait();
	}
	
	public static ButtonType confirm(String title, String header, String msg) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle(title);
		confirm.setHeaderText(header);
		confirm.setContentText(msg);
		
		return confirm.showAndWait().get();
		
	}
	
	
	public static void prompt(String title, String header, String msg) {
		TextInputDialog prompt = new TextInputDialog();
		prompt.setTitle(title);
		prompt.setHeaderText(header);
		prompt.setContentText(msg);
		Optional<String>result = prompt.showAndWait();
		
//		result.ifPresent(str ->{
//			System.out.println("=> " + str + " <=");
//		});
		
		String strTemp = "";
		if (result.isPresent()) {
			strTemp = result.get();
		}
		System.out.println("=> " + strTemp + " <=");
	}
}
