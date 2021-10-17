package modelo;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CoordInventario {

	private AdminProductos adminProductos;
	
	public CoordInventario() {
		adminProductos = new AdminProductos();
	}
	
	public void cargarLotes(String nombreArchivo) throws IOException {
		adminProductos.cargarLotes(nombreArchivo);
	}
	
	public Producto consultarInfoProducto(int codigo) {
		return adminProductos.consultarProducto(codigo);
	}
	
	public void eliminarLotesVencidos(int dia, int mes, int a�o) throws FileNotFoundException, IOException {
		Fecha fechaActual = new Fecha(dia, mes, a�o);
		adminProductos.eliminarLotesVencidos(fechaActual);
	}
	
	public float consultarDesempe�oFin(int codigo) {
		Producto producto =  adminProductos.consultarProducto(codigo);
		return producto.getGananciaVenta();
	}
	
	public void cargarProductos() throws FileNotFoundException, ClassNotFoundException, IOException {
		adminProductos.cargarProductos();
	}
		
	public static void main(String[] args) throws IOException {
		CoordInventario inv = new CoordInventario();
		inv.cargarLotes(System.getProperty("user.dir")+"\\EjemploArchInventario.csv");
	}

}