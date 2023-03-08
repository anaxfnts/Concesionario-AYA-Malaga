package daos;

import java.util.List;

import org.hibernate.Session;

import interfaces.VehiculoI;

import concesionarioModels.Vehiculo;

public class VehiculoDAO extends ComunesDAO<Vehiculo> implements VehiculoI {

  // Session de la base de datos
  private Session sesion;

  public VehiculoDAO(Session session) {
    super(session);
    this.sesion = session;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Vehiculo> consultaColumna(String columna) {

    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }
    return sesion.createQuery("SELECT v." + columna + " FROM Vehiculo v").list();
  }

  //Consulta que muestra el precio
  @SuppressWarnings("unchecked")
  @Override
  public List<Vehiculo> consultarPrecio(char comparacion, int precio) {

    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }

    return sesion.createQuery("FROM Vehiculo v WHERE  v.precio '" + comparacion + "' " + precio + "").list();
  }

  //Consulta que muestra el precio entre 2
  @SuppressWarnings("unchecked")
  @Override
  public List<Vehiculo> consultarPrecioEntre(double precio1, double precio2) {

    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }

    return sesion.createQuery("FROM Vehiculo v WHERE v.precio BETWEEN " + precio1 + " AND " + precio2 + "").list();
  }

  @Override
  public Vehiculo filtrarPorColumnaYValor(String columna, String valor) {

    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }

    return (Vehiculo) sesion.createQuery("FROM Vehiculo v WHERE v." + columna + "= '" + valor + "'").uniqueResult();
  }

  //Consulta que muestra el stock de vehiculos
  @Override
  public int stockVehiculos(String modelo) {
    if (!sesion.getTransaction().isActive()) {
      sesion.beginTransaction();
    }

    return (int) sesion.createQuery("SELECT COUNT(v.modelo) FROM Vehiculo v GROUP BY v.modelo").uniqueResult();
  }
  
  
}
