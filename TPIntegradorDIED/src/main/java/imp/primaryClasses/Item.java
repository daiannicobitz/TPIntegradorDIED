package imp.primaryClasses;

public class Item {

	private int idInsumo;
	private int idOrden;
	private double cantidadSolicitada;
	
	
	public int getIdInsumo() {
		return idInsumo;
	}
	
	public void setIdInsumo(int idInsumo) {
		this.idInsumo = idInsumo;
	}
	
	public int getIdOrden() {
		return idOrden;
	}
	
	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public double getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	
	public void setCantidadSolicitada(double cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Item(int idInsumo, double cantidadSolicitada, int idOrden) {
		super();
		this.idInsumo = idInsumo;
		this.cantidadSolicitada = cantidadSolicitada;
		this.idOrden = idOrden;
	}
	
}
