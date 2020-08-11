package imp.DTOs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import imp.primaryClasses.OrdenPedido;

public class OrdenPedidoDTO {
	
	public String nroOrden; 
	public String plantaDestino;
	public String fechaEntrega; 
	public String fechaSolicitud;
	public String estado;
	
	
	public OrdenPedidoDTO (String nroOrden, String planta, String entrega, String solicitud, String estado) {
		this.estado = estado;
		this.fechaEntrega = entrega; 
		this.fechaSolicitud = solicitud;
		this.nroOrden = nroOrden;
		this.plantaDestino = planta;
		
	}
	
	public OrdenPedidoDTO (OrdenPedido o ) {
		this.estado = o.getEstado().toString();
		this.plantaDestino = o.getPlantaDestino();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		String entrega = dateFormat.format(o.getFechaEntrega());
		this.fechaEntrega = entrega;
		String solicitud = dateFormat.format(o.getFechaSolicitud());
		this.fechaSolicitud = solicitud;
		this.nroOrden = Long.toString(o.getNumeroOrden());
	}

	public String getNroOrden() {
		return nroOrden;
	}


	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}


	public String getPlantaDestino() {
		return plantaDestino;
	}


	public void setPlantaDestino(String plantaDestino) {
		this.plantaDestino = plantaDestino;
	}


	public String getFechaEntrega() {
		return fechaEntrega;
	}


	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}


	public String getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

}
