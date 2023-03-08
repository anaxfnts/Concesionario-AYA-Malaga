package concesionarioViews;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.hibernate.Session;

import concesionarioModels.Cliente;
import concesionarioModels.HibernateUtil;
import daos.ClienteDAO;
import daos.EmpleadosDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import utils.GridpanelClientes;


public class VerClientesController implements Initializable {

Session sesion = HibernateUtil.getSession();
	ClienteDAO gestorClientes = new ClienteDAO(sesion);

	//Gridpanel
	private GridpanelClientes grid = new GridpanelClientes();

	static List<Cliente> listaClientes = new ArrayList<Cliente>();

	static List<AnchorPane> paneles = new ArrayList<AnchorPane>();

	private GridPane nuevoGrid;

	private int columna = 0;
	private int fila = 0;

	//Todos los elementos
	@FXML
	private BorderPane borderPaneClientes;

	@FXML
	private Button buttonBusquedaNombre;
	
	@FXML
	private Button buttonBusquedaDNI;

	@FXML
	private TextField txtBuscarNombre;

	@FXML
	private TextField txtBuscarApellidos;
	
	@FXML
	private TextField txtBuscarDni;
	
	@FXML
	private TextField txtBuscarID;

	@FXML
	private Button buttonBusquedaApellidos;

	@FXML
	private Button buttonBusquedaID;
	
	@FXML
	private Button buttonRestaurarBusqueda;
	
	//Inicializa
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		int fila = 0;
		int columna = 0;
		//Lista los clientes en filas y columnas
		try {
			listaClientes = gestorClientes.searchAll("Cliente");
			paneles = grid.crearPaneles(listaClientes);
			nuevoGrid = grid.crearGridPane(columna, fila, paneles);
			borderPaneClientes.setCenter(nuevoGrid);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Pone imagen de lupa en cada boton de buscar
		Image img = new Image("images/lupa.png");
		ImageView view = new ImageView(img);
		view.setFitHeight(12);
		view.setFitWidth(12);
		
		Image img2 = new Image("images/lupa.png");
		ImageView view2 = new ImageView(img2);
		view2.setFitHeight(12);
		view2.setFitWidth(12);
		
		Image img3 = new Image("images/lupa.png");
		ImageView view3 = new ImageView(img3);
		view3.setFitHeight(12);
		view3.setFitWidth(12);
		
		Image img4 = new Image("images/lupa.png");
		ImageView view4 = new ImageView(img4);
		view4.setFitHeight(12);
		view4.setFitWidth(12);

		
		buttonBusquedaNombre.setGraphic(view);
		buttonBusquedaApellidos.setGraphic(view2);
		buttonBusquedaDNI.setGraphic(view3);
		buttonBusquedaID.setGraphic(view4);
		
	}


	//Metodo que llama a la consulta de buscar cliente por nombre
	@FXML
	void buscarClienteNombre(MouseEvent event) throws IOException {
		limpiarListas();
		listaClientes = gestorClientes.buscarPorNombre(txtBuscarNombre.getText().toUpperCase());
		paneles = grid.crearPaneles(listaClientes);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneClientes.setCenter(nuevoGrid);
	}

	 //Metodo que llama a la consulta de buscar cliente por apellido
	@FXML
	void buscarClienteApellidos(MouseEvent event) throws IOException {
		limpiarListas();
		listaClientes = gestorClientes.buscarPorApellidos(txtBuscarApellidos.getText().toUpperCase());
		paneles = grid.crearPaneles(listaClientes);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneClientes.setCenter(nuevoGrid);
	}
	
	//Metodo que llama a la consulta de buscar cliente por dni
	@FXML
	void buscarClienteDNI(MouseEvent event) throws IOException {
		limpiarListas();
		listaClientes = gestorClientes.buscarPorDni(txtBuscarDni.getText().toUpperCase());
		paneles = grid.crearPaneles(listaClientes);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneClientes.setCenter(nuevoGrid);
	}
	

	 //Metodo que llama a la consulta de buscar cliente por ID
	@FXML
	void buscarClienteID(MouseEvent event) throws IOException {
		limpiarListas();
		listaClientes = gestorClientes.buscarPorID(txtBuscarID.getText().toUpperCase());
		paneles = grid.crearPaneles(listaClientes);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneClientes.setCenter(nuevoGrid);
	}
	
	 //Metodo que llama restaura la busqueda
	@FXML
	void restaurarClientes(MouseEvent event) throws IOException {
		limpiarListas();
		listaClientes = gestorClientes.listaClientes();
		paneles = grid.crearPaneles(listaClientes);
		nuevoGrid = grid.crearGridPane(columna, fila, paneles);
		borderPaneClientes.setCenter(nuevoGrid);
	}
	

	private static void limpiarListas() {
		listaClientes.clear();
		paneles.clear();
	}

}
