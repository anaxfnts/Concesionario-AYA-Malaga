package concesionarioViews;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ReparacionesController {

	//Botones de los dos paneles de reparaciones
	@FXML
	private Button btnReparacionesDisponibles;
	
	@FXML
	private Button btnReparacionesFinalizadas;
	
	

	@FXML
	void vistaReparacionesFinalizadas(MouseEvent event) throws IOException {
		escenaReparacionesFinalizadas();
	}

	@FXML
	void vistaReparacionesDisponibles(MouseEvent event) throws IOException {
		escenaReparacionesDisponibles();

	}
	//Metodo que muestra las reparaciones disponibles del empleado
	private void escenaReparacionesDisponibles() throws IOException {
		FXMLLoader loade = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaVerReparacionesDisponibles.fxml"));
		AnchorPane root = loade.load();

		LoginController.root.setCenter(root);

	}
	//Metodo que muestra las reparaciones finalizadas del empleado
	private void escenaReparacionesFinalizadas() throws IOException {
		FXMLLoader loade = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaVerReparacionesFinalizadas.fxml"));
		AnchorPane root = loade.load();

		LoginController.root.setCenter(root);

	}

}
