package imp.DAOs;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import imp.DTOs.InsumoDTO;
import imp.enumerators.UM;
import imp.gestores.DBManager;
import imp.primaryClasses.Insumo;
import imp.primaryClasses.InsumoGeneral;
import imp.primaryClasses.InsumoLiquido;
import imp.primaryClasses.Stock;


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
	
	public static ArrayList<Stock> buscarStockMenorPuntoPedido(){
		
		ArrayList<Stock> listaStock = new ArrayList<Stock>();
		
		DBManager dbm = DBManager.getInstance();
		Connection con = dbm.getConn();
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