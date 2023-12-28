package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Painter using javafx
public class Painter extends Application{
	@Override
	// method to create the stage
	public void start(Stage stage) throws Exception {
		// first load the resource of the stage from Painter.fxml to the root
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("hust/soict/dsai/javafx/Painter.fxml"));
		// create scene from that root
		Scene scene = new Scene(root);
		// set title of stage
		stage.setTitle("Nguyen Xuan Hung's Painter");
		// set scene of stage
		stage.setScene(scene);
		// show it
		stage.show();
	}
	// main to launch the stage
	public static void main(String[] args) {
		launch(args);
	}

}
