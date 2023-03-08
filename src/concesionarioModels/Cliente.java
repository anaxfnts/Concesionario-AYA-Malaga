package concesionarioModels;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//Mapeo de todos los atributos de Cliente
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCliente;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column(unique = true)
	private String dni;
	@Column(name = "imagen")
	private String imagenCliente;
	@Column
	private int telefono;
	
	@Column
	private String correo_electronico;

	@OneToMany(mappedBy = "id", cascade = { CascadeType.ALL })
	private Set<Vehiculo> vehiculos;


	//Creamos un Constructor vacío y otro con todos los atributos
	public Cliente() {

	}

	public Cliente(String nombre, String apellidos, String direccion, String dni, String imagenCliente, int telefono, String correo_electronico) {
		super();

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dni = dni;
		this.imagenCliente = imagenCliente;
		this.telefono = telefono;
		this.correo_electronico = correo_electronico;
	}
	
	//Creamos Getters y Setters de todos los atributos de Cliente

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getImagenCliente() {
		return imagenCliente;
	}

	public void setImagenCliente(String imagenCliente) {
		this.imagenCliente = imagenCliente;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	//toString de los atributos
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", dni=" + dni + ", telefono=" + telefono +  ", correo electronico0" + correo_electronico +"]";
	}

}
