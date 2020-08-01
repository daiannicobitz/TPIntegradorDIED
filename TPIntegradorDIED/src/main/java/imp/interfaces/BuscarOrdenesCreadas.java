package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BuscarOrdenesCreadas extends JPanel {

	public  BuscarOrdenesCreadas() {
		setBackground(new Color(118, 203, 117));
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 108, 772, 168);
		add(scrollPane);
		
		JTable tabla_ordenesCreadas = new JTable();
		tabla_ordenesCreadas.setBounds(42, 313, 626, -132);
		
		DefaultTableModel model_tabla_ordenesCreadas = new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"Nro. Orden", "Planta Destino", "Fecha Solicitud", "Fecha Entrega", "Estado"
				}
				){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
			}
		};
	
		tabla_ordenesCreadas.setModel(model_tabla_ordenesCreadas);
		tabla_ordenesCreadas.getTableHeader().setReorderingAllowed(false);
		tabla_ordenesCreadas.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(tabla_ordenesCreadas);
		
		JButton btn_verDetalle = new JButton("VER DETALLE DE ORDEN ");
		btn_verDetalle.setForeground(Color.BLACK);
		btn_verDetalle.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verDetalle.setFocusPainted(false);
		btn_verDetalle.setContentAreaFilled(true);
		btn_verDetalle.setBorderPainted(false);
		btn_verDetalle.setBackground(new Color(80, 165, 94));
		btn_verDetalle.setBounds(91, 338, 203, 41);
		add(btn_verDetalle);
		
		JButton btn_verPlantasStock = new JButton("VER PLANTAS CON STOCK");
		btn_verPlantasStock.setForeground(Color.BLACK);
		btn_verPlantasStock.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPlantasStock.setFocusPainted(false);
		btn_verPlantasStock.setContentAreaFilled(true);
		btn_verPlantasStock.setBorderPainted(false);
		btn_verPlantasStock.setBackground(new Color(80, 165, 94));
		btn_verPlantasStock.setBounds(380, 338, 203, 41);
		add(btn_verPlantasStock);
		
		JButton btn_verPosiblesRutas = new JButton("VER POSIBLES RUTAS");
		btn_verPosiblesRutas.setForeground(Color.BLACK);
		btn_verPosiblesRutas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_verPosiblesRutas.setFocusPainted(false);
		btn_verPosiblesRutas.setContentAreaFilled(true);
		btn_verPosiblesRutas.setBorderPainted(false);
		btn_verPosiblesRutas.setBackground(new Color(80, 165, 94));
		btn_verPosiblesRutas.setBounds(660, 338, 203, 41);
		add(btn_verPosiblesRutas);
		
		JButton btn_buscarOCreadas = new JButton("BUSCAR ORDENES ");
		btn_buscarOCreadas.setForeground(Color.BLACK);
		btn_buscarOCreadas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarOCreadas.setFocusPainted(false);
		btn_buscarOCreadas.setContentAreaFilled(true);
		btn_buscarOCreadas.setBorderPainted(false);
		btn_buscarOCreadas.setBackground(new Color(80, 165, 94));
		btn_buscarOCreadas.setBounds(91, 31, 156, 41);
		add(btn_buscarOCreadas);
	}
}
