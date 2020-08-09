package imp.DAOs;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imp.gestores.DBManager;
import imp.primaryClasses.Stock;


import java.sql.PreparedStatement;

import javax.swing.JOptionPane;




public class DAOStock {

	public static void guardarStock(Stock stock) {

		Connection con = DBManager.getConn();
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
	
	public static ArrayList<Stock> buscarStockMenorPuntoPedido(){
		
		ArrayList<Stock> listaStock = new ArrayList<Stock>();
		
		Connection con = DBManager.getConn();
		ResultSet tablaStock=null;
		
		String consulta = "select * from STOCK where cantidad < punto_pedido";
		
		Statement st;
		
		try {
			st = con.createStatement();
			tablaStock = st.executeQuery(consulta);
			
			while(tablaStock.next()) {
				
				Stock stock = new Stock(tablaStock.getInt("id_stock"), tablaStock.getInt("id_planta"), tablaStock.getDouble("cantidad"), 
						tablaStock.getDouble("punto_pedido"), tablaStock.getInt("id_insumo"));
				
				listaStock.add(stock);
				
			}
			
			st.close();
			con.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		
		
		return listaStock;
		
	}

}