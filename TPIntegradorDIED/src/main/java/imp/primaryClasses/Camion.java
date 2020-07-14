package imp.primaryClasses;

import java.util.Date;

public class Camion {
	
		private String patente;
		private double kmRecorridos;
		private String marca;
		private String modelo;
		private double costoKm;
		private double costoHora;
		private Date fechacompra;
		
		public String getPatente() {
			return patente;
		}
		
		public void setPatente(String patente) {
			this.patente = patente;
		}
		
		public double getKmRecorridos() {
			return kmRecorridos;
		}
		
		public void setKmRecorridos(double kmRecorridos) {
			this.kmRecorridos = kmRecorridos;
		}
		
		public String getMarca() {
			return marca;
		}
		
		public void setMarca(String marca) {
			this.marca = marca;
		}
		
		public String getModelo() {
			return modelo;
		}
		
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
		public double getCostoKm() {
			return costoKm;
		}
		
		public void setCostoKm(double costoKm) {
			this.costoKm = costoKm;
		}
		
		public double getCostoHora() {
			return costoHora;
		}
		
		public void setCostoHora(double costoHora) {
			this.costoHora = costoHora;
		}
		
		public Date getFechacompra() {
			return fechacompra;
		}
		
		public void setFechacompra(Date fechacompra) {
			this.fechacompra = fechacompra;
		}
		
		public Camion(String patente, double kmRecorridos, String marca, String modelo, double costoKm,
				double costoHora, Date fechacompra) {
			super();
			setPatente(patente);
			setCostoHora(costoHora);
			setCostoKm(costoKm);
			setFechacompra(fechacompra);
			setKmRecorridos(kmRecorridos);
			setMarca(marca);
			setModelo(modelo);
		}

		
		
		
}
