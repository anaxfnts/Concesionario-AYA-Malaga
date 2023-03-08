package interfaces;

import java.util.List;

import concesionarioModels.Propuesta;

public interface PropuestaI {
  
  //Metodos de las Propuestas

	List<Propuesta> propuestasPorNombreCliente(String nombre);

	List<Propuesta> propuestasPorNombreEmpleado(String nombre);

	List<Propuesta> propuestasPorMarcaOModelo(String valor);

	List<Propuesta> propuestasPorEstado(String valor);

	Propuesta propuestaPorId(int id);

}
