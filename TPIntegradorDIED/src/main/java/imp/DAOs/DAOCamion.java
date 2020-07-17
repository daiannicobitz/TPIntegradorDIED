package imp.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imp.managers.DBManager;
import imp.primaryClasses.Camion;

public class DAOCamion {

	public static void EliminarCamion(Camion camion) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String Consulta = "delete from camion where patente = '" + camion.getPatente() +"'" ;

			Statement st = con.createStatement();
			int nro = st.executeUpdate(Consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	public static ArrayList<Camion> BuscarCamion(Camion camion) {
	
		
		return null;
	}
	
	

	public static void GuardarCamion(Camion c1) {
		// TODO Auto-generated method stub
		
	}

	
	public static void actualizarCamion(Camion camion) {
		// TODO Auto-generated method stub
		
	}

}
