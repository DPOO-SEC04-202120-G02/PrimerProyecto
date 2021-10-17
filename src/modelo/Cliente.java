package modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
	private int puntos;
	private int cedula;
	private int edad;
	private String sexo;
	private String estadoCivil;
	private String situacionLaboral;
	
	public Cliente(int cedula, int edad, String sexo, String estadoCivil, String situacionLaboral) {
		this.cedula = cedula;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.situacionLaboral = situacionLaboral;
		this.puntos=0;//Todos los clientes se crean con 0 puntos.
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void sumarPuntos(int cantidad) {
		puntos += cantidad;
	}
	
	public int getCedula() {
		return cedula;
	}
	
	
	

}
