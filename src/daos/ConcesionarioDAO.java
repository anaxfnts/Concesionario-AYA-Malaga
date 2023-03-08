package daos;

import org.hibernate.Session;

import interfaces.ConcesionarioI;
import concesionarioModels.Concesionario;

public class ConcesionarioDAO extends ComunesDAO<Concesionario> implements ConcesionarioI {

	private Session sesion;

	public ConcesionarioDAO(Session session) {
		super(session);
		this.sesion = session;
	}
	
	//Consulta que busca por nombre
	@Override
	public Concesionario buscarPorNombre(String nombre) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		return (Concesionario) sesion.createQuery("FROM Concesionario c WHERE c.nombre = '" + nombre + "'")
				.uniqueResult();
	}
	
	//Consulta que busca por ID
	@Override
	public Concesionario buscarPorId(int id) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		return (Concesionario) sesion.createQuery("FROM Concesionario c WHERE c.idConcesionario = '" + id + "'")
				.uniqueResult();
	}

	//Consulta que busca por localidad
	@Override
	public Concesionario buscarPorLocalidad(String localidad) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		return (Concesionario) sesion.createQuery("FROM Concesionario c WHERE c.localidad = '" + localidad + "'")
				.uniqueResult();
	}
	
	//Consulta que busca por nif
	@Override
	public Concesionario buscarPorNif(String nif) {
		if (!sesion.getTransaction().isActive()) {
			sesion.getTransaction().begin();
		}
		return (Concesionario) sesion.createQuery("FROM Concesionario c WHERE c.nif = '" + nif + "'").uniqueResult();
	}

}
