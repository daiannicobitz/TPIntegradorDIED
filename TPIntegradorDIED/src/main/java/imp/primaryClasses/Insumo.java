package imp.primaryClasses;

import imp.enumerators.UM;

public class Insumo {
		
		private String descripcion;
		private UM unidadMedida;
		private double costoUnitario;
		private double cantidad;
		
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

		public Insumo(String descripcion, UM unidadMedida, double costoUnitario, double cantidad) {
			super();
			setDescripcion(descripcion);
			setUnidadMedida(unidadMedida);
			setCantidad(cantidad);
			setCostoUnitario(costoUnitario);
		}
		
		
		
		
}
