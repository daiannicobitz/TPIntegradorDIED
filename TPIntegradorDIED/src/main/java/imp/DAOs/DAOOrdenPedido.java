package imp.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import imp.DTOs.CamionDTO;
import imp.DTOs.OrdenPedidoDTO;
import imp.enumerators.EstadoOrden;
import imp.gestores.DBManager;
import imp.primaryClasses.Camion;
import imp.primaryClasses.Item;
import imp.primaryClasses.ListaGlobalCamiones;
import imp.primaryClasses.OrdenPedido;

public class DAOOrdenPedido {
	
	public static long recupearUltimoOP() {

		long retorno = 0;
		DBManager gdb = DBManager.getInstance();
		Connection con = gdb.getConn();
		ResultSet rs = null;



		try {
			String Consulta = "select max(id_orden) from `ORDEN_PEDIDO`";
			PreparedStatement st = con.prepareStatement(Consulta);
			rs = st.executeQuery();


			while(rs.next()) {
				retorno = rs.getLong("max");
			}
			st.close();
		}
		catch (SQLException e) {
		}

		return retorno;
	}
	

	public static void guardarOrden(OrdenPedido ordenPedido) {
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		try {
			int id_planta = DAOPlanta.getIdPlanta(ordenPedido.getPlantaDestino());
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
			String dateSolicitud = dateFormat.format(ordenPedido.getFechaSolicitud());
			String dateEntrega = dateFormat.format(ordenPedido.getFechaEntrega());
			

			PreparedStatement st = con.prepareStatement("insert into `ORDEN_PEDIDO` (id_orden, id_planta_destino, fecha_solicitud, fecha_entrega, estado) values (?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, Long.toString(ordenPedido.getNumeroOrden()));
			st.setInt(2, id_planta);
			st.setString(3, dateSolicitud);
			st.setString(4, dateEntrega);
			st.setString(5, ordenPedido.getEstado().toString());
		
			st.executeUpdate();
			st.close();
			
			
			DAOItem.guardarItems(ordenPedido.getItems());
			
			
			JOptionPane.showMessageDialog(null, "La orden fue guardada en la base de datos, su estado es CREADA.", "Estado orden.", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Error, no se pudo guardar la informacion, intentelo nuevamente" , "Estado orden.", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado" , "Estado orden.", JOptionPane.INFORMATION_MESSAGE);
			
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
	}




	public static ArrayList<OrdenPedido> buscarOrdenesCreadas() {
		
		ArrayList<OrdenPedido> retorno_orden = new ArrayList<OrdenPedido>();
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		ResultSet rs = null;
		try {
			String consulta = "select * from `ORDEN_PEDIDO` WHERE `ESTADO` LIKE '%CREADA%'";

			PreparedStatement st = con.prepareStatement(consulta);
			rs = st.executeQuery();
			
			while(rs.next()) {
				long id_orden = rs.getLong(1); 
				int id_planta = rs.getInt(2);
				Date fSolicitud = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(3));
				Date fEntrega = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(4));

				
				//seteo id, fechas y estado.
				OrdenPedido orden1 = new OrdenPedido (id_orden, fSolicitud , fEntrega , EstadoOrden.CREADA); 
				
				//seteo nombre planta 
				String planta = DAOPlanta.getNombrePlanta(id_planta);
				orden1.setPlantaDestino(planta);
				
				//seteo Items
				ArrayList<Item> items = DAOItem.recuperarItemsPorIdOrden(id_orden);
				orden1.setItems(items);
				
				retorno_orden.add(orden1);
				
				
			}
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} catch (ParseException e) {
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
		
		
		return retorno_orden;
	}

	

	public static ArrayList<OrdenPedido> buscarOrdenesProcesadas() {
		
		ArrayList<OrdenPedido> retorno_orden = new ArrayList<OrdenPedido>();
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		ResultSet rs = null;
		try {
			String consulta = "select * from `ORDEN_PEDIDO` WHERE `ESTADO` LIKE '%PROCESADA%'";

			PreparedStatement st = con.prepareStatement(consulta);
			rs = st.executeQuery();
			
			while(rs.next()) {
				long id_orden = rs.getLong(1); 
				int id_planta = rs.getInt(2);
				Date fSolicitud = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(3));
				Date fEntrega = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString(4));

				
				//seteo id, fechas y estado.
				OrdenPedido orden1 = new OrdenPedido (id_orden, fSolicitud , fEntrega , EstadoOrden.PROCESADA); 
				
				//seteo nombre planta 
				String planta = DAOPlanta.getNombrePlanta(id_planta);
				orden1.setPlantaDestino(planta);
				
				//seteo Items
				ArrayList<Item> items = DAOItem.recuperarItemsPorIdOrden(id_orden);
				orden1.setItems(items);
				
				retorno_orden.add(orden1);
				
				
			}
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} catch (ParseException e) {
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
		
		
		return retorno_orden;
	}


	public static void actualizarOrdenAEntregada(OrdenPedidoDTO orden) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		
		try {
			String Consulta = "update `ORDEN_PEDIDO` set `ESTADO` = `ENTREGADA` where id_orden = " + orden.getNroOrden() + "";

			Statement st = con.createStatement();
			st.executeUpdate(Consulta);
			JOptionPane.showMessageDialog(null, "Se ha actualizado el estado de la orden", "Estado orden.", JOptionPane.INFORMATION_MESSAGE);
			
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
