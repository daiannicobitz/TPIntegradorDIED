package imp.gestores;

import java.util.ArrayList;


import imp.DAOs.DAOPlanta;
import imp.DTOs.PlantaDTO;
import imp.primaryClasses.Planta;

public class GestorPlanta {
	
	public static ArrayList<PlantaDTO> visualizarTodasLasPlantas(){
		ArrayList<Planta> plantas = new ArrayList<Planta>();
		plantas = DAOPlanta.buscarTodasLasPlantas();
		ArrayList<PlantaDTO> plantasDTO = new ArrayList<PlantaDTO>();
		
		for(Planta p : plantas) {
			PlantaDTO dtoPlanta= new PlantaDTO(p.getId(), p.getNombre(), p.getTipo().toString());
			plantasDTO.add(dtoPlanta);
		}
		
		return plantasDTO;
	}

	public static Planta getPlantaById(int idPlanta) {
		
		return DAOPlanta.buscarPlantaPorId(idPlanta);
	}

}
