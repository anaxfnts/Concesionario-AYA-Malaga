package interfaces;

import java.util.List;

import concesionarioModels.Reparacion;

//Metodos de las reparaciones finalizadas
public interface ReparacionFinalizadaI {

		List<Reparacion> buscarPorID(String id);
		
		List<Reparacion> buscarMatricula(String matricula);
		
		List<Reparacion> listaReparaciones();
		
		List<Reparacion> estadoFinalizadas(String nombre);

		List<Reparacion> estadoFinalizadasYAsignada(String nombre);
		
		
	}

