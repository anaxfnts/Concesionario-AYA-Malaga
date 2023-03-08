package daos;

import java.util.List;

import org.hibernate.Session;

import concesionarioModels.Reparacion;
import interfaces.ReparacionFinalizadaI;

	public class ReparacionFinalizadaDAO extends ComunesDAO<Reparacion> implements ReparacionFinalizadaI {
		private Session sesion;

		public ReparacionFinalizadaDAO(Session sesion) {
			super(session);
			this.sesion = sesion;
		}

		//Consulta que muestra las reparaciones finalizadas
		@SuppressWarnings("unchecked")
		@Override
		public List<Reparacion> listaReparaciones() {
			if (!sesion.getTransaction().isActive()) {
				sesion.beginTransaction();
			}
			return sesion.createQuery("FROM Reparacion e WHERE e.estado = 'FINALIZADA'").list();
		}

		//Consulta que busca las reparaciones segun las matriculas
		@SuppressWarnings("unchecked")
		@Override
		public List<Reparacion> buscarMatricula(String matricula) {
			if (!sesion.getTransaction().isActive()) {
				sesion.beginTransaction();
			}
			return sesion.createQuery("FROM Reparacion e WHERE e.estado = 'FINALIZADA' AND e.matricula = '" + matricula + "'").list();
		}

		//Consulta que busca las reparaciones segun el ID
		@SuppressWarnings("unchecked")
		@Override
		public List<Reparacion> buscarPorID(String id) {
			if (!sesion.getTransaction().isActive()) {
				sesion.beginTransaction();
			}
			return sesion.createQuery("FROM Reparacion e WHERE e.estado = 'FINALIZADA' AND e.idReparacion = '" + id + "'").list();
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Reparacion> estadoFinalizadasYAsignada(String nombre) {
			if (!sesion.getTransaction().isActive()) {
				sesion.beginTransaction();
			}
			return sesion
					.createQuery("FROM Reparacion e WHERE e.estado != 'DISPONIBLE' AND e.nombreMecanico = '" + nombre + "'")
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

	}
