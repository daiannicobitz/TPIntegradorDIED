package imp.gestores;

import java.util.ArrayList;

import imp.DTOs.StockDTO;
import imp.primaryClasses.Insumo;
import imp.primaryClasses.Item;
import imp.primaryClasses.OrdenPedido;
import imp.primaryClasses.Planta;
import imp.primaryClasses.Stock;
import imp.structures.Grafo;

public class GestorStock {

	public ArrayList<Planta> buscarPlantaConStock(ArrayList<Item> listaItems ){
		Grafo grafo = Grafo.getInstance();
		int lotiene = 0;
		ArrayList<Planta> plantas = grafo.getPlantas();
		
		ArrayList<Planta> listaPlantas = new ArrayList<>();
			
			for(int j=0; j<plantas.size();j++) {
				
				Planta planta = plantas.get(j);
				
				for(Item i: listaItems) {
					
				for(Stock s :planta.getListaStock()) {
					
					if(s.getInsumo() == i.getIdInsumo() && s.getCantidad() >= i.getCantidadSolicitada()) {
						
						lotiene = lotiene +1;
						
					}
				}
			}
				
				if(listaItems.size()==lotiene) {
					listaPlantas.add(planta);
				}
				
				lotiene = 0;
		}
		
		return listaPlantas;
	}
	

}
