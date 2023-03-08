package concesionarioViews;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;

import daos.EmpleadosDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import concesionarioModels.Cliente;
import concesionarioModels.HibernateUtil;

public class ClientesController implements Initializable {
	
	private Session sesion = HibernateUtil.getSession();
	EmpleadosDAO gestorEmpleados = new EmpleadosDAO(sesion);

	private Cliente cliente = null;

	@FXML
	private Label lblID;

	@FXML
	private ImageView img;

	@FXML
	private TextField txtApellidos;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtDNI;
	
	@FXML
	private TextField txtTelefono;

	@FXML
	private Circle circulo;

	
	//Metodo que setea todos los datos
	public void setDatos(Cliente clientes) throws FileNotFoundException {
		cliente = clientes;
		lblID.setText(String.valueOf(clientes.getIdCliente()));
		txtNombre.setText(clientes.getNombre());
		txtApellidos.setText(clientes.getApellidos());
		txtDNI.setText(clientes.getDni());
		txtDireccion.setText(clientes.getDireccion());
		txtTelefono.setText(String.valueOf(clientes.getTelefono()));
		Image imagen = new Image(new FileInputStream("imagenes" + "/" + clientes.getImagenCliente()));
		img.setImage(imagen);
		img.setVisible(false);
		circulo.setFill(new ImagePattern(imagen));

	}
	
	//Metodo que inicializa los datos
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		txtNombre.setEditable(false);
		txtApellidos.setEditable(false);
		txtDNI.setEditable(false);
		txtDireccion.setEditable(false);
		txtDNI.setEditable(false);
		txtTelefono.setEditable(false);

	}

}
