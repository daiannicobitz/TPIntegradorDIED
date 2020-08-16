package imp.domain;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import imp.primaryClasses.ListaGlobalCamiones;
import imp.primaryClasses.Planta;
import imp.structures.Grafo;
import imp.structures.Vertice;
import imp.gestores.GestorPantallas;
import imp.gestores.GestorPlanta;



public class App 
{
	
	
    public static void main( String[] args )
    {	
    	
    	ListaGlobalCamiones lgc = ListaGlobalCamiones.getInstance();
    	
    	Grafo<Planta> grafo = Grafo.getInstance();
    	
//    	esto puede servir para el test unitario
//    	Vertice<Planta> v1 = new Vertice<Planta>(GestorPlanta.getPlantaById(GestorPlanta.getIDPlanta("PUERTO")));
//    	Vertice<Planta> v2 = new Vertice<Planta>(GestorPlanta.getPlantaById(GestorPlanta.getIDPlanta("LLL")));
//
//    	grafo.flujoMaximo(v1, v2);

    	
    	System.out.println(lgc.getLista());
    	
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   GestorPantallas.inicio(); // abre la primera pantalla 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    	
    }
}
