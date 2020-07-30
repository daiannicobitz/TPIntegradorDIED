package imp.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imp.enumerators.TipoPlanta;
import imp.enumerators.UM;
import imp.gestores.DBManager;
import imp.primaryClasses.Insumo;
import imp.primaryClasses.InsumoGeneral;
import imp.primaryClasses.InsumoLiquido;
import imp.primaryClasses.Planta;

public class DAOPlanta {
	
	public static void EliminarPlanta(int idPlanta) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String consulta = "delete from PLANTA where id_planta = '" + idPlanta +"'" ;
			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
public static void AltaPlanta(Planta planta) {
		
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		String consulta = null;
		
		try {
				consulta = "insert into PLANTA(nombre,tipo_planta) "
					+ "values ('"+planta.getNombre()+"','"+planta.getTipo().toString()+"')";

			Statement st = con.createStatement();
			int nro = st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

public static ArrayList<Planta> buscarTodasLasPlantas(){
	
//	Este metodo devuelve una lista con todas las plantas que hay guardadas en la base de datos.
	
	DBManager dbm = DBManager.getInstance();
	Connection con = dbm.getConn();
	ResultSet tablaPlanta=null;
	
	ArrayList<Planta> listaPlanta=new ArrayList<Planta>();
	
	String consulta = "select * from PLANTA";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaPlanta = st.executeQuery(consulta);
		
		while(tablaPlanta.next()) {
			Planta planta = new Planta(tablaPlanta.getInt("id_planta"),tablaPlanta.getString("nombre"), 
					TipoPlanta.valueOf(tablaPlanta.getString("tipo_planta")));
			listaPlanta.add(planta);		
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaPlanta;
}

public static Planta buscarPlantaPorId(int idPlanta) {
	
	DBManager dbm = DBManager.getInstance();
	Connection con = dbm.getConn();
	ResultSet tablaPlanta=null;
	
	Planta planta=null;
	
	String consulta = "select * from PLANTA where id_planta='"+idPlanta+"'";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaPlanta = st.executeQuery(consulta);
		
		while(tablaPlanta.next()) {
			planta = new Planta(tablaPlanta.getInt("id_planta"),tablaPlanta.getString("nombre"), 
					TipoPlanta.valueOf(tablaPlanta.getString("tipo_planta")));
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return planta;
}

}
