package main;

import java.util.Date;

public class PersonaJuridica extends Persona{
	
	private String razonSocial;
	private Date fechaInicioAct;
	private int cuit;

	public PersonaJuridica(String nombre, String apellido, int dni, String razonSocial, Date fecha, int cuit) {
		super(nombre, apellido, dni);
		this.razonSocial = razonSocial;
		this.fechaInicioAct = fecha;
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public Date getFechaInicioAct() {
		return fechaInicioAct;
	}

	public int getCuit() {
		return cuit;
	}
	
	

}
