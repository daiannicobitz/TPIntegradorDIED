package imp.primaryClasses;

import imp.enumerators.UM;

public class InsumoGeneral extends Insumo {
	
	private double peso;
	

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
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public InsumoGeneral(String descripcion, UM unidadMedida, double costoUnitario, double cantidad,double peso) {
		super(descripcion, unidadMedida, costoUnitario, cantidad);
		this.peso=peso;
	}

	
}
