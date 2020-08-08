package imp.gestores;

import java.util.ArrayList;

import imp.DAOs.DAORuta;
import imp.primaryClasses.Planta;
import imp.structures.Ruta;

public class GestorRuta {
	
	public static ArrayList<Ruta<Planta>> BuscarTodasLasRutas(){
		return DAORuta.buscarTodasLasRutas();
		
	}

}
