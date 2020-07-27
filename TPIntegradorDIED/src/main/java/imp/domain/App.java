package imp.domain;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import imp.DTOs.InsumoDTO;
import imp.DTOs.InsumoDTOFiltro;
import imp.enumerators.UM;
import imp.gestores.DBManager;
import imp.gestores.GestorInsumo;
import imp.interfaces.MenuPrincipalFrame;
import imp.gestores.GestorPantallas;


/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {	
    	
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
