package imp.primaryClasses;




import java.util.ArrayList;

import imp.DAOs.DAOCamion;
import imp.DTOs.CamionDTO;

public class Camion {
	
		private int id;
		private String patente;
		private double kmRecorridos;
		private String marca;
		private String modelo;
		private double costoKm;
		private double costoHora;
		private String fechacompra;
		
		public String getPatente() {
			return patente;
		}
		
		private void setPatente(String patente) {
			this.patente = patente;
		}
		
		public double getKmRecorridos() {
			return kmRecorridos;
		}
		
		private void setKmRecorridos(double kmRecorridos) {
			this.kmRecorridos = kmRecorridos;
		}
		
		public String getMarca() {
			return marca;
		}
		
		private void setMarca(String marca) {
			this.marca = marca;
		}
		
		public String getModelo() {
			return modelo;
		}
		
		private void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
		public double getCostoKm() {
			return costoKm;
		}
		
		private void setCostoKm(double costoKm) {
			this.costoKm = costoKm;
		}
		
		public double getCostoHora() {
			return costoHora;
		}
		
		private void setCostoHora(double costoHora) {
			this.costoHora = costoHora;
		}
		
		public String getFechacompra() {
			return fechacompra;
		}
		
		private void setFechacompra(String fechacompra) {
			this.fechacompra = fechacompra;
		}

		public int getId() {
			return id;
		}
		
		private void setId(int id) {
			// TODO Auto-generated method stub
			this.id= id;
		}
		
		public Camion(String patente, double kmRecorridos, String marca, String modelo, double costoKm,
				double costoHora, String fechacompra) {
			super();
			setPatente(patente);
			setCostoHora(costoHora);
			setCostoKm(costoKm);
			setFechacompra(fechacompra);
			setKmRecorridos(kmRecorridos);
			setMarca(marca);
			setModelo(modelo);
		}
		
		public Camion(int id, String patente, double kmRecorridos, String marca, String modelo, double costoKm,
				double costoHora, String fechacompra) {
			super();
			setId(id);
			setPatente(patente);
			setCostoHora(costoHora);
			setCostoKm(costoKm);
			setFechacompra(fechacompra);
			setKmRecorridos(kmRecorridos);
			setMarca(marca);
			setModelo(modelo);
		}
		
		public Camion() {
			
		};
		
		//EditarCamion recibe todos los campos posibles a editar de un camion y evalua cual de todos se quieren 
		//modificar, al final se llama al DAO y se actualiza en la base de datos
		public void EditarCamion(String patente, String costoHora, String costoKm, String fechacompra, String kmRecorridos, String marca, String modelo) {
			
				setPatente(patente);
				setCostoHora(Double.parseDouble(costoHora));
				setCostoKm(Double.parseDouble(costoKm));
				setFechacompra(fechacompra);
				setKmRecorridos(Double.parseDouble(kmRecorridos));
				setMarca(marca);				
				setModelo(modelo);				
			
			DAOCamion.actualizarCamion(this.CrearDTOCamion());
		}

		private CamionDTO CrearDTOCamion() {
			
			CamionDTO camion = new CamionDTO(Integer.toString(this.getId()), this.getPatente(), Double.toString(this.getKmRecorridos()), this.getMarca(), this.getModelo(), Double.toString(this.getCostoKm()), Double.toString(this.getCostoHora()), this.getFechacompra());
			
			return camion;
		}
		
		//BajaCamion llama al DAO y elimina al camion de la base de datos
		public void BajaCamion() {

			DAOCamion.EliminarCamion(this);
		
		}
		
		public boolean equals(Camion c1) {
			if(this.getPatente().equals(c1.getPatente())) {
				return true;
			} else return false;
		}
		
		public String toString() {
			return this.getPatente();
		}
}
