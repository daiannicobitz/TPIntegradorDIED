package imp.gestores;

import imp.DAOs.DAOPlanta;
import imp.primaryClasses.Planta;

public class GestorPlanta {

	public static Planta getPlantaById(int idPlanta) {
		
		return DAOPlanta.buscarPlantaPorId(idPlanta);
	}

	public static boolean ExistePlanta(String plantaDestino) {		
	  return DAOPlanta.ExistePlanta(plantaDestino);
	}

}
