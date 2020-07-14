package imp.primaryClasses;

import imp.enumerators.UM;

public abstract class Insumo {
		
		protected String descripcion;
		protected UM unidadMedida;
		protected double costoUnitario;
		protected double cantidad;
		
		
		public Insumo(String descripcion, UM unidadMedida, double costoUnitario, double cantidad) {
			super();
			this.descripcion = descripcion;
			this.unidadMedida = unidadMedida;
			this.costoUnitario = costoUnitario;
			this.cantidad = cantidad;
		}
			
}
