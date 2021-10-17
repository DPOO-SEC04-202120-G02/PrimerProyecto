package interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import control.CoordinadorPos;

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
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
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

