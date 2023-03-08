package concesionarioViews;

import java.io.FileInputStream;
import java.io.IOException;

import org.hibernate.Session;

import concesionarioModels.Empleados;
import concesionarioModels.HibernateUtil;
import daos.EmpleadosDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class PrincipalController {

	@SuppressWarnings("unused")
	private Stage stage;
	@SuppressWarnings("unused")
	private LoginController controLogin;
	private BorderPane borderPane;
	private AnchorPane root;
	
	//Todos los elementos
	@FXML
	private Label nombreUsuario;
	
	@FXML
	private Label nombreCargo;

	@FXML
	private MenuButton menuClientes;

	@FXML
	private MenuButton menuVehiculos;

	@FXML
	private MenuButton menuReparaciones;
	
	@FXML
	private Rectangle rectangulo;
	
	@FXML
	private ImageView img;
	
	@FXML
	private Button btnSalir;
	
	@FXML
    private Button btnInicio;
	
	//Setea los datos necesarios y las imagenes
	public void init(Stage stage, LoginController loginController, String usuario, BorderPane border, String cargo, String imagenEmpleado) throws IOException {
		this.stage = stage;
		this.controLogin = loginController;
		nombreUsuario.setText(usuario);
		nombreCargo.setText(cargo);
		this.borderPane = border;
		stage.getIcons().add(new Image("images/logo.PNG"));
		
		Image imagen = new Image (new FileInputStream("imagenes" + "/" + imagenEmpleado));
		img.setImage(imagen);
		img.setVisible(true);
		rectangulo.setFill(new ImagePattern(imagen));

		stage.setTitle("AYA Vehiculos");
		stage.show();
		escenaInicio();
	}
	
	//Metodo que muestra la escena de inicio
	public void escenaInicio() throws IOException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaInicio.fxml"));
		AnchorPane root = load.load();
		borderPane.setCenter(root);
		
	}
	
		
	    @FXML
	    void vistaInicio(MouseEvent event) throws IOException {
	    	escenaInicio();
	    	borderPane.setLeft(null);
	    }
	    
	    
	    @FXML
	  	void vistaReparaciones(MouseEvent event) throws IOException {
	    	escenaReparaciones();

	  	}
	    //Metodo que muestra la escena de Reparaciones
	  	private void escenaReparaciones() throws IOException {
	  		FXMLLoader loade = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaReparaciones.fxml"));
	  		AnchorPane root = loade.load();

	  		LoginController.root.setCenter(root);

	  	}
	  	
	  	
	  	@FXML
	  	void vistaVehiculosReparaciones(MouseEvent event) throws IOException {
	    	escenaVehiculosReparaciones();

	  	}
	  	//Metodo que muestra la escena de todos los vehiculos a reparar
	  	private void escenaVehiculosReparaciones() throws IOException {
	  		FXMLLoader loade = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaVerVehiculosReparaciones.fxml"));
	  		AnchorPane root = loade.load();

	  		LoginController.root.setCenter(root);

	  	}
	  	
	  	@FXML
	  	void vistaVerClientes(MouseEvent event) throws IOException {
	    	escenaVerClientes();

	  	}
	  	
	  	//Metodo que muestra la escena de todos los clientes
	  	private void escenaVerClientes() throws IOException {
	  		FXMLLoader loade = new FXMLLoader(getClass().getResource("/concesionarioViews/ScenaVerClientes.fxml"));
	  		AnchorPane root = loade.load();

	  		LoginController.root.setCenter(root);

	  	}
	  	
	  	
	  	@FXML
	  	void salir(MouseEvent event) throws IOException {
	  		escenaLogin();
	  	}
	  	
	  	//Metodo que cierra sesion y vuelve a mostrar el Login
	  	private void escenaLogin() throws IOException {
	  	  FXMLLoader loader = new FXMLLoader(getClass().getResource("/concesionarioViews/LoginView.fxml"));
	      root = loader.load();
	      Scene escena = new Scene(root);
	      stage.setScene(escena);
	      LoginController controlador = loader.getController();
	      controlador.setStage(stage);
	      stage.getIcons().add(new Image("images/logo.PNG"));
	      stage.setTitle("AYA Vehiculos");
	      stage.show();
	      
      }
	  	
}