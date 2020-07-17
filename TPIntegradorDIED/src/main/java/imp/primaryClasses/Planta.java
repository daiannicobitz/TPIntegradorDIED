package imp.primaryClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import imp.enumerators.TipoPlanta;

public class Planta {
		
	private int id;
	private String nombre;
	private TipoPlanta tipo;
	private Queue<Camion> listaCamiones;
	private ArrayList<Stock> listaStock;
		
		
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
	
	public TipoPlanta getTipo() {
		return tipo;
	}

	public void setTipo(TipoPlanta tipo) {
		this.tipo = tipo;
	}

	public Planta(int id, String nombre, TipoPlanta tipo) {
			super();
			this.setId(id);
			this.setNombre(nombre);
			this.setTipo(tipo); 
			this.listaCamiones = new LinkedList<Camion>();
			this.listaStock = new ArrayList<Stock>();
		}

		
		
		
}
