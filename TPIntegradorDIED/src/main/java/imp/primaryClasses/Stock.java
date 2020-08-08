package imp.primaryClasses;

public class Stock {
		
		private int id;
		private int idPlanta;
		private double cantidad;
		private double puntoPedido;
		private Insumo insumo;
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public double getCantidad() {
			return cantidad;
		}
		
		public void setCantidad(double cantidad) {
			this.cantidad = cantidad;
		}
		
		public double getPuntoPedido() {
			return puntoPedido;
		}
		
		public void setPuntoPedido(double puntoPedido) {
			this.puntoPedido = puntoPedido;
		}
		
		public Insumo getInsumo() {
			return insumo;
		}
		
		public void setInsumo(Insumo insumo) {
			this.insumo = insumo;
		}

		public Stock(int id, int idPlanta, double cantidad, double puntoPedido, Insumo insumo) {
			super();
			setCantidad(cantidad);
			setId(id);
			setInsumo(insumo);
			setPuntoPedido(puntoPedido);
			setIdPlanta(idPlanta);
		}

		public int getIdPlanta() {
			return idPlanta;
		}

		public void setIdPlanta(int idPlanta) {
			this.idPlanta = idPlanta;
		}


		
		
		
		
}
