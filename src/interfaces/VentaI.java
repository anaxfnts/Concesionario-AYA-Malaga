package interfaces;

import java.util.List;

import concesionarioModels.Venta;

public interface VentaI {
  
  //Metodos de las ventas

	List<Venta> ventasPorCliente(String nombreCliente);

	List<Venta> ventaPorEmpleado(String nombreEmpleado);

	List<Venta> ventaPorMarcaOModelo(String valor);

	Venta ventaPorId(int id);

	List<Venta> ventasPorFecha(String fecha);
}
