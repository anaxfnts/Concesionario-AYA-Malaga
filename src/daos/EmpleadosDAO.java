package daos;

import java.util.List;

import org.hibernate.Session;

import interfaces.EmpleadosI;
import utils.HashPassword;
import concesionarioModels.HibernateUtil;
import concesionarioModels.Empleados;

public class EmpleadosDAO extends ComunesDAO<Empleados> implements EmpleadosI {

	private Session sesion;

	public EmpleadosDAO(Session session) {
		super(session);
		this.sesion = session;
	}
	//Consulta que busca empleado segun el departamento
	@Override
	public Empleados empleadoDepartamentoLogin(String departamento, String password) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return (Empleados) sesion
				.createQuery(
						"FROM Empleados e WHERE e.departamento = '" + departamento + "' AND e.contraseña = '" + password + "'")
				.uniqueResult();

	}
	//Consulta que busca el tipo de empleado
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> EmpleadoTipo(String tipo) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Empleados e WHERE e.tipoEmpleado = '" + tipo + "'").list();

	}

	//Consulta que busca por nombre y apellidos 
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> consultarNombreOApellidos(String valor) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Empleados e WHERE e.nombre = '" + valor + " OR e.apellidos LIKE '%" + valor + "%''")
				.list();
	}

	@Override
	public Empleados buscarUnEmpleadoPorColumnaYValor(String columna, String valor) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}
		return (Empleados) sesion.createQuery("FROM Empleados e WHERE e." + columna + " = '" + valor + "' ").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleados> listarEmpleadoPorColumna(String columna) {
		if (!sesion.getTransaction().isActive()) {
			sesion.beginTransaction();
		}

		return sesion.createQuery("FROM Empleados e WHERE e." + columna + "").list();
	}

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSession();
		EmpleadosDAO ee = new EmpleadosDAO(sesion);

		Empleados e = ee.empleadoDepartamentoLogin("MECANICOS", HashPassword.convertirSHA256("passLuis"));
		System.out.println(e.toString());

	}
}
