package imp.primaryClasses;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import imp.DAOs.DAOCamion;

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
		
		
		public void EditarCamion(String patente, String costoHora, String costoKm, String fechacompra, String kmRecorridos, String marca, String modelo) {
			
			if(patente != null && patente != "") {
				setPatente(patente);
				
			}
			if(costoHora != null && costoHora != "") {
				setCostoHora(Double.parseDouble(costoHora));
				
			}
			if(costoKm != null && costoKm != "") {
				setCostoKm(Double.parseDouble(costoKm));
				
			}
			if(fechacompra != null && fechacompra != "") {
				Date fechaCompra = null;
				
				try {
					
					fechaCompra = new SimpleDateFormat("dd/MM/yyyy").parse(fechacompra);
					
					setFechacompra(fechaCompra);
				
				}catch (ParseException e) {

					//e.printStackTrace();
				}
				
			}
			
			if(kmRecorridos != null && kmRecorridos != "") {
				setKmRecorridos(Double.parseDouble(kmRecorridos));
				
			}
			
			if(marca != null && marca != "") {
				setMarca(marca);				
			}
			
			if(modelo != null && modelo != "") {
				setModelo(modelo);				
			}
			
		}

		
		public void BajaCamion() {
			
			DAOCamion.EliminarCamion(this);
		
		}
		
		public void buscarCamion(String patente, String costoHora, String costoKm, String fechacompra, String kmRecorridos, String marca, String modelo) {
			Date fechaCompra = null;
			try {
				
				fechaCompra = new SimpleDateFormat("dd/MM/yyyy").parse(fechacompra);
				
			
			}catch (ParseException e) {

				//e.printStackTrace();
			}
			
			Camion camion = new Camion( patente, Double.parseDouble(kmRecorridos),  marca,  modelo, Double.parseDouble(costoKm), Double.parseDouble(costoHora), fechaCompra);
			
			DAOCamion.BuscarCamion(camion);
			
		}
		
		
}
