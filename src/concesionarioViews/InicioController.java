package concesionarioViews;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InicioController {

  //Paneles de reparaciones, vehiculos y clientes
	@FXML
	private Pane reparaciones;

	@FXML
	private Pane vehiculos;

	@FXML
	private Pane clientes;

	@FXML
	void vistaVehiculosReparaciones(MouseEvent event) throws IOException {
		escenaVehiculosReparaciones();
	}

	@FXML
	void vistaClientes(MouseEvent event) throws IOException {
		escenaClientes();
	}

	@FXML
	void vistaReparaciones(MouseEvent event) throws IOException {
   escenaReparaciones();

	}
	//Metodo que muestra la escena de reparaciones
	private void escenaReparaciones() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaReparaciones.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);

	}
	//Metodo que muestra la escena de vehiculos a reparar
	private void escenaVehiculosReparaciones() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaVerVehiculosReparaciones.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);
	}

	//Metodo que muestra la escena de clientes
	private void escenaClientes() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaVerClientes.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);
	}
}
