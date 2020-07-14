package imp.primaryClasses;

public class Item {

	private Insumo insumoSolicitado;
	private double cantidadSolicitada;
	
	
	public Insumo getInsumoSolicitado() {
		return insumoSolicitado;
	}
	
	public void setInsumoSolicitado(Insumo insumoSolicitado) {
		this.insumoSolicitado = insumoSolicitado;
	}
	
	public double getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	
	public void setCantidadSolicitada(double cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Item(Insumo insumoSolicitado, double cantidadSolicitada) {
		super();
		this.insumoSolicitado = insumoSolicitado;
		this.cantidadSolicitada = cantidadSolicitada;
	}
	
}
