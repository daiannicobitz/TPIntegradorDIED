package imp.interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BuscarOrdenesProcesadas extends JPanel {
	
	public BuscarOrdenesProcesadas() {
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
		
		JButton btn_marcarEntregadas = new JButton("MARCAR COMO ENTREGADAS");
		btn_marcarEntregadas.setForeground(Color.BLACK);
		btn_marcarEntregadas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_marcarEntregadas.setFocusPainted(false);
		btn_marcarEntregadas.setContentAreaFilled(true);
		btn_marcarEntregadas.setBorderPainted(false);
		btn_marcarEntregadas.setBackground(new Color(80, 165, 94));
		btn_marcarEntregadas.setBounds(660, 318, 203, 41);
		add(btn_marcarEntregadas);
	
		
		JButton btn_buscarOProcesadas = new JButton("BUSCAR ORDENES ");
		btn_buscarOProcesadas.setForeground(Color.BLACK);
		btn_buscarOProcesadas.setFont(new Font("Dialog", Font.ITALIC, 11));
		btn_buscarOProcesadas.setFocusPainted(false);
		btn_buscarOProcesadas.setContentAreaFilled(true);
		btn_buscarOProcesadas.setBorderPainted(false);
		btn_buscarOProcesadas.setBackground(new Color(80, 165, 94));
		btn_buscarOProcesadas.setBounds(91, 31, 156, 41);
		add(btn_buscarOProcesadas);
	}

}
