package interfaces;

import java.util.List;

import concesionarioModels.Empleados;

public interface EmpleadosI {

  //Metodos de los Empleados
	public List<Empleados> EmpleadoTipo(String tipo);

	public List<Empleados> consultarNombreOApellidos(String valor);

	Empleados buscarUnEmpleadoPorColumnaYValor(String columna, String valor);

	List<Empleados> listarEmpleadoPorColumna(String columna);
	
	Empleados empleadoDepartamentoLogin(String departamento,String password);
}
