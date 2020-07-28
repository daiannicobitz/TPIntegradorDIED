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
			String consulta = "delete from INSUMO where id_insumo = '" + idInsumo +"'" ;
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
				consulta = "insert into INSUMO(cantidad,costo_unitario,densidad,descripcion,peso,unidad_medida) "
					+ "values ('"+insumo.getCantidad()+"','"+insumo.getCostoUnitario()+"',null,'"+insumo.getDescripcion()+"',"
							+ "'"+((InsumoGeneral) insumo).getPeso()+"','"+insumo.getUnidadMedida().toString()+"')";
				
			} else {

				consulta = "insert into INSUMO(cantidad,costo_unitario,densidad,descripcion,peso,unidad_medida) "
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
				System.out.println("llego");
				
				System.out.println(insumo.getId());
				System.out.println(insumo.getCantidad());
				System.out.println(insumo.getCostoUnitario());
				System.out.println(insumo.getDescripcion());
				System.out.println(((InsumoGeneral) insumo).getPeso());
				System.out.println(insumo.getUnidadMedida());
				
				consulta = "update insumo "
						+ "SET cantidad = '"+insumo.getCantidad()+"', costo_unitario = '"+insumo.getCostoUnitario()+"',"
						+ "descripcion = '"+insumo.getDescripcion()+"',peso = '"+((InsumoGeneral) insumo).getPeso()+"',"
						+ "unidad_medida =  '"+insumo.getUnidadMedida().toString()+"' where id_insumo = '"+insumo.getId()+"'";
				
			} else {
				consulta = "update insumo"
						+ "SET cantidad = '"+insumo.getCantidad()+"', costo_unitario = '"+insumo.getCostoUnitario()+"', "
						+ "densidad = '"+((InsumoLiquido) insumo).getDensidad()+"',descripcion = '"+insumo.getDescripcion()+"',"
						+ "peso = '"+((InsumoLiquido) insumo).getPeso()+"', unidad_medida = '"+insumo.getUnidadMedida().toString()+"' "
						+ "where id_insumo = '"+insumo.getId()+"'";
			}
			Statement st = con.createStatement();
			System.out.println(consulta);
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
		
		String consulta = "select * from INSUMO";
		
		Statement st;
		try {
			st = con.createStatement();
			tablaInsumo = st.executeQuery(consulta);
			
			while(tablaInsumo.next()) {
				
				if(tablaInsumo.getString("densidad") == null) {
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
				
			}
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaInsumos;
	}
	

	public static ArrayList<Insumo> buscarInsumosConFiltros(String descripcion, UM unidadMedida, double costoUnitario) {
//		Este metodo busca todos los insumos que sus atributos coincidan con los parametros.
		
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		ResultSet tablaInsumo=null;
		ArrayList<Insumo> listaInsumos=new ArrayList<Insumo>();
		Statement st;
		
		try {
			st = con.createStatement();
			
			if(costoUnitario == -1.0) {
				if(unidadMedida.toString().equals("SELECCIONE_UNIDAD")) {
					tablaInsumo = st.executeQuery("select * from INSUMO where  descripcion LIKE '%"+descripcion+"%'");
				}else {
						tablaInsumo = st.executeQuery("select * from INSUMO where  descripcion LIKE '%"+descripcion+"%' "
									+ "and unidad_medida like '%"+unidadMedida.toString()+"%'");
				}
			}else {
				if(unidadMedida.toString().equals("SELECCIONE_UNIDAD")) {
					tablaInsumo = st.executeQuery("select * from INSUMO where  descripcion LIKE '%"+descripcion+"%' "
							+ "and costo_unitario='"+costoUnitario+"'");
				}else {
				tablaInsumo = st.executeQuery("select * from INSUMO where  descripcion LIKE '%"+descripcion+"%' "
						+ "and unidad_medida like '%"+unidadMedida.toString()+"%' and costo_unitario='"+costoUnitario+"'");
				}
			}
			
			while(tablaInsumo.next()) {
				if(tablaInsumo.getString("densidad") == null) {
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
				
			}
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaInsumos;
	}

}
