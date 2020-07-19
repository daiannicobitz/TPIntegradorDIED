package imp.primaryClasses;

import imp.enumerators.UM;

public class InsumoGeneral extends Insumo {
	
	private double peso;
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public InsumoGeneral(int id, String descripcion, UM unidadMedida, double costoUnitario, double cantidad,double peso) {
		super(id, descripcion, unidadMedida, costoUnitario, cantidad);
		this.peso=peso;
	}

	
}
