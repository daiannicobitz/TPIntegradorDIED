package imp.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imp.gestores.DBManager;
import imp.gestores.GestorPlanta;
import imp.primaryClasses.Planta;
import imp.structures.*;

public class DAORuta {
	
	public static void EliminarRuta(int idRuta) {

		Connection con = DBManager.getConn();
		
		try {
			String consulta = "delete from RUTA where id_ruta = '" + idRuta +"'" ;
			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}
	
public static void AltaRuta(Ruta<Planta> ruta) {
		
		
		Connection con = DBManager.getConn();
		String consulta = null;
		
		try {
				consulta = "insert into RUTA(id_planta_origen, id_planta_destino, distancia,"
						+ " duracion_recorrido, peso_maximo) "
						+ "values ('"+((Planta) ruta.getInicio().getValor()).getId()+"','"+((Planta) ruta.getFin().getValor()).getId()+"',"
						+ "'"+ruta.getDistancia()+"','"+ruta.getDuracionRecorrido()+"','"+ruta.getPesoMaximo()+"')";

			Statement st = con.createStatement();
			st.executeUpdate(consulta);
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

public static ArrayList<Ruta<Planta>> buscarTodasLasRutas(){
	
//	Este metodo devuelve una lista con todas las rutas que hay guardadas en la base de datos.
	
	Connection con = DBManager.getConn();
	ResultSet tablaRuta=null;
	
	ArrayList<Ruta<Planta>> listaRuta=new ArrayList<Ruta<Planta>>();
	
	String consulta = "select * from RUTA";
	
	Statement st;
	
	try {
		st = con.createStatement();
		tablaRuta = st.executeQuery(consulta);
		
		while(tablaRuta.next()) {
			
			Planta plantaOrigen=GestorPlanta.getPlantaById(tablaRuta.getInt("id_planta_origen"));
			Planta plantaDestino=GestorPlanta.getPlantaById(tablaRuta.getInt("id_planta_destino"));
			
			Ruta<Planta> ruta = new Ruta<Planta>(new Vertice<Planta>(plantaOrigen), new Vertice<Planta>(plantaDestino), tablaRuta.getDouble("distancia"),
					tablaRuta.getDouble("duracion_recorrido"), tablaRuta.getDouble("peso_maximo"));
			listaRuta.add(ruta);		
		}
		
		st.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaRuta;
}

}
