package daos;

import java.util.List;

import org.hibernate.Session;

import interfaces.VentaI;
import concesionarioModels.Venta;

public class VentaDAO extends ComunesDAO<Venta> implements VentaI {

	private Session sesion;

	public VentaDAO(Session session) {
		super(session);
		this.sesion = session;
	}

	//Consulta que muestra ventas por cliente
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventasPorCliente(String nombreCliente) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Venta v WHERE v.nombreCliente = '" + nombreCliente + "'").list();
	}

	//Consulta que muestra las ventas por empleado
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventaPorEmpleado(String nombreEmpleado) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Venta v WHERE v.nombreEmpleado = '" + nombreEmpleado + "'").list();
	}
	
	
//Consulta que muestra las ventas por marca o modelo
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventaPorMarcaOModelo(String valor) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion
				.createQuery(
						"FROM Venta v WHERE v.marcaVehiculo = '" + valor + "' OR v.modeloVehiculo= '" + valor + "' ")
				.list();
	}

	//Consulta que muestra las ventas por id
	@Override
	public Venta ventaPorId(int id) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return (Venta) sesion.createQuery("FROM Venta v WHERE v.id = " + id + "").uniqueResult();
	}

	//Consulta que muestra las ventas por fecha
	@SuppressWarnings("unchecked")
	@Override
	public List<Venta> ventasPorFecha(String fecha) {

		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Venta v WHERE v.fechaVenta = '" + fecha + "'").list();
	}

}
