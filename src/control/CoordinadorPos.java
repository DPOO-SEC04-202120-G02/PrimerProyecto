package control;

import modelo.ControladorCliente;

public class CoordinadorPos {
	
	ControladorCliente ctrl_cliente;
	
	public CoordinadorPos() {
		ctrl_cliente=new ControladorCliente();
	}
	
	public void registrarCliente(int cedula_new, int edad_new, String sexo_new, String Estado_new, String Empleo_new) {
		ctrl_cliente.registrarCliente(cedula_new, edad_new, sexo_new, Estado_new, Empleo_new);
	}
	
	public void cargarClientes() {
		ctrl_cliente.CargarClientes();
	}
	
}
