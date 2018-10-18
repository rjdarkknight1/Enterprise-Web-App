package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws IOException
	{
		
		// Create the FXMLLoader
        Parent root = FXMLLoader.load(getClass().getResource("Printer.fxml"));
        
		// Create the Scene
		Scene scene = new Scene(root);
		
		// Set the Scene to the Stage
        stage.setScene(scene);
        
		// Set the Title to the Stage
        stage.setTitle("Printer");
        
        // Display the Stage
     	stage.show();
	}
	
}