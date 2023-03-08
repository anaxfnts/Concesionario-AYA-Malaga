package interfaces;

import java.util.List;

import concesionarioModels.Cliente;

public interface ClienteI {
  
  //Metodos de los Clientes

	List<Cliente> listaClientes();

	List<Cliente> buscarPorDni(String dni);

	List<Cliente> buscarPorApellidos(String valor);
	
	List<Cliente> buscarPorNombre(String valor);

	List<Cliente> buscarPorID(String id);

	List<Cliente> listarClientePorColumna(String columna);

}
