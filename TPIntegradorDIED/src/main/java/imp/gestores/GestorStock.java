package imp.gestores;

import java.util.ArrayList;

import imp.DTOs.StockDTO;
import imp.primaryClasses.Planta;
import imp.primaryClasses.Stock;
import imp.structures.Grafo;

public class GestorStock {

	public static ArrayList<StockDTO> buscarStockBajoPuntoPedido() {
		
		ArrayList<Stock> listaStock = new ArrayList<Stock>();
		ArrayList<StockDTO> listaStockDTO = new ArrayList<StockDTO>();
		Grafo grafo = Grafo.getInstance();
		
		for(Stock s : listaStock) {
			
			Planta planta = (Planta) grafo.getNodo(s.getIdPlanta()).getValor();			
			StockDTO dto = new StockDTO(s.getId(), Double.toString(s.getCantidad()), Double.toString(s.getPuntoPedido()),
					s.getInsumo().getDescripcion(), planta.getNombre(), Double.toString(s.getInsumo().getCantidad()));
			
		}
		
		
		
		return listaStockDTO;
		
		
		
	}
	
	

}
