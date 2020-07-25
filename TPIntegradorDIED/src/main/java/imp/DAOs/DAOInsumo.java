package imp.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imp.gestores.DBManager;
import imp.enumerators.UM;
import imp.primaryClasses.Insumo;
import imp.primaryClasses.InsumoGeneral;
import imp.primaryClasses.InsumoLiquido;

public class DAOInsumo {
	
	public static void EliminarInsumo(int idInsumo) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String consulta = "delete from insumo where id_insumo = '" + idInsumo +"'" ;

			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void AltaInsumo(Insumo insumo) {
		
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		String consulta = null;
		
		try {
			if(insumo instanceof InsumoGeneral) {
				consulta = "insert into insumo(cantidad,costo_unitario,densidad,descripcion,peso,unidad_medida) "
					+ "values ('"+insumo.getCantidad()+"','"+insumo.getCostoUnitario()+"',null,'"+insumo.getDescripcion()+"',"
							+ "'"+((InsumoGeneral) insumo).getPeso()+"','"+insumo.getUnidadMedida().toString()+"')";
				
			} else {

				consulta = "insert into insumo(cantidad,costo_unitario,densidad,descripcion,peso,unidad_medida) "
						+ "values ('"+insumo.getCantidad()+"','"+insumo.getCostoUnitario()+"','"+((InsumoLiquido) insumo).getDensidad()+"',"
						+ "'"+insumo.getDescripcion()+"','"+((InsumoLiquido) insumo).getPeso()+"','"+insumo.getUnidadMedida().toString()+"')";
			}
			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static void EditarInsumo(Insumo insumo) {
		
//		este metodo es similar al de alta, nomas que busca por id en la bdd y actualiza TODAS las columnas
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		String consulta = null;
		
		try {
			if(insumo instanceof InsumoGeneral) {
				consulta = "update insumo "
						+ "SET cantidad = '"+insumo.getCantidad()+"', costo_unitario = '"+insumo.getCostoUnitario()+"',"
						+ "descripcion = '"+insumo.getDescripcion()+"',peso = '"+((InsumoGeneral) insumo).getPeso()+"',"
						+ "unidad_medida =  '"+insumo.getUnidadMedida().toString()+"' where id_insumo = '"+insumo.getId()+"'";
				
			} else {
				consulta = "update insumo"
						+ "SET cantidad = '"+insumo.getCantidad()+"', costo_unitario = '"+insumo.getCostoUnitario()+"', "
						+ "densidad = '"+((InsumoLiquido) insumo).getDensidad()+"',descripcion = '"+insumo.getDescripcion()+"',"
						+ "peso = '"+((InsumoGeneral) insumo).getPeso()+"', unidad_medida = '"+insumo.getUnidadMedida().toString()+"' "
						+ "where id_insumo = '"+insumo.getId()+"'";
			}
			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
	public static ArrayList<Insumo> buscarTodosLosInsumos(){
		
//		Este metodo devuelve una lista con todos los insumos que hay guardados en la base de datos.

//		HAY QUE PROBARLO
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		ResultSet tablaInsumo=null;
		
		ArrayList<Insumo> listaInsumos=new ArrayList<Insumo>();
		
		String consulta = "select * from insumo";
		
		Statement st;
		try {
			st = con.createStatement();
			tablaInsumo = st.executeQuery(consulta);
			
			while(tablaInsumo.next()) {
				if(tablaInsumo.getString("densidad").equals("null")) {
				InsumoGeneral insumo = new InsumoGeneral(tablaInsumo.getInt("id_insumo"),tablaInsumo.getString("descripcion"), 
						UM.valueOf(tablaInsumo.getString("unidad_medida")), tablaInsumo.getDouble("costo_unitario"), 
						tablaInsumo.getDouble("cantidad"), tablaInsumo.getDouble("peso"));
						listaInsumos.add(insumo);
				}else {
					
					InsumoLiquido insumo = new InsumoLiquido(tablaInsumo.getInt("id_insumo"),tablaInsumo.getString("descripcion"), 
					UM.valueOf(tablaInsumo.getString("unidad_medida")), tablaInsumo.getDouble("costo_unitario"), 
					tablaInsumo.getDouble("cantidad"), tablaInsumo.getDouble("densidad"));
					listaInsumos.add(insumo);
				}
				
				st.close();
				con.close();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaInsumos;
	}
	

}
