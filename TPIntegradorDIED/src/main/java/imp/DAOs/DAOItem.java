package imp.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import imp.gestores.DBManager;
import imp.primaryClasses.Item;


public class DAOItem {

	public static void guardarItems(ArrayList<Item> items, Connection con) {
		try {

			
			
			for (Item i : items) {
				
				PreparedStatement st = con.prepareStatement("insert into `ITEM` (id_insumo, id_orden, cantidad_solicitada) values (?, ?, ?)");
				st.setInt(1, i.getIdInsumo());
				st.setInt(2, i.getIdOrden());
				st.setDouble(3, i.getCantidadSolicitada());
				
				st.executeUpdate();
				st.close();
				
			}
			
			JOptionPane.showMessageDialog(null, "Los items se almacenaron correctamente.", "Estado items.", JOptionPane.INFORMATION_MESSAGE);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar los items, intente nuevamente." , "Estado items.", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}

	public static ArrayList<Item> recuperarItemsPorIdOrden(long idOrden) {
		
//		long idOrden = op.getNumeroOrden();
		ArrayList<Item> retorno = new ArrayList<>();
		
		Connection con = DBManager.getConn();
		ResultSet rs = null;

		try {
			
			String Consulta = "select * from `ITEM` where id_orden = " + idOrden;
			PreparedStatement st = con.prepareStatement(Consulta);
			rs = st.executeQuery();
			
			while(rs.next()) {
				//int idInsumo, double cantidadSolicitada, int idOrden
				Item item = new Item(rs.getInt(2),rs.getDouble(4),rs.getInt(3));
				retorno.add(item);	
			}
			st.close();
			con.close();
		}
		catch (SQLException e) {
		}

		return retorno;

	}
	
}
