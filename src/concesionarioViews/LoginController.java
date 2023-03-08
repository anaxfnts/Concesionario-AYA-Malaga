package concesionarioViews;

import java.awt.Desktop;
import java.awt.Label;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.HashPassword;
import concesionarioModels.Empleados;
import concesionarioModels.HibernateUtil;
import daos.EmpleadosDAO;

public class LoginController implements Initializable {

	private Session sesion = HibernateUtil.getSession();
	EmpleadosDAO gestorEmpleados = new EmpleadosDAO(sesion);
	
	public static BorderPane root;
	private Stage stage;

	//Todos los elementos del login
	@FXML
	private Button btnCancel;

	@FXML
	private Button btnLogin;

	@FXML
	private ImageView facebook;

	@FXML
	private ImageView instagram;

	@FXML
	private ImageView twitter;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private TextField txtUser;
	
	@FXML
	private Label txtCargo;
	
	public static Empleados comprobar;
	

	//Metodo que realiza y comprueba el login del empleado
	@FXML
	void logeo(MouseEvent event) throws IOException {

		String nombre = txtUser.getText();
		String passwd = txtPassword.getText();
		boolean registrado = false;
		String hasPass = HashPassword.convertirSHA256(passwd);
		System.out.println(hasPass);
		System.out.println(txtPassword.getText());
	
		try {
		  //Comprueba que la psswd y usename del empleado coinciden
			comprobar = gestorEmpleados.empleadoDepartamentoLogin("MECANICOS", HashPassword.convertirSHA256(passwd));
			System.out.println(comprobar.toString());
			if (comprobar.getNombre().equalsIgnoreCase(nombre)
					&& comprobar.getContrase�a().equals(hasPass)) {

				registrado = true;

			}
		
		} catch (NullPointerException e) {
		  //Si no son los datos del empleado correctos, muestra una alerta de error
			alertaError();
		}

			

		if (registrado == true) {
		  //Si coinciden los datos, inicia la principal view
			FXMLLoader loade = new FXMLLoader(getClass().getResource("/concesionarioViews/PrincipalView.fxml"));
			root = loade.load();
			PrincipalController control = loade.getController();
			Scene escena = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(escena);
			control.init(stage, this, txtUser.getText(), root, comprobar.getCargo(), comprobar.getImagenEmpleado());
			stage.show();
			this.stage.close();
			
		}

	}

	//Metodo para salir de la aplicacion
	@FXML
	void salir(MouseEvent event) {
		Platform.exit();
	}

	//Metodo para dirigirse a la web de Facebook
	@FXML
	void webFacebook(MouseEvent event) {
		URL url = null;
		try {
			url = new URL("https://es-es.facebook.com/");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}
	
//Metodo para dirigirse a la web de Instagram
	@FXML
	void webInstagram(MouseEvent event) {
		URL url = null;
		try {
			url = new URL("http://instagram.com/");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

//Metodo para dirigirse a la web de Twitter
	@FXML
	void webTwitter(MouseEvent event) {
		URL url = null;
		try {
			url = new URL("https://twitter.com/?lang=es");
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}

	//Metodo que muestra la alerta de error
	public static void alertaError() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText("Usuario incorrecto");
		alert.showAndWait();

	}

	public void setStage(Stage primaryStage) {
		stage = primaryStage;

	}

	//Inicializa
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtUser.setText("LUIS");
		txtPassword.setText("passLuis");

	}

}
