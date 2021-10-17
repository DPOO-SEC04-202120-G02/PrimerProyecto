package interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import control.CoordinadorPos;
import modelo.Compra;
import modelo.Entrada;

public class interfazApp {
	
	CoordinadorPos CooPos;
	
	public interfazApp() {
		CooPos = new CoordinadorPos();
	}
	
	
	public void ejecutarAplicacion()
	{
		
		System.out.println("Funcionamiento de Sistemas POS e Inventario\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				// mostrarSistemas_POS_SI_Integrados();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
				if (opcion_seleccionada == 1 && this.CooPos != null)
					registrarCliente();
				else if (opcion_seleccionada == 5 )
				{
					System.out.println("Saliendo de la aplicacion ...");
					continuar = false;
				}else if (opcion_seleccionada == 2 )
				{
					int cedula = Integer.parseInt(input("Cedula del cliente que registra la compra."));
					nuevaCompra(cedula);
					
				}else if (opcion_seleccionada == 3 )
				{	
					System.out.println("Ingrese los datos de la entrada que quiere hacer a su compra.");
					int codigo = Integer.parseInt(input("Codigo del producto que desea comprar: "));
					float cantidad = Float.valueOf(input("Cantidad del producto que desea comprar (si el producto se vende por empaques, se registra el entero más cercano al nuemro ingresado): "));
					nuevaEntrada(codigo,cantidad);
				}else if (opcion_seleccionada == 4 )
				{
					cerrarCompra();
				}
					
				else if (this.CooPos == null)
				{
					System.out.println("Para poder ejecutar esta opcion hay que verificar el inicio del sistema.");
				}
				else
				{
					System.out.println("Por favor seleccione una opcion valida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los nÃºmeros de las opciones.");
			}
		}
	}
	
	public void nuevaEntrada(int codigo, float cantidad) {
		if(CooPos.addEntrada(codigo, cantidad)) {
			System.out.println("Se ha registrado la entrada.");
		}else {
			System.out.println("Cantidad insuficiente en inventario.");
		}
	}
	
	public void nuevaCompra(int cedula) {
		if (CooPos.nuevaCompra(cedula)){
			System.out.println("Se ha iniado una nueva compra para el cliente con cedula "+Integer.toString(cedula));
		}else {
			System.out.println("No se pudó crear. Verifique que la cedula sea correcta y que no hayan compras procesandose actualmente");
		}
	}
	
	public void cerrarCompra() {
		Compra compra=CooPos.cerrarCompra();
		float precio_total=0;
		System.out.printf("%-20s %-20s %-20s %-20s\n","Codigo","Nombre","Cantidad","Costo");
		for (Entrada entrada : compra.getEntradas()) {
			System.out.printf("%-20s %-20s %-20s %-20s\n", entrada.getCodigo(), entrada.getNombre_producto(),entrada.getCantidad_producto(),entrada.getPrecioT());
			precio_total+=entrada.getPrecioT();
		}
		System.out.println("Costo final de la compra: "+String.valueOf(precio_total));
		CooPos.set_compraAC2null();
	}
	
	public void registrarCliente() {
		int cedula_new = Integer.parseInt(input("Cedula del nuevo cliente: "));
		int edad_new = Integer.parseInt(input("Edad del nuevo cliente: "));
		String sexo_new = input("Sexo del nuevo cliente: ");
		String EstadoCivil_new = input("Estado civil del nuevo cliente: ");
		String Empleo_new = input("situacion laboral del nuevo cliente: ");
		CooPos.registrarCliente(cedula_new, edad_new, sexo_new, EstadoCivil_new, Empleo_new);
	}
	
	public void mostrarMenu() {
		System.out.println("\nOpciones del sistema Pos.\n");
		System.out.println("1. Registrar cliente.\n");
		System.out.println("2. Registrar una nueva compra.\n");
		System.out.println("3. Registrar una nueva entrada a la compra actual.\n");
		System.out.println("4. Cerrar la compra actual e imprimir la factura.\n");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		try
		{
			interfazApp consola = new interfazApp();
			consola.ejecutarAplicacion();
		}
		catch (Exception e)
		{
			System.out.println("Problema al crear la consola de la aplicacion: " + e.getMessage() );
		}
	}

}

