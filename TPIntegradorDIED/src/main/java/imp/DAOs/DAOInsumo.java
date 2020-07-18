package imp.DAOs;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import imp.managers.DBManager;
import imp.primaryClasses.Insumo;
import imp.primaryClasses.InsumoGeneral;
import imp.primaryClasses.InsumoLiquido;

public class DAOInsumo {
	
	public static void EliminarInsumo(Insumo insumo) {

//		daian
		
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
	
	public static void AltaInsumo(Insumo insumo) {
		
//		daian
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		String consulta = null;
		
		try {
			if(insumo instanceof InsumoGeneral) {
				consulta = "insert into insumo(cantidad,costo_unitario,densidad,descripcion,peso,unidad_medida) "
					+ "values ('"+insumo.getCantidad()+"',null,'"+insumo.getDescripcion()+"',"
							+ "'"+((InsumoGeneral) insumo).getPeso()+"','"+insumo.getUnidadMedida().toString()+"')";
				
			} else {
				consulta = "insert into insumo(cantidad,costo_unitario,densidad,descripcion,peso,unidad_medida) "
						+ "values ('"+insumo.getCantidad()+"','"+((InsumoLiquido) insumo).getDensidad()+"','"+insumo.getDescripcion()+"',"
								+ "null,'"+insumo.getUnidadMedida().toString()+"')";
			}
			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

}
