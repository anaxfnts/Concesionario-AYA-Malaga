package application;
	
import java.io.IOException;
import java.util.List;

import concesionarioViews.LoginController;
import daos.VehiculoDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import concesionarioModels.HibernateUtil;
import concesionarioModels.Vehiculo;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
	  
	  //Carga la vista Principal del programa además del icono del concesionario
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/LoginView.fxml"));
		Parent root = loader.load();
		Scene escena = new Scene(root);
		primaryStage.setScene(escena);
		LoginController controlador = loader.getController();
		controlador.setStage(primaryStage);
		primaryStage.setMaximized(true);
		primaryStage.getIcons().add(new Image("images/logo.PNG"));
		primaryStage.setTitle("AYA Vehiculos");
		primaryStage.show();
		
	}
	
	//Ejecuta la función que carga la vista principal
	public static void main(String[] args) {	
		launch(args);
		
		
	}
}
