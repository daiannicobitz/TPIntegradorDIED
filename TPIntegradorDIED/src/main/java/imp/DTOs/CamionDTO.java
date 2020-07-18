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
	
	
	
}
