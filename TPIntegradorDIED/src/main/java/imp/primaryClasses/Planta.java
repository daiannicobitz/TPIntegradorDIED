package imp.primaryClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Planta {
		
		private int id;
		private String nombre;
		private Queue<Camion> listaCamiones;
		private ArrayList<Stock> listaStock;
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getNombre() {
			return nombre;
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public Queue<Camion> getListaCamiones() {
			return listaCamiones;
		}
		
		public void setListaCamiones(Queue<Camion> listaCamiones) {
			this.listaCamiones = listaCamiones;
		}
		
		public ArrayList<Stock> getListaStock() {
			return listaStock;
		}
		
		public void setListaStock(ArrayList<Stock> listaStock) {
			this.listaStock = listaStock;
		}
		
		public Planta(int id, String nombre) {
			super();
			setId(id);
			setNombre(nombre);

			this.listaCamiones = new LinkedList<Camion>();
			this.listaStock = new ArrayList<Stock>();
		}
		
		
		
}
