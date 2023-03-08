package interfaces;

import java.util.List;

import concesionarioModels.Reparacion;

public interface ReparacionI {
  
  //Metodos de todas las reparaciones

	List<Reparacion> buscarPorID(String id);
	
	List<Reparacion> buscarMatricula(String matricula);
	
	List<Reparacion> listaReparaciones();
	
	
}
