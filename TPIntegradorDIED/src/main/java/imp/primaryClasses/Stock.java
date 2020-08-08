package imp.primaryClasses;

public class Stock {
		
		private int id;
		private double cantidad;
		private double puntoPedido;
		private int idInsumo;
		private int idPlanta;
		
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
		
		public int getInsumo() {
			return idInsumo;
		}
		
		public void setInsumo(int insumo) {
			this.idInsumo = insumo;
		}

		public Stock(int id, double cantidad, double puntoPedido, int insumo) {
			super();
			setCantidad(cantidad);
			setId(id);
			setInsumo(insumo);
			setPuntoPedido(puntoPedido);
		}

		public Stock() {

		}

		public void setidPlanta(int i) {

			this.idPlanta = i;
			
		}
		
		public int getIdPlanta() {

			return idPlanta;
			
		}
		
		
}
