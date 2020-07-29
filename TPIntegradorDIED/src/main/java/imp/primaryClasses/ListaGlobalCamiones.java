package imp.primaryClasses;

import java.util.ArrayList;

import imp.gestores.GestorCamion;

public class ListaGlobalCamiones {

	private ArrayList<Camion> lista;
	
	private static ListaGlobalCamiones LGC;
	
	 public ListaGlobalCamiones(ArrayList<Camion> buscarCamion) {
		// TODO Auto-generated constructor stub
		 this.lista = buscarCamion;
	}

	public  static ListaGlobalCamiones getInstance() {
		 
		 if (LGC==null) {
		 GestorCamion gc = new GestorCamion();
			 LGC = new ListaGlobalCamiones(gc.BuscarCamion("", "", "", "", "", "", ""));
		 }
		 return LGC;
		 }
	
	public void addCamion(Camion c1) {
		
		this.lista.add(c1);
	}

	public void delCamion(Camion retorno) {

		
		this.lista.removeIf(t -> t.getPatente().equals(retorno.getPatente()));
		
	}
	
	public ArrayList<Camion> getLista(){
		return lista;
		
	}
}
