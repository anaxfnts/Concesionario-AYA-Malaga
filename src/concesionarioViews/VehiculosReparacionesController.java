package concesionarioViews;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;

import concesionarioModels.Cliente;
import concesionarioModels.HibernateUtil;
import concesionarioModels.Reparacion;
import concesionarioModels.Vehiculo;
import daos.EmpleadosDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class VehiculosReparacionesController implements Initializable {
	
	private Session sesion = HibernateUtil.getSession();
	EmpleadosDAO gestorEmpleados = new EmpleadosDAO(sesion);

	//Todos los elementos
	private Reparacion reparacion = null;
	private Vehiculo vehiculo = null;
	
	@FXML
	private Label lblID;
	
	@FXML
	private Label estado;
	
	@FXML
	private ImageView img;

	@FXML
	private TextField txtVehiculoMatricula;

	@FXML
	private TextField txtVehiculoPieza;

	@FXML
	private TextField txtNombreCliente;

	@FXML
	private TextField txtVehiculoCoste;
	
	@FXML
	private TextField txtMarca;

	@FXML
	private TextField txtFecha;
	
	@FXML
	private Rectangle rectangulo;

	//Setea los datos necesarios de cada vehiculo
	public void setDatos(Reparacion reparaciones, Vehiculo vehiculos) throws FileNotFoundException {
		reparacion = reparaciones;
		vehiculo = vehiculos;
		lblID.setText(String.valueOf(reparaciones.getIdReparacion()));
		txtVehiculoMatricula.setText(reparaciones.getMatricula());
		txtVehiculoPieza.setText(reparaciones.getPieza());
		txtNombreCliente.setText(String.valueOf(reparaciones.getNombreCliente()));
		txtVehiculoCoste.setText(String.valueOf(reparaciones.getCoste()));
		txtFecha.setText(String.valueOf(reparaciones.getFecha()));
		txtMarca.setText(String.valueOf(reparaciones.getMarca()));
		estado.setText(reparaciones.getEstado_reparacion());
		Image imagen = new Image(new FileInputStream("imagenes" + "/" + reparaciones.getImagen()));
		img.setImage(imagen);
		img.setVisible(false);
		rectangulo.setFill(new ImagePattern(imagen));


	}

	//Inicializa
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtVehiculoMatricula.setEditable(false);
		txtVehiculoPieza.setEditable(false);
		txtNombreCliente.setEditable(false);
		txtVehiculoCoste.setEditable(false);
		txtFecha.setEditable(false);
		txtMarca.setEditable(false);
	}

}

