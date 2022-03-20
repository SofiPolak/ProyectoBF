package main;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	private int numero;
	private Date fecha;
	private ArrayList<Item> items;
	
	public Pedido(int numero, Date fecha) {
		this.fecha = fecha;
		this.numero = numero;
		this.items = new ArrayList<Item>();
	}

	public int getNumero() {
		return numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
