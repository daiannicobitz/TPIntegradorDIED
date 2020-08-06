package imp.primaryClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import imp.enumerators.TipoPlanta;
import imp.structures.Vertice;

public class Planta{
		
	public int id;
	public String nombre;
	public TipoPlanta tipo;
	public ArrayList<Stock> listaStock;
		
		
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

	public boolean equals(Object o){
		 return (o instanceof Planta && ((Planta)o).nombre.equals(this.nombre));
	}
	
	public Planta(int id, String nombre, TipoPlanta tipo) {
			super();
			this.setId(id);
			this.setNombre(nombre);
			this.setTipo(tipo);
			this.listaStock = new ArrayList<Stock>();
		}

	@Override
	public String toString() {
		return  this.getNombre();
	}	
	
	
		
}
