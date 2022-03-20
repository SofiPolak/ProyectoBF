package main;

public class ItemServicio extends Item{
	
	private boolean activo;
	private boolean soporte;

	public ItemServicio(String nombre, double montoBase, boolean activo, boolean soporte) {
		super(nombre, montoBase);
		this.activo = activo;
		this.soporte = soporte;
	}

	public boolean isActivo() {
		return activo;
	}

	public boolean isSoporte() {
		return soporte;
	}
	
	

}
