package imp.gestores;

import imp.DAOs.DAOPlanta;
import imp.primaryClasses.Planta;

public class GestorPlanta {

	public static Planta getPlantaById(int idPlanta) {
		
		return DAOPlanta.buscarPlantaPorId(idPlanta);
	}

}
