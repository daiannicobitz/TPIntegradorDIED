package imp.primaryClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Planta {
		
	protected int id;
	protected String nombre;
	protected Queue<Camion> listaCamiones;
	protected ArrayList<Stock> listaStock;
		
		
		public Planta(int id, String nombre) {
			super();
			this.id=id;
			this.nombre=nombre;

			this.listaCamiones = new LinkedList<Camion>();
			this.listaStock = new ArrayList<Stock>();
		}
		
		
		
}
