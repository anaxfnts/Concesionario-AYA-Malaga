package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import concesionarioModels.Cliente;
import concesionarioViews.ClientesController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class GridpanelClientes {
//
  public GridPane crearGridPane(int columna, int fila, List<AnchorPane> paneles) {

	GridPane nuevo = new GridPane();

	nuevo.setHgap(90);
	nuevo.setVgap(50);
	nuevo.setAlignment(Pos.CENTER);
	// Recorremos la lista de paneles
	for (int i = 0; i < paneles.size(); i++) {
		nuevo.add(paneles.get(i), columna, fila);
		fila++;
	}
	return nuevo;
}

public List<AnchorPane> crearPaneles(List<Cliente> clienteList) throws IOException {
	List<AnchorPane> paneles = new ArrayList<AnchorPane>();
	
	for (int i = 0; i < clienteList.size(); i++) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/Cliente.fxml"));
		AnchorPane root = loader.load();
		ClientesController controlador = loader.getController();

		// Enviamos los datos de cada vehiculo al controlador de vehiculos
		controlador.setDatos(clienteList.get(i));

		// Añadimos cada panel a una lista de de AnchorPane en nuestro caso siempre de
		// root que hayamos escogido
		paneles.add(root);
	}
	return paneles;
	}

}
