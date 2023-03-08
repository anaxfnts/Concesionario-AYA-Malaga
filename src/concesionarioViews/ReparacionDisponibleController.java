package concesionarioViews;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ReparacionDisponibleController {

  //Panel reparaciones disponibles
	@FXML
	private Pane paneReparacionesDisponibles;


	@FXML
	void vistaReparacionesDisponibles(MouseEvent event) throws IOException {
		vistaVerReparacionesDisponibles();
	}
	
	//Metodo que muestra la escena de ver reparaciones disponibles
	private void vistaVerReparacionesDisponibles() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/SceneVerReparacionesDisponibles.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);

	}
}