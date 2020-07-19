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
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
	}
	
	private static String ArmarConsulta(CamionDTO camion) {
		
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
        String strDate = dateFormat.format(camion.getFechacompra()); 

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
			if(NoEsNulo(strDate) && retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "fecha_compra LIKE `%" + strDate + "%`";
			}
			else if(NoEsNulo(strDate) && !retorno.equalsIgnoreCase("select * from camion where")) {
				
				retorno = retorno + "and fecha_compra LIKE `%" + strDate + "%`";
			}
			
		}
		
		return retorno;
	}

	
	private static boolean NoEsNulo(String atributo) {

		if(atributo == null) {
			return false;
		}
		
		return true;
	}

	private static boolean AtributosNoNulos(CamionDTO camion) {
		
		if(camion.getPatente().isEmpty() && camion.getCostoHora().isEmpty() && camion.getCostoKm().isEmpty() && camion.getFechacompra() == null 
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
			String consulta = ArmarConsulta(camion);

			PreparedStatement st = con.prepareStatement(consulta);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				Camion camion1 = new Camion(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getDouble(7), rs.getDate(8));
				
				Camiones.add(camion1);
				
			}
			
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return null;
	}
	
	

	public static void GuardarCamion(Camion c1) {
		// TODO Auto-generated method stub
		
	}

	
	public static void actualizarCamion(Camion camion) {
		// TODO Auto-generated method stub
		
	}

}
