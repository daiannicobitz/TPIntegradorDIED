package imp.primaryClasses;

import java.util.ArrayList;
import java.util.Queue;

public class PlantaProduccion extends Planta {

	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Queue<Camion> getListaCamiones() {
		return this.listaCamiones;
	}
	
	public void setListaCamiones(Queue<Camion> listaCamiones) {
		this.listaCamiones = listaCamiones;
	}
	
	public ArrayList<Stock> getListaStock() {
		return this.listaStock;
	}
	
	public void setListaStock(ArrayList<Stock> listaStock) {
		this.listaStock = listaStock;
	}
	
	public PlantaProduccion(int id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

}
