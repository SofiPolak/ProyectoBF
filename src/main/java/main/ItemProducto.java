package main;

public class ItemProducto extends Item{
	
	private static final double PORC_INCREMENTO = 2;
	private boolean garantia;
	private int aniosGarantia;

	public ItemProducto(String nombre, double montoBase, boolean garantia, int anios) {
		super(nombre, montoBase);
		this.garantia = garantia;
		this.aniosGarantia = anios;
	}

	public static double getPorcIncremento() {
		return PORC_INCREMENTO;
	}

	public boolean isGarantia() {
		return garantia;
	}

	public int getAniosGarantia() {
		return aniosGarantia;
	}
	
	

}
