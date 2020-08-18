package imp.gestores;

import java.util.ArrayList;
import java.util.List;

import imp.DAOs.DAOInsumo;
import imp.DAOs.DAOPlanta;
import imp.DTOs.PlantaDTO;
import imp.enumerators.TipoPlanta;
import imp.enumerators.UM;
import imp.primaryClasses.InsumoGeneral;
import imp.primaryClasses.Planta;

import imp.structures.Grafo;
import imp.structures.Ruta;
import imp.structures.Vertice;

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

	public static boolean ExistePlanta(String plantaDestino) {		
	  return DAOPlanta.ExistePlanta(plantaDestino);
	}

	public static ArrayList<Planta> BuscarTodasLasPlantas() {
		
		return DAOPlanta.buscarTodasLasPlantas();
	
	}

	public static List<String> getPlantasNombres() {
		
		Grafo g = Grafo.getInstance();
		
		List<Vertice<Planta>> verticesList = g.vertices();
		List<String> nombresPlantas = new ArrayList<String>();
		
		for(Vertice<Planta> c : verticesList)
		nombresPlantas.add(c.getValor().getNombre());
		
		return nombresPlantas;
	}

	public static void darAltaPlanta(PlantaDTO plantaDTO) {
		
		DAOPlanta.AltaPlanta(new Planta(plantaDTO.getId(), plantaDTO.getNombre(), TipoPlanta.valueOf(plantaDTO.getTipo())));
		Grafo.getInstance().actualizarGrafo();
		
	}

	public static int getIDPlanta(String nombre) {
		// TODO Auto-generated method stub
		return DAOPlanta.getIdPlanta(nombre);
	}

}
