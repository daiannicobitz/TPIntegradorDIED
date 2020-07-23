package imp.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import imp.DTOs.CamionDTO;
import imp.gestores.DBManager;
import imp.primaryClasses.Camion;

public class DAOCamion {

	public static void EliminarCamion(Camion camion) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String Consulta = "delete from camion where patente = " + camion.getPatente();

			Statement st = con.createStatement();
			int nro = st.executeUpdate(Consulta);
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}  finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static String ArmarConsultaBuscar(CamionDTO camion) {
		

		String retorno = "select * from camion ";
		
		if(AtributosNoNulos(camion)) {
			retorno = retorno + "where ";
			
			if(NoEsNulo(camion.getPatente()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "patente LIKE `%" + camion.getPatente() + "%` ";
				
			} 
			else if(NoEsNulo(camion.getPatente()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and patente LIKE `%" + camion.getPatente() + "%` ";
			}
			if(NoEsNulo(camion.getCostoHora()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "costo_hora LIKE `%" + camion.getCostoHora() + "%` ";
			
			} 
			else if(NoEsNulo(camion.getCostoHora()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and costo_hora LIKE `%" + camion.getCostoHora() + "%` ";
			
			}
			if(NoEsNulo(camion.getCostoKm()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "costo_km LIKE `%" + camion.getCostoKm() + "%` ";
			
			}
			else if(NoEsNulo(camion.getCostoKm()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and costo_km LIKE `%" + camion.getCostoKm() + "%` ";
			
			}
			if(NoEsNulo(camion.getMarca()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "marca LIKE `%" + camion.getMarca() + "%` ";
			
			}
			else if(NoEsNulo(camion.getMarca()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and marca LIKE `%" + camion.getMarca() + "%` ";
			
			}
			if(NoEsNulo(camion.getModelo()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "modelo LIKE `%" + camion.getModelo() + "%` ";
			
			}
			else if(NoEsNulo(camion.getModelo()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and modelo LIKE `%" + camion.getModelo() + "%` ";
			
			}
			if(NoEsNulo(camion.getKmRecorridos()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "km_recorridos LIKE `%" + camion.getKmRecorridos() + "%` ";
			
			}
			else if(NoEsNulo(camion.getKmRecorridos()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and km_recorridos LIKE `%" + camion.getKmRecorridos() + "%` ";
			
			}
			if(NoEsNulo(camion.getFechacompra()) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "fecha_compra LIKE `%" + camion.getFechacompra() + "%`";
			}
			else if(NoEsNulo(camion.getFechacompra()) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and fecha_compra LIKE `%" + camion.getFechacompra() + "%`";
			}
			
		}
		
		return retorno;
	}

	
	private static String ArmarConsultaActualizar(CamionDTO camion) {
		
		String retorno = null;
		
		if(AtributosNoNulos(camion)) {
			retorno = "update camion set";
			
			if(NoEsNulo(camion.getPatente()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "patente = `" + camion.getPatente() + "` ";
				
			} 
			else if(NoEsNulo(camion.getPatente()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", patente = `" + camion.getPatente() + "` ";
			}
			if(NoEsNulo(camion.getCostoHora()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "costo_hora = `" + camion.getCostoHora() + "` ";
			
			} 
			else if(NoEsNulo(camion.getCostoHora()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", costo_hora = `" + camion.getCostoHora() + "` ";
			
			}
			if(NoEsNulo(camion.getCostoKm()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "costo_km = `" + camion.getCostoKm() + "` ";
			
			}
			else if(NoEsNulo(camion.getCostoKm()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", costo_km = `" + camion.getCostoKm() + "` ";
			
			}
			if(NoEsNulo(camion.getMarca()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "marca = `" + camion.getMarca() + "` ";
			
			}
			else if(NoEsNulo(camion.getMarca()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", marca = `" + camion.getMarca() + "` ";
			
			}
			if(NoEsNulo(camion.getModelo()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "modelo = `" + camion.getModelo() + "` ";
			
			}
			else if(NoEsNulo(camion.getModelo()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", modelo = `" + camion.getModelo() + "` ";
			
			}
			if(NoEsNulo(camion.getKmRecorridos()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "km_recorridos = `" + camion.getKmRecorridos() + "` ";
			
			}
			else if(NoEsNulo(camion.getKmRecorridos()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", km_recorridos = `" + camion.getKmRecorridos() + "` ";
			
			}
			if(NoEsNulo(camion.getFechacompra()) && retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + "fecha_compra = `" + camion.getFechacompra() + "`";
			}
			else if(NoEsNulo(camion.getFechacompra()) && !retorno.equalsIgnoreCase("update camion")) {
				
				retorno = retorno + ", fecha_compra = `" + camion.getFechacompra() + "`";
			}
			retorno = retorno + "where id_camion = `" + camion.getId() + "`";
		}
		
		return retorno;
	}
	
	private static boolean NoEsNulo(String atributo) {
		if(atributo.isEmpty()) {
			return false;
		}
		
		return true;
	}

	
	private static boolean AtributosNoNulos(CamionDTO camion) {
		
		if(camion.getPatente().isEmpty() && camion.getCostoHora().isEmpty() && camion.getCostoKm().isEmpty() && camion.getFechacompra().isEmpty()
				&& camion.getKmRecorridos().isEmpty() && camion.getMarca().isEmpty() && camion.getModelo().isEmpty() ) {
			
			return false;
			
		}else return true;
		
	}

	
	public static ArrayList<Camion> BuscarCamion(CamionDTO camion) {
		ArrayList<Camion> Camiones = new ArrayList<>();
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		ResultSet rs = null;
		try {
			String consulta = ArmarConsultaBuscar(camion);

			PreparedStatement st = con.prepareStatement(consulta);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				Camion camion1 = new Camion(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getDouble(7), rs.getString(8));
				
				Camiones.add(camion1);
				
			}
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	

	public static void GuardarCamion(Camion c1) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		try {
			PreparedStatement st = con.prepareStatement("insert into camion (patente, km_recorridos, marca, modelo, costo_km, costo_hora, fecha_compra) values (?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, c1.getPatente());
			st.setDouble(2, c1.getKmRecorridos());
			st.setString(3, c1.getMarca());
			st.setString(4, c1.getModelo());
			st.setDouble(4, c1.getCostoKm());
			st.setDouble(6, c1.getCostoHora());
			st.setString(7, c1.getFechacompra());
		
			st.executeUpdate();
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			
	}
	
	public static void actualizarCamion(CamionDTO camion) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String Consulta = ArmarConsultaActualizar(camion);

			Statement st = con.createStatement();
			st.executeUpdate(Consulta);
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}  finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
