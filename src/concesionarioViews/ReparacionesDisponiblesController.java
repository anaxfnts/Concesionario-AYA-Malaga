package concesionarioViews;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.MessagingException;

import org.hibernate.Session;

import concesionarioModels.Cliente;
import concesionarioModels.Emails;
import concesionarioModels.HibernateUtil;
import concesionarioModels.Reparacion;
import concesionarioModels.Vehiculo;
import daos.EmpleadosDAO;
import daos.ReparacionDisponibleDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class ReparacionesDisponiblesController implements Initializable {

  private Session sesion = HibernateUtil.getSession();
  EmpleadosDAO gestorEmpleados = new EmpleadosDAO(sesion);
  ReparacionDisponibleDAO gestorReparacion = new ReparacionDisponibleDAO(sesion);
  private Reparacion reparacion = null;
  private Vehiculo vehiculo = null;
  private Cliente cliente;

  //Todos los elementos 
  @FXML
  private Label lblID;

  @FXML
  private Label correoElectronico;

  @FXML
  private Label estado_reparacion;

  @FXML
  private Button btnMarcarReparacionFinalizada;

  @FXML
  private Button btnEnviarEmailCliente;

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

  //Setea los datos necesarios de cada reparacion
  public void setDatos(Reparacion reparaciones, Vehiculo vehiculos) throws FileNotFoundException {
    reparacion = reparaciones;
    vehiculo = vehiculos;
    lblID.setText(String.valueOf(reparaciones.getIdReparacion()));
    estado_reparacion.setText(String.valueOf(reparaciones.getEstado_reparacion()));
    txtVehiculoMatricula.setText(reparaciones.getMatricula());
    txtVehiculoPieza.setText(reparaciones.getPieza());
    txtNombreCliente.setText(String.valueOf(reparaciones.getNombreCliente()));
    txtVehiculoCoste.setText(String.valueOf(reparaciones.getCoste()));
    txtFecha.setText(String.valueOf(reparaciones.getFecha()));
    txtMarca.setText(String.valueOf(reparaciones.getMarca()));
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

  //Metodo que actualiza el estado de una reparacion DISPONIBLE A FINALIZADA
  @FXML
  void actualizarEstado(MouseEvent event) throws IOException {

    reparacion.setEstado("FINALIZADA");
    gestorReparacion.update(reparacion);
    actualizarVista();

  }

  //Metodo que permite enviar un email al cliente 
  @FXML
  void enviarEmailCliente(MouseEvent event) throws IOException, MessagingException {
    Vehiculo vehiculo = gestorReparacion.buscarMatriculaVehiculo(reparacion.getMatricula());
    
    try {
      Emails e = new Emails();
      e.enviar(vehiculo.getCliente().getCorreo_electronico(), "Reparación realizada",
          "Estimado cliente, su reparación está lista, puede pasar a recoger su vehículo. CONCESIONARIO AYA");
      alertaEnviado();
    } catch (Exception e) {
      alertaErrorCorreo();
    }

  }
  //Metodo que muestra una alerta de error cuando no se envia el correo 
  private static void alertaErrorCorreo() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("ERROR");
    alert.setContentText("Correo electrónico no enviado.");
    alert.showAndWait();

  }

  //Metodo que confirma que se ha enviado el correo
  private static void alertaEnviado() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("OPERACIÓN REALIZADA CON ÉXITO");
    alert.setContentText("Correo electrónico enviado.");
    alert.showAndWait();

  }

  //Metodo que actualiza la vista
  private void actualizarVista() throws IOException {

    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/concesionarioViews/ScenaVerReparacionesDisponibles.fxml"));
    AnchorPane root = loader.load();
    LoginController.root.setCenter(root);

  }
}