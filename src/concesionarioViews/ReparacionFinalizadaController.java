package concesionarioViews;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ReparacionFinalizadaController {

  //Panel de reparaciones finalizadas
	@FXML
	private Pane paneReparacionesFinalizadas;


	@FXML
	void vistaReparacionesFinalizadas(MouseEvent event) throws IOException {
		vistaVerReparacionesFinalizadas();
	}
	
	//Metodo que muestra la escena de ver reparaciones finalizadas
	private void vistaVerReparacionesFinalizadas() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/SceneVerReparacionesFinalizadas.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);

	}
}