package imp.DAOs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import imp.managers.DBManager;
import imp.primaryClasses.Insumo;

public class DAOInsumo {
	
	public static void EliminarInsumo(Insumo insumo) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String consulta = "delete from insumo where id_insumo = '" + insumo.getId() +"'" ;

			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

}
