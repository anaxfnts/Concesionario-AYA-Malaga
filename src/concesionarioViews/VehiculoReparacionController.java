package concesionarioViews;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class VehiculoReparacionController {

  //Panel reparaciones
	@FXML
	private Pane paneReparaciones;


	@FXML
	void vistaVehiculosReparaciones(MouseEvent event) throws IOException {
		vistaVerVehiculosReparaciones();
	}
	
	//Metodo que muestra todos los vehiculos reparaciones
	private void vistaVerVehiculosReparaciones() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/SceneVerVehiculosReparaciones.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);

	}
}