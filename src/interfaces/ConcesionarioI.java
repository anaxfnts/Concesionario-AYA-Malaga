package interfaces;

import concesionarioModels.Concesionario;

public interface ConcesionarioI {
  
  //Metodos del Concesionario

	Concesionario buscarPorNombre(String nombre);

	Concesionario buscarPorId(int id);

	Concesionario buscarPorLocalidad(String localidad);

	Concesionario buscarPorNif(String nif);

}
