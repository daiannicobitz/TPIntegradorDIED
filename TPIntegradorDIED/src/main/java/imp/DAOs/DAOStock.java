package imp.DAOs;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import imp.gestores.DBManager;
import imp.primaryClasses.Stock;


public class DAOStock {

	public static void guardarStock(Stock stock) {

		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
		try {
			PreparedStatement st = con.prepareStatement("insert into `STOCK` (id_planta, id_insumo, cantidad, punto_pedido) values (?, ?, ?, ?)");
			st.setInt(1, stock.getIdPlanta());
			st.setInt(2, stock.getInsumo());
			st.setDouble(3, stock.getCantidad());
			st.setDouble(4, stock.getPuntoPedido());
			
			st.executeUpdate();
			st.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado" , "Stock.", JOptionPane.INFORMATION_MESSAGE);
			
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
