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

	public static ArrayList<Planta> buscarPlantaConStock(ArrayList<Item> listaItems ){
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
	
	
	public static ArrayList<StockDTO> buscarStockBajoPuntoPedido() {

        ArrayList<Stock> listaStock = new ArrayList<Stock>();
        ArrayList<StockDTO> listaStockDTO = new ArrayList<StockDTO>();
        Grafo grafo = Grafo.getInstance();

//        private int id;
//        private int idPlanta;
//        private double cantidad;
//        private double puntoPedido;
//        private int idInsumo;

        for(Stock s : listaStock) {

            Insumo insumo = GestorInsumo.buscarInsumoPorId(s.getInsumo());

            Planta planta = (Planta) grafo.getNodo(s.getIdPlanta()).getValor();
            StockDTO dto = new StockDTO(s.getId(), Double.toString(s.getCantidad()), Double.toString(s.getPuntoPedido()),
                    insumo.getDescripcion(), planta.getNombre(), Double.toString(insumo.getCantidad()));
            listaStockDTO.add(dto);
        }
        return listaStockDTO;



     }

}
