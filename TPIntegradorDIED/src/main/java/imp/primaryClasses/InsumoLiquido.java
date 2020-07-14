package imp.primaryClasses;

import imp.enumerators.UM;

public class InsumoLiquido extends Insumo {
	
	private double densidad;
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UM getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(UM unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
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
