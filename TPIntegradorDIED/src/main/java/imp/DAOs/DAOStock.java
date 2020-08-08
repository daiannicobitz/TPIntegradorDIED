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

public class DAOStock {

	public static void guardarStock(InsumoDTO insumodto) {
		// TODO Auto-generated method stub
		
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
						tablaStock.getDouble("punto_pedido"), DAOInsumo.buscarInsumosPorID(tablaStock.getInt("id_insumo")));
				
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