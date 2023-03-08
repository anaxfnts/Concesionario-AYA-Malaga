package concesionarioModels;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//Mapeo de todos los atributos de Reparacion
@Entity
@Table(name = "Reparacion")
public class Reparacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReparacion;

	@Column
	private String nombreCliente;

	@Column
	private String marca;

	@Column
	private String modelo;

	@Column
	private String pieza;

	@Column
	private String tiempo;

	@Column
	private double coste;

	@Column
	private String nombreMecanico;

	@Column
	private String matricula;

	@ManyToOne()
	@JoinColumn(name = "empleado")
	private Empleados empleado;

	@Column
	private String imagen;

	@Column
	private String estado;
	
	@Column
	private String estado_reparacion;

	@OneToOne
	@JoinColumn
	private Vehiculo vehiculo;

	@Column
	private String fecha;
	
	
	//Creamos constructor vacio y otro con todos los atributos
	public Reparacion() {

	}

	public Reparacion(String nombreCliente, String marca, String modelo, String pieza, String tiempo,
			double coste, String nombreMecanico, String matricula, String imagen, String estado, String estado_reparacion, String fecha) {
		super();
		
		this.nombreCliente = nombreCliente;
		this.marca = marca;
		this.modelo = modelo;
		this.pieza = pieza;
		this.tiempo = tiempo;
		this.coste = coste;
		this.nombreMecanico = nombreMecanico;
		this.matricula = matricula;
		this.imagen = imagen;
		this.estado = estado;
		this.estado_reparacion = estado_reparacion;
		this.fecha = fecha;
	}
	
	
//Creamos Getters y Setters de todos los atributos
	public int getIdReparacion() {
		return idReparacion;
	}

	public void setIdReparacion(int idReparacion) {
		this.idReparacion = idReparacion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPieza() {
		return pieza;
	}

	public void setPieza(String pieza) {
		this.pieza = pieza;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	public String getEstado_reparacion() {
		return estado_reparacion;
	}

	public void setEstado_reparacion(String estado_reparacion) {
		this.estado_reparacion = estado_reparacion;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public String getNombreMecanico() {
		return nombreMecanico;
	}

	public void setNombreMecanico(String nombreMecanico) {
		this.nombreMecanico = nombreMecanico;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//toString de todos los atributos
	@Override
	public String toString() {
		return "Reparacion [idReparacion=" + idReparacion + ", nombreCliente=" + nombreCliente + ", marca=" + marca
				+ ", modelo=" + modelo + ", pieza=" + pieza + ", tiempo=" + tiempo + ", coste=" + coste
				+ ", nombreMecanico=" + nombreMecanico + ", matricula=" + matricula + ", empleado=" + empleado
				+ ", imagen=" + imagen + ", estado=" + estado + ", vehiculo=" + vehiculo + ", fecha=" + fecha + "]";
	}

	
	
}
