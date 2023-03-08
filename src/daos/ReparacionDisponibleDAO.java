package daos;

import java.util.List;

import org.hibernate.Session;

import concesionarioModels.Reparacion;
import concesionarioModels.Vehiculo;
import interfaces.ReparacionDisponibleI;


public class ReparacionDisponibleDAO extends ComunesDAO<Reparacion> implements ReparacionDisponibleI {
  private Session sesion;

  public ReparacionDisponibleDAO(Session sesion) {
    super(session);
    this.sesion = sesion;
  }

  //Consulta que muestra todas las reparaciones disponibles
  @SuppressWarnings("unchecked")
  @Override
  public List<Reparacion> listaReparaciones() {
    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return sesion.createQuery("FROM Reparacion e WHERE e.estado = 'DISPONIBLE'").list();
  }

  //Consulta que busca las reparaciones segun la matricula
  @SuppressWarnings("unchecked")
  @Override
  public List<Reparacion> buscarMatricula(String matricula) {
    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return sesion.createQuery("FROM Reparacion e WHERE e.estado = 'DISPONIBLE' AND e.matricula = '" + matricula + "'").list();
  }

  //Consulta que busca las reparaciones segun el id
  @SuppressWarnings("unchecked")
  @Override
  public List<Reparacion> buscarPorID(String id) {
    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return sesion.createQuery("FROM Reparacion e WHERE e.estado = 'DISPONIBLE' AND e.idReparacion = '" + id + "'").list();
  }

  //Consulta que actualiza las reparaciones finalizadas 
  @SuppressWarnings("unchecked")
  @Override
  public List<Reparacion> estadoDisponibleYAsignada(String nombre) {
    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return sesion
        .createQuery("FROM Reparacion e WHERE e.estado != 'FINALIZADA' AND e.nombreMecanico = '" + nombre + "'")
        .list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Reparacion> estadoFinalizadas(String nombre) {

    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return sesion
        .createQuery("FROM Reparacion e WHERE e.estado = 'FINALIZADA' AND e.nombreMecanico = '" + nombre + "'")
        .list();
  }
  
  @Override
  public Vehiculo buscarMatriculaVehiculo(String matricula) {
    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return (Vehiculo) sesion.createQuery("FROM Vehiculo v WHERE v.matricula = '" + matricula + "'")
        .uniqueResult();
  }
}
