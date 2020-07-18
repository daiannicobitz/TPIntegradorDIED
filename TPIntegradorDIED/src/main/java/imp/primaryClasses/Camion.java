package imp.primaryClasses;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		private Date fechacompra;
		
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
		
		public Date getFechacompra() {
			return fechacompra;
		}
		
		private void setFechacompra(Date fechacompra) {
			this.fechacompra = fechacompra;
		}

		public double getId() {
			return id;
		}
		
		private void setId(int id) {
			// TODO Auto-generated method stub
			this.id= id;
		}
		
		private Camion(String patente, double kmRecorridos, String marca, String modelo, double costoKm,
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
		
		private Camion(int id, String patente, double kmRecorridos, String marca, String modelo, double costoKm,
				double costoHora, Date fechacompra) {
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
		
		//AltaCamion retorna un arreglo de dos objetos, el primero es el camion y el segundo es un string que dice 
		//si ese camion ya existía o no y fue creado ahora
		public Object[] AltaCamion(String patente, double kmRecorridos, String marca, String modelo, double costoKm, double costoHora, Date fechacompra) {
		
			Object retorno[] = new Object[2];
				
		ArrayList<Camion> lista = BuscarCamion(patente, null, null, null, null, null, null);
		
			if(lista.size() > 0) {
				
				Camion c1 = lista.get(0);
				retorno[0] = c1;
				retorno[1] = "existe";
				return retorno;
			
			} else {
				
				Camion c1 = new Camion(patente, kmRecorridos, marca, modelo, costoKm, costoHora, fechacompra);
				DAOCamion.GuardarCamion(c1);
				retorno[0] = c1;
				retorno[1] = "creado";
				return retorno;
				
			}
			
			
		}
		
		//EditarCamion recibe todos los campos posibles a editar de un camion y evalua cual de todos se quieren 
		//modificar, al final se llama al DAO y se actualiza en la base de datos
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
			
			
			DAOCamion.actualizarCamion(this);
		}

		//BajaCamion llama al DAO y elimina al camion de la base de datos
		public void BajaCamion() {
			
			DAOCamion.EliminarCamion(this);
		
		}
		
		//BuscarCamion recibe todos los atributos posibles de busqueda y crea un camionDTO con esos atributos, 
		//luego llama al DAO y busca el camion en la BDD, la busqueda retorna un ArrayList con todos los camiones que se 
		//encontraron
		public ArrayList<Camion> BuscarCamion(String patente, String costoHora, String costoKm, String fechacompra, String kmRecorridos, String marca, String modelo) {
			
			Date fechaCompra = null;
			try {
				
				fechaCompra = new SimpleDateFormat("dd/MM/yyyy").parse(fechacompra);
				
			}catch (ParseException e) {

				//e.printStackTrace();
			}
			
			CamionDTO camion = new CamionDTO( patente, kmRecorridos,  marca,  modelo, costoKm, costoHora, fechaCompra);
			
			
			ArrayList<Camion> listaCamiones = DAOCamion.BuscarCamion(camion);
			
			return listaCamiones;
		}
		
		
}
