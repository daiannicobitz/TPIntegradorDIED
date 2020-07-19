package imp.primaryClasses;

import imp.enumerators.UM;

public abstract class Insumo {
		
	
		protected int id;
		protected String descripcion;
		protected UM unidadMedida;
		protected double costoUnitario;
		protected double cantidad;
		
		
		public Insumo(int id, String descripcion, UM unidadMedida, double costoUnitario, double cantidad) {
			super();
			this.id=id;
			this.descripcion = descripcion;
			this.unidadMedida = unidadMedida;
			this.costoUnitario = costoUnitario;
			this.cantidad = cantidad;
		}
		
		public final int getId() {
			return id;
		}

		public final void setId(int id) {
			this.id = id;
		}
		
		public final String getDescripcion() {
			return descripcion;
		}

		public final void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public final UM getUnidadMedida() {
			return unidadMedida;
		}

		public final void setUnidadMedida(UM unidadMedida) {
			this.unidadMedida = unidadMedida;
		}

		public final double getCostoUnitario() {
			return costoUnitario;
		}

		public final void setCostoUnitario(double costoUnitario) {
			this.costoUnitario = costoUnitario;
		}

		public final double getCantidad() {
			return cantidad;
		}

		public final void setCantidad(double cantidad) {
			this.cantidad = cantidad;
		}
}
