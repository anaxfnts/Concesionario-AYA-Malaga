package daos;

import java.util.List;

import org.hibernate.Session;

import interfaces.ClienteI;
import concesionarioModels.Cliente;
import concesionarioModels.Empleados;

public class ClienteDAO extends ComunesDAO<Cliente> implements ClienteI {

	private Session sesion;

	public ClienteDAO(Session session) {
		super(session);
		this.sesion = session;
	}

	//Consulta que muestra todos los Clientes
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listaClientes() {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Cliente").list();
	}

	//Consulta que busca los Clientes segun el DNI
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorDni(String dni) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Cliente e WHERE e.dni = '" + dni + "'").list();
	}
	
	//Consulta que busca los Clientes segun el nombre
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorNombre(String valor) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Cliente e WHERE e.nombre = '" + valor + "'")
				.list();
	}
	
	//Consulta que busca los Clientes por Apellidos
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorApellidos(String valor) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Cliente e WHERE e.apellidos LIKE '%" + valor + "%'").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarClientePorColumna(String columna) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Cliente e WHERE e." + columna + "").list();
	}

	//Consulta que busca Clientes por DNI
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorID(String id) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Cliente e WHERE e.idCliente = '" + id + "'").list();
	}

}
