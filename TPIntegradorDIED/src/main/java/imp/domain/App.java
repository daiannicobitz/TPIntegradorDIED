package imp.domain;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import imp.interfaces.MenuPrincipal;
import imp.managers.DBManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {

			DBManager dbm = DBManager.getInstance();
			Connection con = dbm.getConn();
			JOptionPane.showMessageDialog(null, "Base de datos conectada.", "Conexión establecida", JOptionPane.INFORMATION_MESSAGE);
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No Hay Conexión con la Base de Datos.", "Error", JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No Hay Conexión con la Base de Datos.", "Error", JOptionPane.WARNING_MESSAGE);
			//e.printStackTrace();
		}

        imprimeMensaje("Hello World!");
        
        
    }
    
    private static void imprimeMensaje(String msg) {
    	System.out.println( msg );
    }
}
