package imp.primaryClasses;

import imp.enumerators.UM;

public class InsumoLiquido extends Insumo {
	
	private double densidad;
	
	
	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}	
	
	public InsumoLiquido(String descripcion, UM unidadMedida, double costoUnitario, double cantidad,double densidad) {
		super(descripcion, unidadMedida, costoUnitario, cantidad);
		this.densidad=densidad;
	}



}
