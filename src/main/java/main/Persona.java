package main;

import java.util.ArrayList;

public class Persona {
	
	private String nombrePersona;
	private String apellidoPersona;
	private int dniPersona;
	private ArrayList<Pedido> pedidos;
	private ArrayList<ItemServicio> servicios;
	
	public Persona(String nombre, String apellido, int dni) {
		this.nombrePersona = nombre;
		this.apellidoPersona = apellido;
		this.dniPersona = dni;
		this.pedidos = new ArrayList<Pedido>();
		this.servicios = new ArrayList<ItemServicio>();
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public String getApellidoPersona() {
		return apellidoPersona;
	}

	public int getDniPersona() {
		return dniPersona;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public ArrayList<ItemServicio> getServicios() {
		return servicios;
	}

	
}
