package interfaces;

import java.util.List;

import concesionarioModels.Reparacion;
import concesionarioModels.Vehiculo;

public interface ReparacionDisponibleI {
  
  //Metodos de las reparaciones disponibles
	
List<Reparacion> buscarPorID(String id);
	
	List<Reparacion> buscarMatricula(String matricula);
	
	List<Reparacion> listaReparaciones();
	
	List<Reparacion> estadoDisponibleYAsignada(String nombre);
	
	List<Reparacion> estadoFinalizadas(String nombre);

  Vehiculo buscarMatriculaVehiculo(String matricula);
	

}
