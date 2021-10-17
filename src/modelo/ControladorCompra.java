package modelo;

public class ControladorCompra {
	
	Compra compra_actual;
	
	public ControladorCompra() {
		compra_actual= null;
	}

	public void addEntrada(int codigo, float cantidad) {
		//Se necesita el adminProductos para implementar esta funcionalidad.
	}
	
	public void nuevaCompra(Cliente cliente_n) {
		if (compra_actual!=null) {
			System.out.println("Es necesario que cierre la compra actual antes de iniciar otra.");
		}else{
			compra_actual= new Compra(cliente_n);
			System.out.println("Se ha iniado una nueva compra para el cliente con cedula "+Integer.toString(cliente_n.getCedula()));
		}
	}
	
	public Compra cerrarCompra() {//Se retorna la compra y se marca que no hay compras porcesandose.
		Compra c= compra_actual;
		compra_actual=null;
		return c;
	}
}
