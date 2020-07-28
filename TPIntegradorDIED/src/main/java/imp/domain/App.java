package imp.domain;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import imp.gestores.DBManager;
import imp.interfaces.MenuPrincipalFrame;
import imp.gestores.GestorPantallas;



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
