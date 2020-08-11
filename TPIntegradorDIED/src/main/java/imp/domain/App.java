package imp.domain;

import java.awt.EventQueue;

import imp.primaryClasses.ListaGlobalCamiones;
import imp.primaryClasses.Planta;
import imp.structures.Grafo;
import imp.gestores.GestorPantallas;



public class App 
{
	
	
    public static void main( String[] args )
    {	
    	
    	ListaGlobalCamiones lgc = ListaGlobalCamiones.getInstance();
    	
    	Grafo<Planta> grafo = Grafo.getInstance();
    	
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
