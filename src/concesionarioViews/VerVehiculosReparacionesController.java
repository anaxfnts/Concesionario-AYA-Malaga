package concesionarioViews;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;

import concesionarioModels.HibernateUtil;
import concesionarioModels.Reparacion;
import daos.ReparacionDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import utils.GridpanelReparaciones;

public class VerVehiculosReparacionesController implements Initializable {

	Session sesion = HibernateUtil.getSession();
	ReparacionDAO gestorReparaciones = new ReparacionDAO(sesion);

	private GridpanelReparaciones grid = new GridpanelReparaciones();

	static List<Reparacion> listaReparaciones = new ArrayList<Reparacion>();

	static List<AnchorPane> paneles = new ArrayList<AnchorPane>();

	private GridPane nuevoGrid;

	private int columna = 0;
	private int fila = 0;

	@FXML
	private BorderPane borderPaneReparaciones;

	@FXML
	private Button buttonBusquedaIDReparacion;
	
	@FXML
	private Button buttonBusquedaMatricula;

	@FXML
	private TextField txtBuscarMatricula;

	@FXML
	private TextField txtBuscarIDReparacion;

	@FXML
	private Button buttonRestaurarBusqueda;
	
	public void initialize(URL location, ResourceBundle resources) {

		int fila = 0;
		int columna = 0;

		try {
			listaReparaciones = gestorReparaciones.searchAll("Reparacion");
			paneles = grid.crearPaneles(listaReparaciones);
			nuevoGrid = grid.crearGridPane(columna, fila, paneles);
			borderPaneReparaciones.setCenter(nuevoGrid);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		Image lupa = new Image("images/lupa.png");
		ImageView imagen = new ImageView(lupa);
		imagen.setFitHeight(12);
		imagen.setFitWidth(12);
		
		Image lupa2 = new Image("images/lupa.png");
		ImageView imagen2 = new ImageView(lupa2);
		imagen2.setFitHeight(12);
		imagen2.setFitWidth(12);
	
		
		buttonBusquedaIDReparacion.setGraphic(imagen);
		buttonBusquedaMatricula.setGraphic(imagen2);
		
	}


	
	@FXML
	void buscarMatricula(MouseEvent event) throws IOException {
		limpiarListas();
		listaReparaciones = gestorReparaciones.buscarMatricula(txtBuscarMatricula.getText().toUpperCase());
		paneles = grid.crearPaneles(listaReparaciones);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneReparaciones.setCenter(nuevoGrid);
	}
	

	@FXML
	void buscarIDReparacion(MouseEvent event) throws IOException {
		limpiarListas();
		listaReparaciones = gestorReparaciones.buscarPorID(txtBuscarIDReparacion.getText().toUpperCase());
		paneles = grid.crearPaneles(listaReparaciones);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneReparaciones.setCenter(nuevoGrid);
	}
	
	@FXML
	void restaurarReparaciones(MouseEvent event) throws IOException {
		limpiarListas();
		listaReparaciones = gestorReparaciones.listaReparaciones();
		paneles = grid.crearPaneles(listaReparaciones);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneReparaciones.setCenter(nuevoGrid);
	}
	

	private static void limpiarListas() {
		listaReparaciones.clear();
		paneles.clear();
	}

}
