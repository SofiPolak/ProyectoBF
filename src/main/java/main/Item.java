package main;

public abstract class Item {
	
	private String nombre;
	private double montoBase;
	
	public Item(String nombre, double montoBase) {
		this.montoBase = montoBase;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public double getMontoBase() {
		return montoBase;
	}
	
	

}
