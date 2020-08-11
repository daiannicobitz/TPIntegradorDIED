package imp.gestores;

import java.util.ArrayList;

import imp.DAOs.DAOCamion;
import imp.DTOs.CamionDTO;
import imp.primaryClasses.Camion;

public class GestorCamion {

	//AltaCamion retorna un arreglo de dos objetos, el primero es el camion y el segundo es un string que dice 
			//si ese camion ya existía o no y fue creado ahora
			public Camion AltaCamion(String patente, double kmRecorridos, String marca, String modelo, double costoKm, double costoHora, String fechacompra) {
		
					Camion c1 = new Camion(patente, kmRecorridos, marca, modelo, costoKm, costoHora, fechacompra);
					DAOCamion.GuardarCamion(c1);

					return c1;
			}
			
			
			//BuscarCamion recibe todos los atributos posibles de busqueda y crea un camionDTO con esos atributos, 
			//luego llama al DAO y busca el camion en la BDD, la busqueda retorna un ArrayList con todos los camiones que se 
			//encontraron
			public ArrayList<Camion> BuscarCamion(String patente, String costoHora, String costoKm, String fechacompra, String kmRecorridos, String marca, String modelo) {
				
				if(marca == "SELECCIONE_MARCA") {
					marca = "";
				}
				CamionDTO camion = new CamionDTO(null, patente, kmRecorridos,  marca,  modelo, costoKm, costoHora, fechacompra);
				
				
				ArrayList<Camion> listaCamiones = DAOCamion.BuscarCamion(camion);
				
				return listaCamiones;
			}
	
}
