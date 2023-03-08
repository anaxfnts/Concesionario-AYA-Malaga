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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

  //Mapeo de todos los atributos de Propuesta
@Entity
@Table(name = "Propuesta")
public class Propuesta implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPropuesta;
	@Column
	private String nombreCliente;
	@Column
	private String fecharPropuesta;
	@Column
	private String nombreEmpleado;
	@Column
	private double precioPorpuesta;
	@Column
	private String marcaVehiculo;
	@Column
	private String modeloVehiculo;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Empleados empleado;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name = "vehiculo")
	private Vehiculo vehiculo;

	@Column
	private String estado;
	
	
	//Creamos contructores uno vac�o y otro con todos los atributos
	public Propuesta() {
	
	}

	public Propuesta(String nombreCliente, String fecharPropuesta, String nombreEmpleado, double precioPorpuesta,
			String estado, String marcaVehiculo, String modeloVehiculo) {
		super();

		this.nombreCliente = nombreCliente;
		this.fecharPropuesta = fecharPropuesta;
		this.nombreEmpleado = nombreEmpleado;
		this.precioPorpuesta = precioPorpuesta;
		this.estado = estado;
		this.marcaVehiculo = marcaVehiculo;
		this.modeloVehiculo = modeloVehiculo;
	}
	
	//Creamos Getters y Setters de todos los atributos

	public int getIdPropuesta() {
		return idPropuesta;
	}

	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFecharPropuesta() {
		return fecharPropuesta;
	}

	public void setFecharPropuesta(String fecharPropuesta) {
		this.fecharPropuesta = fecharPropuesta;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public double getPrecioPorpuesta() {
		return precioPorpuesta;
	}

	public void setPrecioPorpuesta(double precioPorpuesta) {
		this.precioPorpuesta = precioPorpuesta;
	}

	public Empleados getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	//Creamos toString
	@Override
	public String toString() {
		return "Propuesta [idPropuesta=" + idPropuesta + ", nombreCliente=" + nombreCliente + ", fecharPropuesta="
				+ fecharPropuesta + ", nombreEmpleado=" + nombreEmpleado + ", precioPorpuesta=" + precioPorpuesta
				+ ", estado=" + estado + "]";
	}

}
