package imp.DTOs;

import imp.enumerators.UM;

public class InsumoGeneralDTO {
	
	private String descripcion;
	private String unidadMedida;
	private String costoUnitario;
	private String cantidad;
	private String peso;
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getUnidadMedida() {
		return unidadMedida;
	}
	
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	public String getCostoUnitario() {
		return costoUnitario;
	}
	
	public void setCostoUnitario(String costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	
	public String getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public void setPeso(String peso) {
		this.peso = peso;
	}

}
