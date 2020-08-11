package imp.primaryClasses;

import imp.enumerators.UM;

public class InsumoLiquido extends Insumo {
	
	private double densidad;
	private double peso;
	
	public double getDensidad() {
		return densidad;
	}

	public void setDensidad(double densidad) {
		this.densidad = densidad;
	}	
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public InsumoLiquido(int id,String descripcion, UM unidadMedida, double costoUnitario, double cantidad,double densidad) {
		super(id,descripcion, unidadMedida, costoUnitario, cantidad);
		this.densidad=densidad;
		
		if(this.getUnidadMedida()==UM.L) {
			this.peso=(((InsumoLiquido) this).getDensidad())*0.001;
		}else {
			this.peso=this.getDensidad();
		}
	}
	
	public double pesoPorUnidad() {
		return this.peso;
	}


}
