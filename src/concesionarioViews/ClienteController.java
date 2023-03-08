package concesionarioViews;

import java.io.IOException;

import concesionarioViews.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ClienteController {

  //pane de Clientes
 @FXML
	private Pane paneClientes;

 //Vista de clientes
	@FXML
	void vistaClientes(MouseEvent event) throws IOException {
		vistaVerCliente();
	}
	
	
	private void vistaVerCliente() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/SceneVerClientes.fxml"));
		AnchorPane root = loader.load();
		LoginController.root.setCenter(root);

	}
}