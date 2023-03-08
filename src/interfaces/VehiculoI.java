package interfaces;

import java.util.List;

import concesionarioModels.Vehiculo;

public interface VehiculoI {
  
  //Metodos de los vehiculos

	List<Vehiculo> consultaColumna(String columna);

	List<Vehiculo> consultarPrecio(char comparacion, int precio);

	List<Vehiculo> consultarPrecioEntre(double precio1, double precio2);

	Vehiculo filtrarPorColumnaYValor(String columna, String valor);

	int stockVehiculos(String modelo);
}
