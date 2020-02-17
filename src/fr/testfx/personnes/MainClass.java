package fr.testfx.personnes;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainClass extends Application {
	private Stage stagePrincipal;
	private BorderPane conteneurPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		stagePrincipal = primaryStage;
		stagePrincipal.setTitle("Appplication de gestion de personnes");
		stagePrincipal.setWidth(600);
		stagePrincipal.setHeight(400);
		initialisationConteneurPrincipal();
		initialisationContenu();
	}
	
	

	private void initialisationConteneurPrincipal() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/ConteneurPrincipal.fxml"));
		try {
			conteneurPrincipal = (BorderPane) loader.load();
			Scene scene = new Scene(conteneurPrincipal);
			stagePrincipal.setScene(scene);
			stagePrincipal.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private void initialisationContenu() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainClass.class.getResource("view/PersonView.fxml"));
		try {
			AnchorPane conteneurPersonne = (AnchorPane) loader.load();
			conteneurPrincipal.setCenter(conteneurPersonne);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}
