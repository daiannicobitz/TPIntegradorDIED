package imp.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import imp.gestores.DBManager;
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

}
