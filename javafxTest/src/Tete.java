
import java.time.LocalDate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class Tete extends Application {

	@Override
	public void start(Stage stage) {
		final DatePicker datePicker = new DatePicker(LocalDate.now());
        datePicker.setOnAction(event -> {
            LocalDate date = datePicker.getValue();
            System.out.println("Selected date: " + date);
        });

        stage.setScene(
            new Scene(datePicker)
        );
        stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
