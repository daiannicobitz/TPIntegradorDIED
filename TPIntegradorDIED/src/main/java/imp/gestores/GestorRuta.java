package imp.gestores;

import java.util.ArrayList;

import imp.DAOs.DAORuta;
import imp.DTOs.RutaDTO;
import imp.primaryClasses.Planta;
import imp.structures.Ruta;
import imp.structures.Vertice;

public class GestorRuta {
	
	public static ArrayList<Ruta<Planta>> BuscarTodasLasRutas(){
		return DAORuta.buscarTodasLasRutas();
		
	}

	public static void darAltaRuta(RutaDTO rutaDto, int idPlantaOrigen, int idPlantaDestino) {
		
		DAORuta.AltaRuta(new Ruta<Planta>(new Vertice<Planta>(new Planta(idPlantaOrigen, null, null)), 
				new Vertice<Planta>(new Planta(idPlantaDestino, null, null)), Double.parseDouble(rutaDto.getDistancia()),
				Double.parseDouble(rutaDto.getDuracionRecorrido()), Double.parseDouble(rutaDto.getPesoMaximo())));
		
	}

}
