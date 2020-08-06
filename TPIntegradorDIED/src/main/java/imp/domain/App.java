package imp.domain;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import imp.DTOs.InsumoDTO;
import imp.DTOs.InsumoDTOFiltro;
import imp.enumerators.TipoPlanta;
import imp.enumerators.UM;
import imp.gestores.DBManager;
import imp.gestores.GestorInsumo;
import imp.interfaces.MenuPrincipalFrame;
import imp.primaryClasses.ListaGlobalCamiones;
import imp.primaryClasses.Planta;
import imp.structures.Grafo;
import imp.gestores.GestorPantallas;



public class App 
{
	
	
    public static void main( String[] args )
    {	
    	ListaGlobalCamiones lgc = ListaGlobalCamiones.getInstance();
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
