package imp.DTOs;

import java.util.Date;

public class CamionDTO {

	private String patente;
	private String kmRecorridos;
	private String marca;
	private String modelo;
	private String costoKm;
	private String costoHora;
	private Date fechacompra;
	
	public CamionDTO( String patente, String kmRecorridos, String marca, String modelo, String costoKm, String costoHora, Date fechacompra) {
		super();
		this.patente = patente;
		this.kmRecorridos = kmRecorridos;
		this.marca = marca;
		this.modelo = modelo;
		this.costoKm = costoKm;
		this.costoHora = costoHora;
		this.fechacompra = fechacompra;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(String kmRecorridos) {
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

	public String getCostoKm() {
		return costoKm;
	}

	public void setCostoKm(String costoKm) {
		this.costoKm = costoKm;
	}

	public String getCostoHora() {
		return costoHora;
	}

	public void setCostoHora(String costoHora) {
		this.costoHora = costoHora;
	}

	public Date getFechacompra() {
		return fechacompra;
	}

	public void setFechacompra(Date fechacompra) {
		this.fechacompra = fechacompra;
	}
	
	
	
}
