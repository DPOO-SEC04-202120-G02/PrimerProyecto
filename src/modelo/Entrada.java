package modelo;

public class Entrada {
	
	float precioT;
	String nombre_producto;
	float cantidad_producto;
	int codigo_producto;
	
	public Entrada(float precio, String nombre, float cantidad, int codigo) {
		precioT=precio;
		nombre_producto=nombre;
		cantidad_producto=cantidad;
		codigo_producto=codigo;
	}
	
	float getPrecioT() {
		return precioT;
	}
	String getNombre_producto() {
		return nombre_producto;
	}
	float getCantidad_producto() {
		return cantidad_producto;
	}
	int getCodigo() {
		return codigo_producto;
	}
}
