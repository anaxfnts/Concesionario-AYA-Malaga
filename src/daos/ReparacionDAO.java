package daos;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import interfaces.ReparacionI;

import concesionarioModels.Cliente;
import concesionarioModels.Empleados;
import concesionarioModels.HibernateUtil;
import concesionarioModels.Reparacion;
import concesionarioModels.Vehiculo;

public class ReparacionDAO extends ComunesDAO<Reparacion> implements ReparacionI {
	private Session sesion;

	public ReparacionDAO(Session sesion) {
		super(session);
		this.sesion = sesion;
	}
//Consulta que lista todas las reparaciones
	@SuppressWarnings("unchecked")
	@Override
	public List<Reparacion> listaReparaciones() {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Reparacion").list();
	}
	
	//Consulta que busca las reparaciones segun la matricula
	@SuppressWarnings("unchecked")
	@Override
	public List<Reparacion> buscarMatricula(String matricula) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Reparacion e WHERE e.matricula = '" + matricula + "'").list();
	}

	//Consulta que busca las reparaciones por ID
	@SuppressWarnings("unchecked")
	@Override
	public List<Reparacion> buscarPorID(String id) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return sesion.createQuery("FROM Reparacion e WHERE e.idReparacion = '" + id + "'").list();
	}

}
