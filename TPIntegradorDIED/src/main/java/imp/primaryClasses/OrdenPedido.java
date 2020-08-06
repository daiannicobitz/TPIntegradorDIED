package imp.primaryClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import imp.enumerators.EstadoOrden;

public class OrdenPedido {

	private long numeroOrden;
	private String NombreplantaDestino;
	private Date fechaSolicitud;
	private Date fechaEntrega;
	private EstadoOrden estado;
	private ArrayList <Item> items;
	
	public OrdenPedido() {
		
	}
	
	
	public long getNumeroOrden() {
		return numeroOrden;
	}
	
	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	
	public String getPlantaDestino() {
		return NombreplantaDestino;
	}
	
	public void setPlantaDestino(String NombreplantaDestino) {
		this.NombreplantaDestino = NombreplantaDestino;
	}
	
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public EstadoOrden getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	} 
//	setItems me parece conveniente que agregue solamente 1 item a la lista de items (commented by Dian)
	
	
}
