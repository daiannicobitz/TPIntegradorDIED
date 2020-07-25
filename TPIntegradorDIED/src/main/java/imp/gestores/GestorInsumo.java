package imp.gestores;

import java.util.ArrayList;

import imp.DAOs.DAOInsumo;
import imp.DTOs.InsumoDTO;
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

		if(insumodto.getDensidad()==null) {
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
	
	public static ArrayList<InsumoDTO> visualizarInsumosGenerales(){
		ArrayList<Insumo> insumos = new ArrayList<Insumo>();
		insumos = DAOInsumo.buscarTodosLosInsumos();
		ArrayList<InsumoDTO> insumosDTO = new ArrayList<InsumoDTO>();
		int i=0;
		while(insumos.get(i) != null) {
			
			if(insumos.get(i) instanceof InsumoLiquido) {
				InsumoDTO insumoDTO=new InsumoDTO(insumos.get(i).getId(), insumos.get(i).getDescripcion(), insumos.get(i).getUnidadMedida().toString(),
					String.valueOf(insumos.get(i).getCostoUnitario()),String.valueOf(insumos.get(i).getCantidad()),
					String.valueOf(((InsumoLiquido) insumos.get(i)).getPeso()),String.valueOf(((InsumoLiquido) insumos.get(i)).getDensidad()));
				insumosDTO.add(insumoDTO);
			}else {
				InsumoDTO insumoDTO=new InsumoDTO(insumos.get(i).getId(), insumos.get(i).getDescripcion(), insumos.get(i).getUnidadMedida().toString(),
						String.valueOf(insumos.get(i).getCostoUnitario()),String.valueOf(insumos.get(i).getCantidad()),
						String.valueOf(((InsumoLiquido) insumos.get(i)).getPeso()),null);
					insumosDTO.add(insumoDTO);
			}
			i++;
		}
		
		return insumosDTO;
		
	}
	
}
