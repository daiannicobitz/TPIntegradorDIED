package imp.primaryClasses;

import java.util.Date;
import java.util.List;

import imp.enumerators.EstadoOrden;

public class OrdenPedido {

	private long numeroOrden;
	private Planta plantaDestino;
	private Date fechaSolicitud;
	private Date fechaEntrega;
	private EstadoOrden estado;
	private List <Item> items;
	
	
	public long getNumeroOrden() {
		return numeroOrden;
	}
	
	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	
	public Planta getPlantaDestino() {
		return plantaDestino;
	}
	
	public void setPlantaDestino(Planta plantaDestino) {
		this.plantaDestino = plantaDestino;
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
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	} 
//	setItems me parece conveniente que agregue solamente 1 item a la lista de items (commented by Dian)
	
	
}
