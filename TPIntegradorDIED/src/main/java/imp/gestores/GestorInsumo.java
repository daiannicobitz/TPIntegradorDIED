package imp.gestores;

import java.util.ArrayList;

import imp.DAOs.DAOInsumo;
import imp.DTOs.InsumoDTO;
import imp.DTOs.InsumoDTOFiltro;
import imp.enumerators.UM;
import imp.primaryClasses.Insumo;
import imp.primaryClasses.InsumoGeneral;
import imp.primaryClasses.InsumoLiquido;


public class GestorInsumo {
	
	
	public static void darAltaInsumo(InsumoDTO insumodto) {
		
//		cuando creo el insumo para darlo de alta le pongo id=0 pero no va a ser tenido en cuenta a la hora de guardarlo en la bdd.
		
		if(insumodto.getDensidad()==null) {
			DAOInsumo.AltaInsumo(new InsumoGeneral(0, insumodto.getDescripcion(), UM.valueOf(insumodto.getUnidadMedida()), 
				Double.parseDouble(insumodto.getCostoUnitario()), Double.parseDouble(insumodto.getCantidad()),
				Double.parseDouble(insumodto.getPeso())));
		}else {
			DAOInsumo.AltaInsumo(new InsumoLiquido(0, insumodto.getDescripcion(), UM.valueOf(insumodto.getUnidadMedida()), 
					Double.parseDouble(insumodto.getCostoUnitario()), Double.parseDouble(insumodto.getCantidad()),
					Double.parseDouble(insumodto.getDensidad())));
		}
		
	}
	
	public static void editarInsumo(InsumoDTO insumodto) {

		if(insumodto.getDensidad().equals("-")) {
				DAOInsumo.EditarInsumo(new InsumoGeneral(insumodto.getId(), insumodto.getDescripcion(), UM.valueOf(insumodto.getUnidadMedida()), 
				Double.parseDouble(insumodto.getCostoUnitario()), Double.parseDouble(insumodto.getCantidad()),
				Double.parseDouble(insumodto.getPeso())));
		}else {
			DAOInsumo.EditarInsumo(new InsumoLiquido(insumodto.getId(), insumodto.getDescripcion(), UM.valueOf(insumodto.getUnidadMedida()), 
					Double.parseDouble(insumodto.getCostoUnitario()), Double.parseDouble(insumodto.getCantidad()),
					Double.parseDouble(insumodto.getDensidad())));
		}
		
	}
	
	public static void eliminarInsumo(InsumoDTO insumodto) {
		
		DAOInsumo.EliminarInsumo(insumodto.getId());
		
	}
	
	public static ArrayList<InsumoDTO> visualizarTodosLosInsumos(){
		ArrayList<Insumo> insumos = new ArrayList<Insumo>();
		insumos = DAOInsumo.buscarTodosLosInsumos();
		ArrayList<InsumoDTO> insumosDTO = new ArrayList<InsumoDTO>();
		
		for(int i=0;i<insumos.size();i++) {
			
			if(insumos.get(i) instanceof InsumoLiquido) {
				InsumoDTO insumoDTO=new InsumoDTO(insumos.get(i).getId(), insumos.get(i).getDescripcion(), insumos.get(i).getUnidadMedida().toString(),
					String.valueOf(insumos.get(i).getCostoUnitario()),String.valueOf(insumos.get(i).getCantidad()),
					String.valueOf(((InsumoLiquido) insumos.get(i)).getPeso()),String.valueOf(((InsumoLiquido) insumos.get(i)).getDensidad()));
				insumosDTO.add(insumoDTO);
			}else {
				InsumoDTO insumoDTO=new InsumoDTO(insumos.get(i).getId(), insumos.get(i).getDescripcion(), insumos.get(i).getUnidadMedida().toString(),
						String.valueOf(insumos.get(i).getCostoUnitario()),String.valueOf(insumos.get(i).getCantidad()),
						String.valueOf(((InsumoGeneral) insumos.get(i)).getPeso()),"-");
					insumosDTO.add(insumoDTO);
			}
		}
		
		return insumosDTO;
		
	}

	public static ArrayList<InsumoDTO> buscarInsumosConFiltro(InsumoDTOFiltro insumoFiltro) {
		ArrayList<Insumo> insumos = new ArrayList<Insumo>();
		ArrayList<InsumoDTO> insumosDTO = new ArrayList<InsumoDTO>();
		
		if(insumoFiltro.getDescripcion().isEmpty() && insumoFiltro.getUnidadMedida().equals("SELECCIONE_UNIDAD")
			&& insumoFiltro.getCostoUnitario().isEmpty()) {
			
			return visualizarTodosLosInsumos();
		}else {
			
//			esta validacion se hace porque, en caso de ser vacio el costo unitario, va a tirar error al convertirlo a double
			
			if(insumoFiltro.getCostoUnitario().isEmpty())
			{
				insumos = DAOInsumo.buscarInsumosConFiltros(insumoFiltro.getDescripcion(), UM.valueOf(insumoFiltro.getUnidadMedida()), -1.0);
			}else {
				insumos = DAOInsumo.buscarInsumosConFiltros(insumoFiltro.getDescripcion(), UM.valueOf(insumoFiltro.getUnidadMedida()),
						Double.parseDouble(insumoFiltro.getCostoUnitario()));
			}
			
			for(int i=0; i<insumos.size();i++) {
				
				if(insumos.get(i) instanceof InsumoLiquido) {
					InsumoDTO insumoDTO=new InsumoDTO(insumos.get(i).getId(), insumos.get(i).getDescripcion(), insumos.get(i).getUnidadMedida().toString(),
						String.valueOf(insumos.get(i).getCostoUnitario()),String.valueOf(insumos.get(i).getCantidad()),
						String.valueOf(((InsumoLiquido) insumos.get(i)).getPeso()),String.valueOf(((InsumoLiquido) insumos.get(i)).getDensidad()));
					insumosDTO.add(insumoDTO);
				}else {
					InsumoDTO insumoDTO=new InsumoDTO(insumos.get(i).getId(), insumos.get(i).getDescripcion(), insumos.get(i).getUnidadMedida().toString(),
							String.valueOf(insumos.get(i).getCostoUnitario()),String.valueOf(insumos.get(i).getCantidad()),
							String.valueOf(((InsumoGeneral) insumos.get(i)).getPeso()),"-");
						insumosDTO.add(insumoDTO);
				}
			}
			
			return insumosDTO;
		}
	}
	
}
